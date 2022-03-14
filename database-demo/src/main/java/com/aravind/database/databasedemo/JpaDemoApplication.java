package com.aravind.database.databasedemo;

//import java.sql.Date;

import java.util.Date;

//import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aravind.database.databasedemo.entity.Person;
//import com.aravind.database.databasedemo.entity.Person;
//import com.aravind.database.databasedemo.jdbc.PersonJdbcDAO;
import com.aravind.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
			logger.info("User id 10001 -> {}", repository.findById(10001));
			
			logger.info("Inserting  -> {}", repository. insert( new Person(10004, "Tara", "Berlin", new Date())));
			    
			    logger.info("Update 10003 -> {}",repository.update(new Person(10003, "Varun", "Banglore", new Date())));
		 
			    repository.deleteById(10002);
			    
			    logger.info("All users -> {}",repository.findAll());
		/*
			
			
			logger.info("User id 10002 -> No of Rows is deleted{}", repository.deleteById(10002));
			
		    */
	}

}
