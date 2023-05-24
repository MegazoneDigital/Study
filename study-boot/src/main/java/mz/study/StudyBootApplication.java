package mz.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"mz.common", "mz.study"
})
public class StudyBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudyBootApplication.class);
	}
}
