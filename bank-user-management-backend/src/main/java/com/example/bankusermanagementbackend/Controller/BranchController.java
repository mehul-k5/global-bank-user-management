package com.example.bankusermanagementbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankusermanagementbackend.Service.BranchService;
import com.example.bankusermanagementbackend.model.branch_master;

@RestController
@CrossOrigin
public class BranchController {
	@Autowired
	BranchService br_serv;
	
	@GetMapping("/branches")
	public List<branch_master> getAllBranches(){
		return br_serv.getBranches();
	}
}
