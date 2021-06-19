package com.createiq.account.service;

import java.sql.SQLException;

import com.createiq.account.exception.AccountNotFoundException;
import com.createiq.account.exception.InsufficientBalanceException;
import com.createiq.account.model.Account;

public interface AccountService {
	public void fundTransfer(Account fromAccount, Account toAccount, Double amount)
			throws SQLException, AccountNotFoundException, InsufficientBalanceException;
}
