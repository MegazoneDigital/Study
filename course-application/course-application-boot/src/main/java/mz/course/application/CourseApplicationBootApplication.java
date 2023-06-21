package mz.course.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"mz.common", "mz.course.application"
})
public class CourseApplicationBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(CourseApplicationBootApplication.class);
	}
}
