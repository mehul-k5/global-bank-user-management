package com.example.bankusermanagementbackend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankusermanagementbackend.model.branch_master;

@Repository
public interface branch_masterDao extends JpaRepository<branch_master,String> {
	
}
