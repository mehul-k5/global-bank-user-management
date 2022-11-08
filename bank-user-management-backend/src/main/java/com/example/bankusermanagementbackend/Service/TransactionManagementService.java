package com.example.bankusermanagementbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.transaction_detailsDao;
import com.example.bankusermanagementbackend.model.TransactionDetails;

@Service
public class TransactionManagementService {
	@Autowired
	transaction_detailsDao transactionDao;
	public boolean insertTransaction(TransactionDetails transaction) {
		if(transactionDao.save(transaction) != null)
		{
		   return true;
			
		}
		else
			return false;
	}
}
