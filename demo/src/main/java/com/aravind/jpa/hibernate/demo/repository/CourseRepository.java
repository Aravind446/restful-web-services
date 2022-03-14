package com.aravind.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.jpa.hibernate.demo.entity.Course;
import com.aravind.jpa.hibernate.demo.entity.Review;
//import com.aravind.jpa.hibernate.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	private Review[] reviews;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
		
	}
	
	public Course save(Course course) {
		if(course.getId()==null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
		
	}
	public void deleteById(Long id) {
		Course course = findById(id);
		 em.remove(course);
	}
	public void playWithEntityManager() {
		Course course1= new Course("web services in 100 steps");
		em.persist(course1);
		
		Course course2 = findById(10001L);
		course2.setName("JPA in 50 steps - Updated");
		
	}
	public void addReviewsForCourse(Long courseId, List<Review>reviews) {
		
		//get the course 10003
		Course course = findById(10003L);
		//logger.info("course.getReview() -> {}", course.getReviews());
		
		//add 2 reviews to it
		//Review review1 = new Review("5", "Greate hands on stuff");
		//Review review2 = new Review("5", " Hatsoff... ");
		
		//setting the relationship
		
		for(Review review:reviews) {
		course.addReview(review);
		review.setCourse(course);
		
//		course.addReview(review2);
//		review2.setCourse(course);	
//		
		//save it to the database 
		//em.persist(review1);
		em.persist(review);
	}
	}
	
      public void addHardcodedReviewsForCourse() {
		
		//get the course 10003
		Course course = findById(10003L);
		logger.info("course.getReview() -> {}", course.getReviews());
		Review review1 = new Review("5", "Greate hands on stuff");
		Review review2 = new Review("5", " Hatsoff... ");
		//for (Review review: reviews) {
		//add 2 reviews to it
		//setting the relationship
		course.addReview(review1);
		review1.setCourse(course);	
		

		course.addReview(review2);
		review2.setCourse(course);
		//save it to the database 
		em.persist(review1);
		em.persist(review2);
		}
		
      }







