package com.aravind.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "EmployeeType")
public abstract class Employee {
	
	@Id
	@GeneratedValue
		private Long id;
	
	@Column(nullable = false)
		private String name;
		
	protected Employee() {}
	
	@Override
	public String toString() {
		return String.format("Employe[%s]", name);
	}
	public Employee(String name) {
		this.name= name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public Object getReviews() {
		return null;
	}


	
}
