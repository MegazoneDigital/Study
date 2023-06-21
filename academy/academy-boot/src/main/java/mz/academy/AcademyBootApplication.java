package mz.academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"mz.common", "mz.academy"
})
public class AcademyBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(AcademyBootApplication.class);
	}
}
