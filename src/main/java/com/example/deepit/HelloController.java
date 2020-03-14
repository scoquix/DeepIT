package com.example.deepit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final GreetingRepository repository;

    public HelloController(GreetingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    String hello() {
        return "Hello World";
    }

    @GetMapping("/greeting")
    Iterable<Greeting> greetings() {
        return repository.findAll();
    }
}
