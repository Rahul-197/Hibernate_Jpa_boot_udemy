package com.rp.jpaEntity.HibernateCourseWithJpa.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.rp.jpaEntity.HibernateCourseWithJpa.HibernateCourseWithJpaApplication;
import com.rp.jpaEntity.HibernateCourseWithJpa.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateCourseWithJpaApplication.class)
class CourseRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepo;
	
	@Test
	void findById_basic() {
		
		Course course = courseRepo.findById(1001);
		assertEquals("Jpa hibernate1", course.getName());
		logger.info("testing is running---"+course.getName());
	}
	@Test
	//@DirtiesContext annotation used for not changing data after use cases
	@DirtiesContext
	void deleteById_basic() {
		
		courseRepo.deleteById(1006);
		assertNull(courseRepo.findById(1006));
	}
	void save_basic() {
		Course course = courseRepo.findById(1001);
		course.setName("Jpa hibernate1_updated");
		courseRepo.save(course);
		
		Course course1 = courseRepo.findById(1001);
		assertEquals("Jpa hibernate1_updated", course1.getName());
	}

}