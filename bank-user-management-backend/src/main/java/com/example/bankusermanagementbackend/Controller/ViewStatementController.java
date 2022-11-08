package com.example.bankusermanagementbackend.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankusermanagementbackend.model.TransactionDetails;
import com.example.bankusermanagementbackend.model.ViewStatementDTO;
import com.example.bankusermanagementbackend.Service.ViewStatementService;

@RestController
@CrossOrigin
public class ViewStatementController {
	@Autowired
	ViewStatementService vs_serv;
	
	@PostMapping("/statement")
	public List<TransactionDetails> viewStatementTransactions(@RequestBody ViewStatementDTO vs_details) {
		if(vs_details.getFromDate().compareTo(vs_details.getToDate()) > 0 ) {
			return null;
		}
		return vs_serv.getTransactionDetailsByFilter(vs_details);
	}
}
