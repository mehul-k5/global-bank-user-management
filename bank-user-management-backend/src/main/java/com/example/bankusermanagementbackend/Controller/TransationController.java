package com.example.bankusermanagementbackend.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public Map<String,String> addTransaction(@RequestBody TransactionDetails transaction) {
		Map<String,String> res=new HashMap<String,String>();
		if(trans_serv.insertTransaction(transaction)) {
			Long balance;
			if(transaction.getTransaction_type().equals("deposit")) {
				  balance= acc_serv.creditAmount(transaction.getAccount_number(),transaction.getTransaction_amount());
			   }
			   else {
				  balance= acc_serv.debitAmount(transaction.getAccount_number(),transaction.getTransaction_amount());
			   }
			res.put("status","true");
			res.put("balance",""+balance);
			return res;
			
		}
		else {
			res.put("status","false");
			return res;
			
		}
	}
	

}
