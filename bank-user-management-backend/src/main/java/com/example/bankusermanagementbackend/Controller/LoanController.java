package com.example.bankusermanagementbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankusermanagementbackend.Service.LoanApplicationService;
import com.example.bankusermanagementbackend.Service.accountService;
import com.example.bankusermanagementbackend.model.LoanDetails;

@RestController
@CrossOrigin
public class LoanController {
	
	@Autowired 
	LoanApplicationService loan_serv;
	@Autowired
	accountService acc_serv;
	
	@PostMapping("/apply")
	public boolean addApplication(@RequestBody LoanDetails application) {
		if(acc_serv.customerHasAccount(application.getCustomer_number())) {
			if(loan_serv.insertApplication(application)) {
			return true;
			}
			else {
				return false;
			}
		}
		else
			return false;
	}
	
	@GetMapping("/getAllLoans/{cust_no}")
	public List<LoanDetails> getAllLoans(@PathVariable("cust_no") String cust_no){
		return loan_serv.getAppliedLoans(cust_no);
	}

}
