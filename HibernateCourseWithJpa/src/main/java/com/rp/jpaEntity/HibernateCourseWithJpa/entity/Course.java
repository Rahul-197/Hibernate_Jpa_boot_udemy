package com.rp.jpaEntity.HibernateCourseWithJpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	protected Course()
	{
		
	}
	public Course(long id,String name)
	{
		this.id =id;
		this.name = name;
	}

	public Course(String string) {
		// TODO Auto-generated constructor stub
		this.name = string;
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
