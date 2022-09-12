package com.rp.jpaEntity.HibernateCourseWithJpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rp.jpaEntity.HibernateCourseWithJpa.entity.Course;
import com.rp.jpaEntity.HibernateCourseWithJpa.repository.CourseRepository;

@SpringBootApplication
public class HibernateCourseWithJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository CourseRepository;
	public static void main(String[] args) {
		SpringApplication.run(HibernateCourseWithJpaApplication.class, args);
		System.out.println("----------------start Hibernate with jpa------------- ");
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = CourseRepository.findById(1001);
		logger.info("Course {} ",course);
		CourseRepository.deleteById(1007);
		CourseRepository.save(new Course("spring boot hibernate jpa"));
		CourseRepository.save(new Course(1001,"spring boot hibernate jpa 1001"));
	}
}
