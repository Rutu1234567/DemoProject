package org.cap.demo.model;

import java.util.Objects;

public class Account {
	private int accountNo;
	private Customer customer;
	private double amount;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account(int accountNo, Customer customer, double amount) {
		super();
		this.accountNo = accountNo;
		this.customer = customer;
		this.amount = amount;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", customer=" + customer + ", amount=" + amount + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNo, amount, customer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accountNo == other.accountNo && Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(customer, other.customer);
	}
	
	

}
