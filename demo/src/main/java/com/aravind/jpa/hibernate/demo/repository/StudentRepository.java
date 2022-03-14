package com.aravind.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.jpa.hibernate.demo.entity.Course;
import com.aravind.jpa.hibernate.demo.entity.Passport;
import com.aravind.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());
			;
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
		
	}
	
	public Student save(Student student) {
		if(student.getId()==null) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return student;
		
	}
	public void deleteById(Long id) {
		Student student = findById(id);
		 em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		
		Passport passport = new Passport("H123456");
		em.persist(passport);
		Student student= new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
			
	}
	public void insertStudentAndCourse(Student student, Course course) {
		//Student student1 = new Student("Jack");
		//Course course = new Course("Microservices in 100 steps");
//		em.persist(student1);
//		em.persist(course);
//		
//		student1.addcourse(course);
//		course.addStudents(student1);
//		em.persist(student1);
//		em.persist(course);
	}

	public static void insertHardcoadedStudentAndCourse() {
		// TODO Auto-generated method stub
		
	}
}
