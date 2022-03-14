package com.aravind.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aravind.jpa.hibernate.demo.DemoApplication;
import com.aravind.jpa.hibernate.demo.entity.Passport;
import com.aravind.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class StudentRepositoryTest {

	//@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void someTest() {
		//Database Operation 1 -Retrieve Student
		Student student = em.find(Student.class, 20001L);
		
		//Database Operation 2 - Retrieve Passport
		Passport passport = student.getPassport();
		
		//Database Operation 3 - update passport
		passport.setNumber("H123456");
		
		//Database Operation 4 - update student 
		student.setName("Ranga-updated");
		
		
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}",student);
		logger.info("passport -> {}",student.getPassport());
	}
	@Test
	@Transactional
	public void retrieveStudentAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}",passport);
		logger.info("student -> {}",passport.getStudent());
	}
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student =em.find(Student.class,20001L);
		logger.info("student -> {}", student);
		logger.info("student -> {}", student.getcourse());
		
	}
	
}
