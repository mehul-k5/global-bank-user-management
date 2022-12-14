package com.example.bankusermanagementbackend.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="transaction_details")
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int transaction_number;
	@Column
	String account_number;
	@Column
	Date date_of_transaction;
	@Column
	String medium_of_transaction;
	@Column
	String transaction_type;
	@Column
	int transaction_amount;
	
	public void setTransaction_number(int transaction_number) {
		this.transaction_number = transaction_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public void setDate_of_transaction(Date date_of_transaction) {
		this.date_of_transaction = date_of_transaction;
	}
	public void setMedium_of_transaction(String medium_of_transaction) {
		this.medium_of_transaction = medium_of_transaction;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	
	public int getTransaction_number() {
		return this.transaction_number;
	}
	public String getAccount_number() {
		return this.account_number;
	}
	public Date getDate_of_transaction() {
		return this.date_of_transaction;
	}
	public String getMedium_of_transaction() {
		return this.medium_of_transaction;
	}
	public String getTransaction_type() {
		return this.transaction_type;
	}
	public int getTransaction_amount() {
		return this.transaction_amount;
	}
	
	public TransactionDetails(int transaction_number, String account_number, 
			Date date_of_transaction, String medium_of_transaction, String transaction_type, int transaction_amount) {
		super();
		this.transaction_number = transaction_number;
		this.account_number = account_number;
		this.date_of_transaction = date_of_transaction;
		this.medium_of_transaction = medium_of_transaction;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
	}
	
	public TransactionDetails(){
		
	}
	

}

