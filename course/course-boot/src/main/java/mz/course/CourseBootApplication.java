package mz.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = {
		"mz.common", "mz.course"
})
public class CourseBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(CourseBootApplication.class);
	}
}
