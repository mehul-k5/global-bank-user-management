package com.example.bankusermanagementbackend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankusermanagementbackend.model.AccountMaster;

@Repository
public interface account_masterDao extends JpaRepository<AccountMaster,String>{

}
