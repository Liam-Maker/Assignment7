package models;

import java.io.FileReader;
import java.text.ParseException;
import java.util.Date;
import java.util.StringTokenizer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass

public abstract class BankAccount {

	private  double balance;
	private  double interestRate;
	private  long accountNumber;
	private  java.util.Date date;
	
	public BankAccount(){
	
	}
	public BankAccount(double balance, double interestRate) {
		this.balance=balance;
		this.interestRate = interestRate;
	}
	public BankAccount(double balance,double interestRate,java.util.Date accountOpenedOn) {
		this.balance=balance;
		this.interestRate = interestRate;
		this.date = accountOpenedOn;
	}
	public BankAccount(long accountNumber, double balance, double interestRate,java.util.Date accountOpenedOn) {
		this.accountNumber= accountNumber;
		this.balance=balance;
		this.interestRate = interestRate;
		this.date = accountOpenedOn;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public  java.util.Date getOpenedOn(){
		return this.date;
	}	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return this.interestRate;
	}

}