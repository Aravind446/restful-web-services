package com.aravind.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aravind.jpa.hibernate.demo.DemoApplication;
import com.aravind.jpa.hibernate.demo.entity.Course;
import com.aravind.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
	@SpringBootTest(classes = DemoApplication.class)
	public class CriteriaQueryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test 
	public void jpql_basic() {
		Query query = em. createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();
		logger.info("select c From course c -> {}", resultList);	
	}
	
	@Test
	public void  jpql_typed() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_All_courses",Course.class);
		 
		List<Course> resultList = query.getResultList();
		logger.info("select c from course where name like '%100 steps' -> {}", resultList);
	}
	
	@Test
	public void  jpql_where() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_100_steps_courses",Course.class);
		 
		List<Course> resultList = query.getResultList();
		logger.info("select c from course where name like '%100 steps' -> {}", resultList);
	}
	
	@Test
	public void  jpql_courses_without_students() {
		TypedQuery<Course> query = em.createQuery("select c from course c where c.students is empty",Course.class);
		 
		List<Course> resultList = query.getResultList();
		logger.info("Results  -> {}", resultList);
	}
	@Test
	public void  jpql_courses_with_atleast_2__students() {
		TypedQuery<Course> query = em.createQuery("select c from course c where size(c.students) >=2 ",Course.class);
		 
		List<Course> resultList = query.getResultList();
		logger.info("Results  -> {}", resultList);
	}
	@Test
	public void  jpql_courses_ordered_by_students() {
		TypedQuery<Course> query = em.createQuery("select c from course c order size(c.students) 2 ",Course.class);
		 
		List<Course> resultList = query.getResultList();
		logger.info("Results  -> {}", resultList);
	}
	@Test
	public void  jpql_students_with_passports_in_a_certain_pattern() {
		TypedQuery<Student> query = em.createQuery("select s from student s where s.passport.number like'%1234%' ",Student.class);
		 
		List<Student> resultList = query.getResultList();
		logger.info("Results  -> {}", resultList);
	
}
	//@SuppressWarnings("rawtypes")
	@Test
	public void join() {
		
		Query query = em.createQuery("select c,s from course c join c .students s");
		List <Object[]>resultList = query.getResultList();
		logger.info("Results size-> {}", resultList);
		for (Object[] result:resultList) {
			logger.info("course{} student{}", result[0],result[1]);
		}
	}
		@Test
		public void left_join() {
			
			Query query = em.createQuery("select c,s from course c left join c .students s");
			List <Object[]>resultList = query.getResultList();
			logger.info("Results size-> {}", resultList);
			for (Object[] result:resultList) {
				logger.info("course{} student{}", result[0],result[1]);
			}
	}
		@Test
		public void cross_join() {
			
			Query query = em.createQuery("select c,s from course c ,students s");
			List <Object[]>resultList = query.getResultList();
			logger.info("Results size-> {}", resultList);
			for (Object[] result:resultList) {
				logger.info("course{} student{}", result[0],result[1]);
			}
	}
	
	}
