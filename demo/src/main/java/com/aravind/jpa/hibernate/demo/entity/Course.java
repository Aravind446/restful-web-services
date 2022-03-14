package com.aravind.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_courses", query = "select c From Courses c"),
		@NamedQuery(name = "query_get_100_seps_courses", query = "Select c From Course c wher name like '%100 Steps'")})
public class Course {
	
	@Id
	@GeneratedValue
		private Long id;
	
	@Column(nullable = false)
		private String name;
		
	@OneToMany(mappedBy = "course")
	private List<Review> review = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	protected Course() {}
	
	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
	public Course(String name) {
		this.name= name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addReview(Review review) {
		this.review.add(review);
		
	}
	public void reamoveReview(Review review) {
		this.review.remove(review);
		
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student students) {
		this.students.add(students);
	}

	public Long getId() {
		return id;
	}

	public Object getReviews() {
		return null;
	}


	
}
