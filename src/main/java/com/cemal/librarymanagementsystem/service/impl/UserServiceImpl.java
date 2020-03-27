package com.cemal.librarymanagementsystem.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cemal.librarymanagementsystem.dto.RegistrationRequest;
import com.cemal.librarymanagementsystem.entity.User;
import com.cemal.librarymanagementsystem.repository.UserRepository;
import com.cemal.librarymanagementsystem.service.UserDetailService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl  implements UserDetailService {
	  @Autowired
	private final UserRepository userRepository;
	  @Autowired
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	
	
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
	
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}



	@Override
	public User getByUsername(String username) {
		 User u = userRepository.findByUsername(username);
		return u;
	}
	 @Transactional
	    public Boolean register(RegistrationRequest registrationRequest) {
	        try {
	            User user = new User();
	            user.setEMail(registrationRequest.getEmail());
	             user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
	            user.setUsername(registrationRequest.getUsername());
	            System.out.println(user);
	            userRepository.save(user);
	       
	            return Boolean.TRUE;
	        } catch (Exception e) {
	            log.error("REGISTRATION=>", e);
	            return Boolean.FALSE;
	        }
	    }

}
