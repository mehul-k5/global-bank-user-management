package com.example.bankusermanagementbackend.model;

import java.sql.Date;

public class ViewStatementDTO {
	String account_number;
	String type_of_transaction;
	Date fromDate;
	Date toDate;
	
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public void setType_of_transaction(String type_of_transaction) {
		this.type_of_transaction = type_of_transaction;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public String getAccount_number() {
		return this.account_number;
	}
	public String getType_of_transaction() {
		return this.type_of_transaction;
	}
	public Date getFromDate() {
		return this.fromDate;
	}
	public Date getToDate() {
		return this.toDate;
	}
	public ViewStatementDTO(String account_number, String type_of_transaction, Date fromDate, Date toDate) {
		this.account_number = account_number;
		this.type_of_transaction = type_of_transaction;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public ViewStatementDTO() {
		
	}
}
