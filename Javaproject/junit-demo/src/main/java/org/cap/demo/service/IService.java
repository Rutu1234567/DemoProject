package org.cap.demo.service;

import org.cap.demo.model.Account;
import org.cap.demo.model.Customer;
import org.cap.demo.util.InSufficientOpeningbalanceException;

public interface IService {
	
	public int sumOfNumbers(int n);
	public Account createAccount(Customer customer,double amount)  throws InSufficientOpeningbalanceException;
	public int sumOfArray(int[] a);
}
