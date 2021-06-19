package com.createiq.account.controller;

import java.sql.SQLException;

import com.createiq.account.exception.AccountNotFoundException;
import com.createiq.account.exception.InsufficientBalanceException;
import com.createiq.account.model.Account;
import com.createiq.account.service.AccountService;
import com.createiq.account.service.AccountServiceImpl;

public class AccountController {
	public static void main(String[] args) {

		AccountService accountService = new AccountServiceImpl();

		Double transferAmout = 1000.00;
		Account fromAccount = new Account();
		fromAccount.setAccountNumber(9876835861L);

		Account toAccount = new Account();
		toAccount.setAccountNumber(9876598791L);

		try {
			accountService.fundTransfer(fromAccount, toAccount, transferAmout);
		} catch (SQLException | AccountNotFoundException | InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}
}
