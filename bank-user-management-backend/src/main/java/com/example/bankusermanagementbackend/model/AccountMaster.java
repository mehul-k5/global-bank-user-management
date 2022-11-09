package com.example.bankusermanagementbackend.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_master")
public class AccountMaster {
	@Id
	String account_number;
	@Column
	String customer_number;
	@Column
	String branch_id;
	@Column
	Long opening_balance;
	@Column
	Date account_opening_date;
	@Column
	String account_type;
	@Column
	String account_status;
	@Column
	Long current_balance;
	public AccountMaster() {
		
	}
	public AccountMaster(String account_number, String customer_number, String branch_id, Long opening_balance,
			Date account_opening_date, String account_type, String account_status,Long current_balance) {
		super();
		this.account_number = account_number;
		this.customer_number = customer_number;
		this.branch_id = branch_id;
		this.opening_balance = opening_balance;
		this.account_opening_date = account_opening_date;
		this.account_type = account_type;
		this.account_status = account_status;
		this.current_balance=current_balance;
	}
	public Long getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(Long current_balance) {
		this.current_balance = current_balance;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
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
	public Long getOpening_balance() {
		return opening_balance;
	}
	public void setOpening_balance(Long opening_balance) {
		this.opening_balance = opening_balance;
	}
	public Date getAccount_opening_date() {
		return account_opening_date;
	}
	public void setAccount_opening_date(Date account_opening_date) {
		this.account_opening_date = account_opening_date;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
}
