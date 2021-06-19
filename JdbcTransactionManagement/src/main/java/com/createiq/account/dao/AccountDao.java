package com.createiq.account.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.createiq.account.exception.AccountNotFoundException;
import com.createiq.account.exception.InsufficientBalanceException;
import com.createiq.account.model.Account;

public interface AccountDao {

	public void withdraw(Connection connection, Account fromAccount, Account toAccount, Double amount)
			throws SQLException, AccountNotFoundException, InsufficientBalanceException;

	public void deposit(Connection connection, Account fromAccount, Account toAccount, Double amount)
			throws SQLException, AccountNotFoundException;

	Account save(Connection connection, Account account);

	Account update(Connection connection, Account account);

	List<Account> findAll();

	void delete(int id);

}
