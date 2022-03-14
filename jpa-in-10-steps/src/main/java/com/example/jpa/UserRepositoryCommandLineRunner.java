package com.example.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpa.entity.User;
import com.example.jpa.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	@Autowired
	private UserRepository userRepository;
	
	public void run(String arg0) throws Exception{
		
		User user = new User ("Aravind", "Admin");
		userRepository.save(user);	
		Optional<User> userWithId1 = userRepository.findById(1L);
		
		List<User> user1 = userRepository.findAll();
	log.info("New User is created: " +user1);	
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	}

