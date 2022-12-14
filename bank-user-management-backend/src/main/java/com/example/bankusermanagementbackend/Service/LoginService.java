package com.example.bankusermanagementbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankusermanagementbackend.Dao.UserDao;
import com.example.bankusermanagementbackend.model.User;

@Service
public class LoginService {
	@Autowired
	UserDao userdao;
	
	public boolean validateUser(User user) {
		List<User> u=userdao.findAll();
		for(User us:u) {
			if(us.getUserId().equals(user.getUserId())&&us.getPassword().equals(user.getPassword()))
				return true;
		}
		
		return false;
	}
	public void add(User user) {
		userdao.save(user);
	}

}
