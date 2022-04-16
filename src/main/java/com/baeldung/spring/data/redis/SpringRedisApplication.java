package com.baeldung.spring.data.redis;

import com.baeldung.spring.data.redis.model.Student;
import com.baeldung.spring.data.redis.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRedisApplication  {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

	@Bean
	public CommandLineRunner task(StudentRepository studentRepository) {
		return (args) -> {
			final Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
			studentRepository.save(student);
			final Student retrievedStudent = studentRepository.findById(student.getId()).get();
			LOG.info("Student id is "+retrievedStudent.getId());
		};
	}
}
