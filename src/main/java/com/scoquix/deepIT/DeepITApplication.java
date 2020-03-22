package com.scoquix.deepIT;

import com.scoquix.deepIT.model.User;
import com.scoquix.deepIT.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeepITApplication {

    public static void main(String[] args) {


        SpringApplication.run(DeepITApplication.class, args);


    }
    @Bean
    ApplicationRunner applicationRunner(UserRepository repository){
		return args -> {
			repository.save(new User());
		};
	}

}
