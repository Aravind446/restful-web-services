package com.aravind.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.aravind.jpa.hibernate.demo.DemoApplication;
import com.aravind.jpa.hibernate.demo.entity.Course;
import com.aravind.jpa.hibernate.demo.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class CourseRepositoryTest {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	EntityManager em;
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps",course.getName());
	}
	@Test
	@Transactional
	public void findById_firstLevelCacheDemo() {
		Course course = repository.findById(10001L);
		logger.info("First course Retrieved -> {}", course);
		
		Course course1 = repository.findById(10001L);
		logger.info("First course Retrieved again {}",course);
		
		assertEquals("JPA in 50 steps",course.getName());
		assertEquals("JPA in 50 steps",course1.getName());
	}
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	@Test
	@DirtiesContext
	public void save_basic() {
		//get a course
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps",course.getName());
		
		// update details
		course.setName("JPA in 50 steps- updated");
		repository.save(course);
		
		//check the value
		@SuppressWarnings("unused")
		Course course1 =repository.findById(10001L);
		assertEquals("JPA in 50 Steps",course.getName());
	}
	public void playWithEntireManager() {
		repository.playWithEntityManager();
		
	}
	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repository.findById(10001L);
		logger.info("{}", course.getReviews());
	}
	
	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 50001L);
		logger.info("{}", review.getCourse());
	}
}
