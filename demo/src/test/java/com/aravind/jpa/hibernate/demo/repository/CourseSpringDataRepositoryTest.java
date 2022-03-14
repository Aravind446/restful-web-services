package com.aravind.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.print.Pageable;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aravind.jpa.hibernate.demo.DemoApplication;
import com.aravind.jpa.hibernate.demo.entity.Course;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class CourseSpringDataRepositoryTest {

	//@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepository repository;
	
	@Test 
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
	}
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		assertFalse(courseOptional.isPresent());
	}
	public void playingAroundWithSpringDataRepository() {
//		Course course = new Course("Microservices in 100 steps");
//		repository.save(course);
//		course.setName("Microservicesin 100 steps- updated");
//		repository.save(course);
		logger.info("courses -> {}",repository.findAll());
		logger.info("count -> {}",repository.count());
		
	}
	public void sort() {
//		Course course = new Course("Microservices in 100 steps");
//		repository.save(course);
//		course.setName("Microservicesin 100 steps- updated");
//		repository.save(course);
		Sort sort = new Sort(Sort.Direction.DESC ,"name");
		logger.info("courses -> {}",repository.findAll());
		logger.info("count -> {}",repository.count());
		
	}
	public void pagination() {
//		Course course = new Course("Microservices in 100 steps");
//		repository.save(course);
//		course.setName("Microservicesin 100 steps- updated");
//		repository.save(course);
			PageRequest pageRequest = PageRequest.of(0,3);
			
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("First page -> {}",firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable()
		page<Course> secondPage = repository.findAll(secondPageable);
	}
}





