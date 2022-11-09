package com.example.bankusermanagementbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.account_masterDao;
import com.example.bankusermanagementbackend.model.AccountMaster;

@Service
public class accountService {
	private static final int Long = 0;
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
	public Long creditAmount(String account_number,int amount) {
		System.out.println(account_number);
		Optional<AccountMaster> a=accountDao.findById(account_number);
		if(a.isPresent()) {
			AccountMaster acc=a.get();
			acc.setCurrent_balance(acc.getCurrent_balance()+amount);
			accountDao.save(acc);
			return acc.getCurrent_balance();
		}
		return (long) ((Long)-1);
	}
	public Long debitAmount(String account_number,int amount) {
		Optional<AccountMaster> a=accountDao.findById(account_number);
		if(a.isPresent()) {
			AccountMaster acc=a.get();
			acc.setCurrent_balance(acc.getCurrent_balance()-amount);
			accountDao.save(acc);
			return acc.getCurrent_balance();
		}
		return (long) ((Long)-1);
	}
}
