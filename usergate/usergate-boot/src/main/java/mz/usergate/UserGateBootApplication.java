package mz.usergate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"mz.common", "mz.usergate"
})
public class UserGateBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserGateBootApplication.class);
	}
}
