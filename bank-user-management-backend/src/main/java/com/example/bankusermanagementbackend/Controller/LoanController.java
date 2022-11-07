package com.example.bankusermanagementbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankusermanagementbackend.Service.LoanApplicationService;
import com.example.bankusermanagementbackend.model.loan_details;

@RestController
@CrossOrigin
public class LoanController {
	
	@Autowired 
	LoanApplicationService loan_serv;
	
	@PostMapping("/apply")
	public boolean addApplication(@RequestBody loan_details application) {
		if(loan_serv.insertApplication(application)) {
			return true;
		}
		else
			return false;
	}

}
