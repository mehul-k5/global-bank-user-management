package com.example.bankusermanagementbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan_details")
public class loan_details {
	@Id
	String customer_number;
	@Column
	String branch_id;
	@Column 
	long loan_amount;
	
}
