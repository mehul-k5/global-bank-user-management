package com.example.bankusermanagementbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.account_masterDao;
import com.example.bankusermanagementbackend.model.account_master;

@Service
public class accountService {
	@Autowired
	account_masterDao accountDao;
	
	public boolean customerHasAccount(String cust_no) {
		List<account_master> accs=accountDao.findAll();
		for(account_master a:accs) {
			if(a.getCustomer_number().equals(cust_no)) {
				return true;
			}
		}
		return false;
	}
}
