package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.model.User;
import com.scoquix.deepIT.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Witaj w moim REST API";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody User getAllUsers(@PathVariable Long id){
        return userService.getById(id).isPresent() ? userService.getById(id).get() : new User();
    }

    @RequestMapping(value = "userByName/{name}",method = RequestMethod.GET)
    public List<User> getUsersByName(@PathVariable String name){
        return userService.findByName(name);
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public HttpStatus insertUser(@RequestBody User user){
        return userService.addUser(user) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public HttpStatus updateUser(@RequestBody User user) {
        return userService.updateUser(user) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }
}
