package com.example.deepit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Iterator;

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
    Iterable<Greeting> findAll() {
        return repository.findAll();

    }

    @GetMapping("/{id}")
    Iterable<Greeting> findAllById(long id){
        return repository.findAllById(Collections.singleton(id));
    }
}
