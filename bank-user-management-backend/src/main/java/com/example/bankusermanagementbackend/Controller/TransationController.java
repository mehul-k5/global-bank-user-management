package com.example.bankusermanagementbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankusermanagementbackend.Service.TransactionManagementService;
import com.example.bankusermanagementbackend.Service.accountService;
import com.example.bankusermanagementbackend.model.TransactionDetails;

@RestController
@CrossOrigin
public class TransationController {
	@Autowired
	TransactionManagementService trans_serv;
	@Autowired
	accountService acc_serv;
	
	
	@PostMapping("/transaction")
	public boolean addTransaction(@RequestBody TransactionDetails transaction) {
		if(trans_serv.insertTransaction(transaction)) {
			return true;
		}
		else
			return false;
	}
	

}
