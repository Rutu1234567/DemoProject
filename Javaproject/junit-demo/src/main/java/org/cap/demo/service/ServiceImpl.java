package org.cap.demo.service;

import org.cap.demo.dao.IAccountDao;
import org.cap.demo.model.Account;
import org.cap.demo.model.Customer;
import org.cap.demo.util.InSufficientOpeningbalanceException;
import org.cap.demo.util.Util;

public class ServiceImpl implements IService{
	
	private IAccountDao accountDao;
	
	public ServiceImpl() {
		
	}

	
	public ServiceImpl(IAccountDao accountDao) {
		this.accountDao=accountDao;
	}

	@Override
	public int sumOfNumbers(int n) {
		int sum=0;
		for(int i=1;i<=n;i++)
			sum+=i;
		return sum;
	}

	@Override
	public Account createAccount(Customer customer, double amount) throws InSufficientOpeningbalanceException {
		
		if(customer==null)
			throw new IllegalArgumentException("Customer Object should not be null!");
		if(amount<1000)
			throw new InSufficientOpeningbalanceException("Opening balance must be greater than 1000.");
		
		Account account=new Account();
		account.setCustomer(customer);
		account.setAmount(amount);
		account.setAccountNo(Util.generateAccountNo());
		
		if(accountDao.addAccount(account))
			return account;
		
		return null;
	}

	@Override
	public int sumOfArray(int[] a) {
		int sum=0;
		for(int n: a) {
			sum +=n;
		}
		return sum;
	}
}
