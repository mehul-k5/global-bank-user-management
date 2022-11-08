package com.example.bankusermanagementbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankusermanagementbackend.Service.BranchService;
import com.example.bankusermanagementbackend.model.BranchMaster;


@RestController
@CrossOrigin
public class BranchController {
	@Autowired
	BranchService br_serv;
	
	@GetMapping("/branches")
	public List<BranchMaster> getAllBranches(){
		return br_serv.getBranches();
	}
}
