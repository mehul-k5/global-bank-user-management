package com.example.bankusermanagementbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.account_masterDao;
import com.example.bankusermanagementbackend.model.AccountMaster;

@Service
public class accountService {
	@Autowired
	account_masterDao accountDao;
	
	public boolean customerHasAccount(String cust_no) {
		List<AccountMaster> accs=accountDao.findAll();
		for(AccountMaster a:accs) {
			if(a.getCustomer_number().equals(cust_no)) {
				return true;
			}
		}
		return false;
	}
}
