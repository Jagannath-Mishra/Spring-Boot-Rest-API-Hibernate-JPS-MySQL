package com.springexmple.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexmple.springdemo.entity.User;
import com.springexmple.springdemo.repository.UserRepository;

@Service("authService")
public class AuthServiceImpl implements AuthService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean getAuth(String username, String password) {
		
		User dbUser =  userRepository.findByUsername(username);
		
		if(dbUser.getPassword().equals(password))
			return true;
		
		return false;
	}

}