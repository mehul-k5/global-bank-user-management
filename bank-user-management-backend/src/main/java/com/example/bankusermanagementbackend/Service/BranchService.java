package com.example.bankusermanagementbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.branch_masterDao;
import com.example.bankusermanagementbackend.model.BranchMaster;

@Service
public class BranchService {
	
	@Autowired
	branch_masterDao branchDao;
	
	public List<BranchMaster> getBranches(){
		return branchDao.findAll();
	}

}
