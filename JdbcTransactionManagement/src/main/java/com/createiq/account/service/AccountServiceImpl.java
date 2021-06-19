package com.createiq.account.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.createiq.account.dao.AccountDao;
import com.createiq.account.dao.AccountDaoImpl;
import com.createiq.account.model.Account;
import com.createiq.account.util.ConnectionUtil;

public class AccountServiceImpl implements AccountService {
	AccountDao accountDao = new AccountDaoImpl();

	@Override
	public void fundTransfer(Account fromAccount, Account toAccount, Double amount) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		// level only prohibits a transaction from reading a row with uncommitted
		// changes in it.
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		try {
			connection.setAutoCommit(false);

			accountDao.withdraw(connection, fromAccount, toAccount, amount);
			accountDao.deposit(connection, fromAccount, toAccount, amount);

			connection.commit();

		} catch (Exception e) {
			if (connection != null) {
				connection.rollback();
			}
			// e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	// Without handling transaction
	/*
	 * @Override public void fundTransfer(Account fromAccount, Account toAccount,
	 * Double amount) throws SQLException, AccountNotFoundException,
	 * InsufficientBalanceException { Connection connection =
	 * ConnectionUtil.getConnection(); accountDao.withdraw(connection, fromAccount,
	 * toAccount, amount); accountDao.deposit(connection, fromAccount, toAccount,
	 * amount); }
	 */
}
