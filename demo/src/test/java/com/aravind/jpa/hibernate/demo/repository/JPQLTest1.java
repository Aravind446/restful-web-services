package com.aravind.jpa.hibernate.demo.repository;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aravind.jpa.hibernate.demo.DemoApplication;
import com.aravind.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
	@SpringBootTest(classes = DemoApplication.class)
	public class JPQLTest1 {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test 
	public void all_courses() {
		//. use criteria builder to create criteria query returning the 
		//expected result object
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are involved in the query
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicties etc using criteria Builder
		//4. add predicaes etc to the criteria query 
		//5. Build the typedQuery using using the entity manager and criteria query
		
		TypedQuery<Course> query = em. createQuery("select c from course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query-> {}", resultList);	
			}
	
	
	@Test 
	public void all_courses_having_100steps() {
		
		
		//. use criteria builder to create criteria query returning the 
		//expected result object
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are involved in the query
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicties etc using criteria Builder
		
		Predicate like100steps = (Predicate) cb.like(courseRoot.get("name"),"%100 steps");
		
		//4. add predicaes etc to the criteria query 
		
		cq.where((Expression<Boolean>) like100steps);
		
		//5. Build the typedQuery using using the entity manager and criteria query
		
		TypedQuery<Course> query = em. createQuery("select c from course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query-> {}", resultList);	
			}
	
	@Test 
	public void all_courses_without_students() {
		
		
		//1. use criteria builder to create criteria query returning the 
		//expected result object
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are involved in the query
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicties etc using criteria Builder
		
		Predicate studentsIsEmpty = (Predicate) cb.isEmpty(courseRoot.get("studentsme"));
		
		//4. add predicaes etc to the criteria query 
		
		cq.where((Expression<Boolean>) studentsIsEmpty);
		
		//5. Build the typedQuery using using the entity manager and criteria query
		
		TypedQuery<Course> query = em. createQuery("select c from course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query-> {}", resultList);	
			}

	@Test 
	public void join() {
		
		
		//1. use criteria builder to create criteria query returning the 
		//expected result object
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are involved in the query
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicties etc using criteria Builder
		
   Join<Object, Object> join = courseRoot.join("studens");		
		//4. add predicaes etc to the criteria query 
		
		
		//5. Build the typedQuery using using the entity manager and criteria query
		
		TypedQuery<Course> query = em. createQuery("select c from course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query-> {}", resultList);	
			}
	@Test 
	public void left_join() {
		
		
		//1. use criteria builder to create criteria query returning the 
		//expected result object
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are involved in the query
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicties etc using criteria Builder
		
   Join<Object, Object> join = courseRoot.join("studens",JoinType.LEFT );		
		//4. add predicaes etc to the criteria query 
		
		
		//5. Build the typedQuery using using the entity manager and criteria query
		
		TypedQuery<Course> query = em. createQuery("select c from course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query-> {}", resultList);	
			}
	}
	
