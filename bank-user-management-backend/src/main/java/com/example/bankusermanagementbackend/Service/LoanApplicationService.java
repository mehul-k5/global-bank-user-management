package com.example.bankusermanagementbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.Loan_detailsDao;
import com.example.bankusermanagementbackend.model.loan_details;

@Service
public class LoanApplicationService {
	@Autowired
	Loan_detailsDao loanDao;
	
	public boolean insertApplication(loan_details application) {
		if(loanDao.save(application) != null)
		{
		   return true;
			
		}
		else
			return false;
	}
	

}
