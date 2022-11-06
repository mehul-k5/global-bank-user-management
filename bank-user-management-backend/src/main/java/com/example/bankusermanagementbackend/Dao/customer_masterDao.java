package com.example.bankusermanagementbackend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankusermanagementbackend.model.customer_master;

@Repository
public interface customer_masterDao extends JpaRepository<customer_master,String>{

}
