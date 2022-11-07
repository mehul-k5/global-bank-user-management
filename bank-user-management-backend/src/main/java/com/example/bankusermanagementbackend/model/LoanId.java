package com.example.bankusermanagementbackend.model;

import java.io.Serializable;

public class LoanId implements Serializable {
	private String customer_number;
	private String branch_id;
	public LoanId(String customer_number, String branch_id) {
		super();
		this.customer_number = customer_number;
		this.branch_id = branch_id;
	}
	public LoanId() {
		
	}
}
