package com.aravind.jpa.hibernate.demo.entity;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
@Id
@GeneratedValue
	private Long id;

private String rating;

	private String description;
	
	@ManyToOne
	private Course course ;

	protected Review() {}
	
	@Override
	public String toString() {
		return String.format("Review[%s %s]",rating,  description);
	}
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Review(String description, String rating) {
		this.rating = rating;
		this.description= description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String name, String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	public Long getId() {
		return id;
	}

	
}
