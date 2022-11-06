package com.example.bankusermanagementbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.customer_masterDao;
import com.example.bankusermanagementbackend.model.customer_master;

@Service
public class CustomerRegisterService {
	@Autowired
	customer_masterDao cust_dao;
	
	
	
	public customer_master insertCustomer(customer_master cust) {
		return cust_dao.save(cust);
	}
	
}
