package com.example.deepit;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeepitApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeepitApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(GreetingRepository repository){
		return args -> {
			repository.save(new Greeting("hello"));
			repository.save(new Greeting("hi"));
		};
	}
}
