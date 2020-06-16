package com.scoquix.deepIT.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Witaj w moim REST API <br> Aby sprawdzic czy jestes w bazie dopisz do adresu /users";
    }
}
