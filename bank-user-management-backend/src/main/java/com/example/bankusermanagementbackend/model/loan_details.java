package com.example.bankusermanagementbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(LoanId.class)
@Table(name="loan_details")
public class loan_details {
	@Id
	String customer_number;
	@Id
	String branch_id;
	@Column 
	long loan_amount;
	public loan_details(String customer_number, String branch_id, long loan_amount) {
		super();
		this.customer_number = customer_number;
		this.branch_id = branch_id;
		this.loan_amount = loan_amount;
	}
	public String getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public long getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(long loan_amount) {
		this.loan_amount = loan_amount;
	}
	public loan_details() {
		
	}
}
