package com.example.bankusermanagementbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankusermanagementbackend.Service.LoginService;
import com.example.bankusermanagementbackend.model.User;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	LoginService loginServ;
	
	@PostMapping("/login")
	public String validate(@RequestBody User user) {
		if(loginServ.validateUser(user)) {
			return "successful";
		}
		else 
			return "failed";
	}

}