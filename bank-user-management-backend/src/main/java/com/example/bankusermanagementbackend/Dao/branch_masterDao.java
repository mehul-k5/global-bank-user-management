package com.example.bankusermanagementbackend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankusermanagementbackend.model.BranchMaster;


@Repository
public interface branch_masterDao extends JpaRepository<BranchMaster,String> {
	
}
