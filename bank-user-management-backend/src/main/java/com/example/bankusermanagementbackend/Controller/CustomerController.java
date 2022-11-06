package com.example.bankusermanagementbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankusermanagementbackend.Service.CustomerRegisterService;
import com.example.bankusermanagementbackend.Service.LoginService;
import com.example.bankusermanagementbackend.model.User;
import com.example.bankusermanagementbackend.model.customer_master;
@RestController
@CrossOrigin
public class CustomerController {
	@Autowired
	CustomerRegisterService custServ;
	@Autowired
	LoginService log_serv;

	@PostMapping("/register/{password}")
	public customer_master addCustomer(@RequestBody customer_master cust,@PathVariable("password") String password) {
		
		customer_master c=custServ.insertCustomer(cust);
		System.out.println(cust.getCustomer_number());
		log_serv.add(new User(cust.getCustomer_number(),password));
		return c;
		
	}
}
