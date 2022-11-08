package com.example.bankusermanagementbackend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.transaction_detailsDao;
import com.example.bankusermanagementbackend.model.TransactionDetails;
import com.example.bankusermanagementbackend.model.ViewStatementDTO;

@Service
public class ViewStatementService {
	@Autowired
	transaction_detailsDao transactionDao;
	
	public List<TransactionDetails> getTransactionDetailsByFilter(ViewStatementDTO vs_details){
		String all = "All";
		if(all.equals(vs_details.getType_of_transaction())) {
			return transactionDao.getAllTransactionsbetweenDates(vs_details.getAccount_number(), vs_details.getFromDate(), vs_details.getToDate());
		}
		return transactionDao.getTypeofTransactionsbetweenDates(vs_details.getAccount_number(), vs_details.getType_of_transaction(), vs_details.getFromDate(), vs_details.getToDate());
	}
}
