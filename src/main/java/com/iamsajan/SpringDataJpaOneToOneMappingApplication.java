package com.iamsajan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iamsajan.model.Course;
import com.iamsajan.model.CourseDetails;
import com.iamsajan.repository.CourseDetailsRepository;
import com.iamsajan.repository.CourseRepository;

@SpringBootApplication
public class SpringDataJpaOneToOneMappingApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;

//	@Autowired
//	private CourseDetailsRepository courseDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaOneToOneMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Clean up database tables
//		courseDetailsRepository.deleteAllInBatch();
//		courseRepository.deleteAllInBatch();

		// Create a Course instance
		Course course = new Course("Spring Boot", "Spring Boot Jpa Hibernate one to one bidirectional mapping", true);

		// Create a CourseDetails instance
		CourseDetails courseDetails = new CourseDetails("Sajan K.C.");

		// Set child reference(courseDetails) in parent entity(course)
		course.setCourseDetails(courseDetails);

		// Set parent reference(course) in child entity(courseDetails)
		courseDetails.setCourse(course);

		// Save Parent Reference (which will save the child as well)
		courseRepository.save(course);

	}

}
