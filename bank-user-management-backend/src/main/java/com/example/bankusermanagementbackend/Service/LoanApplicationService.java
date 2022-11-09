package com.example.bankusermanagementbackend.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.Loan_detailsDao;
import com.example.bankusermanagementbackend.model.LoanDetails;

@Service
public class LoanApplicationService {
	@Autowired
	Loan_detailsDao loanDao;
	
	public boolean insertApplication(LoanDetails application) {
		if(loanDao.save(application) != null)
		{
		   return true;
			
		}
		else
			return false;
	}
	
	public List<LoanDetails> getAppliedLoans(String cust_no){
		List<LoanDetails> loans=loanDao.findAll();
		List<LoanDetails> appliedLoans=new ArrayList();
		for(LoanDetails l:loans) {
			if(l.getCustomer_number().equals(cust_no)) {
				appliedLoans.add(l);
			}
		}
		return appliedLoans;
	}

}
