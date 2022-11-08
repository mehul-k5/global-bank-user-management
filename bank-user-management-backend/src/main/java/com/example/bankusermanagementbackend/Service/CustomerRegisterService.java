package com.example.bankusermanagementbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.customer_masterDao;
import com.example.bankusermanagementbackend.model.CustomerMaster;

@Service
public class CustomerRegisterService {
	@Autowired
	customer_masterDao cust_dao;
	
	
	
	public CustomerMaster insertCustomer(CustomerMaster cust) {
		return cust_dao.save(cust);
	}
	
}
