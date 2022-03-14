package com.aravind.jpa.hibernate.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aravind.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.aravind.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.aravind.jpa.hibernate.demo.repository.EmployeeRepository;

//import com.aravind.jpa.hibernate.demo.entity.Course;
//import com.aravind.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Autowired
//	private CourseRepository courseRepository;
	//private Object studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "Great Hands on stuff"));
//		reviews.add(new Review("5", "Hatsoff.."));
			// studentRepository.saveStudentWithPassport();
		// Course course = repository.findById(10001L);
//		
//		logger.info("Course 10001 -> {}", course);
//		repository.save(new Course("Microservices in 100 steps"));
		//courseRepository.addHardcodedReviewsForCourse();
			//courseRepository.addReviewsForCourse(10003L, reviews);
		//StuentRepository.insertHardcoadedStudentAndCourse();
		 //studentRepository.insertStudentAndCourse(new Student("Jack"),new Course("Microservices in 100 Steps"))
	
//	employeeRepository.insert(new PartTimeEmployee("Jack", new BigDecimal("50")));
//	
//	employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//	
//	logger.info("Full Time Employees - > {}", employeeRepository.retrieveAllFullTimeEmployees());
//	
//	logger.info("Part Time Employees - > {}", employeeRepository.retrieveAllPartTimeEmployees());
	}

}