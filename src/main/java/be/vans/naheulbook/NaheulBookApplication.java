package be.vans.naheulbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NaheulBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaheulBookApplication.class, args);
	}

}
