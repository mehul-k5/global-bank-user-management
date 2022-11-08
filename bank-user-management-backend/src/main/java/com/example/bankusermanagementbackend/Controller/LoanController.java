package com.example.bankusermanagementbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
