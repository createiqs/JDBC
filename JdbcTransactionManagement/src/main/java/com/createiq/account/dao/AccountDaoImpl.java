package com.createiq.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.createiq.account.exception.AccountNotFoundException;
import com.createiq.account.exception.InsufficientBalanceException;
import com.createiq.account.model.Account;
import com.createiq.account.queries.AccountSqlQueries;
import com.createiq.account.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	private final String UPDATE_ACCOUNT_SQL = "UPDATE Account set account_balance = ? WHERE account_no=?";

	@Override
	public void withdraw(Connection connection, Account fromAccount, Account toAccount, Double amount)
			throws SQLException, AccountNotFoundException, InsufficientBalanceException {
		Account fromAccountFromDb = getCurrentAccountDetail(connection, fromAccount.getAccountNumber());
		if (fromAccountFromDb != null) {
			if (fromAccountFromDb.getAccountBalance() < amount) {
				throw new InsufficientBalanceException("Insufficient funds");
			}
		} else {
			throw new AccountNotFoundException("Source account doesn't exist..");
		}

		PreparedStatement ps = connection.prepareStatement(UPDATE_ACCOUNT_SQL);
		Double updateBalance = fromAccountFromDb.getAccountBalance() - amount;

		ps.setDouble(1, updateBalance);
		ps.setLong(2, fromAccount.getAccountNumber());

		int executeUpdate = ps.executeUpdate();
		if (executeUpdate == 1) {
			System.out.println("Amount $" + amount + " is transferred from account:" + fromAccount.getAccountNumber()
					+ " to account:" + toAccount.getAccountNumber());
		}
	}

	@Override
	public void deposit(Connection connection, Account fromAccount, Account toAccount, Double amount)
			throws SQLException, AccountNotFoundException {
		Account toAccountFromDb = getCurrentAccountDetail(connection, toAccount.getAccountNumber());
		if (toAccountFromDb == null)
			throw new AccountNotFoundException("Destination account doesn't exist..");

		PreparedStatement ps = connection.prepareStatement(UPDATE_ACCOUNT_SQL);
		Double updateBalance = toAccountFromDb.getAccountBalance() + amount;

		ps.setDouble(1, updateBalance);
		ps.setLong(2, toAccount.getAccountNumber());

		int executeUpdate = ps.executeUpdate();
		if (executeUpdate == 1) {
			System.out.println("Amount $" + amount + " is deposited in account:" + toAccount.getAccountNumber());
		}
	}

	private Account getCurrentAccountDetail(Connection connection, Long fromAccountNumber) throws SQLException {
		String GET_ACCOUNT_SQL = "SELECT *FROM citi_bank WHERE account_no=?";
		try (PreparedStatement ps = connection.prepareStatement(GET_ACCOUNT_SQL)) {
			ps.setLong(1, fromAccountNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Account account = new Account();
				account.setAccountNumber(rs.getLong("account_no"));
				account.setAccountBalance(rs.getDouble("account_balance"));
				account.setAccountHolderName(rs.getString("account_holder_name"));
				account.setAccountType(rs.getString("account_type"));
				return account;
			}
		}
		return null;
	}

	@Override
	public Account save(Connection connection, Account account) {
		try (PreparedStatement ps = connection.prepareStatement(AccountSqlQueries.INSERT_SQL);) {

			ps.setLong(1, account.getAccountNumber());
			ps.setString(2, account.getAccountHolderName());
			ps.setDouble(3, account.getAccountBalance());
			ps.setString(4, account.getAccountType());
			int result = ps.executeUpdate();
			System.out.println(result + " inserted....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public Account update(Connection connection, Account account) {
		try (PreparedStatement ps = connection.prepareStatement(AccountSqlQueries.UPDATE_SQL);) {

			ps.setString(1, account.getAccountHolderName());
			ps.setString(2, account.getAccountType());
			int result = ps.executeUpdate();
			System.out.println(result + " updated....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(AccountSqlQueries.SELECT_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Account account = new Account();
				account.setAccountNumber(rs.getLong(1));
				account.setAccountHolderName(rs.getString(2));
				account.setAccountType(rs.getString(3));
				account.setAccountBalance(rs.getDouble(4));
				accounts.add(account);
			}
			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(int id) {

	}

}
