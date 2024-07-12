package ru.app.sewens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.app.sewens.entity.RegisterUser;
import ru.app.sewens.repository.RegisterUserRepository;

@SpringBootApplication
public class SewensApplication {

	public static void main(String[] args) {
		SpringApplication.run(SewensApplication.class, args);
	}
}
