package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.entity.Instructor;
import com.scoquix.deepIT.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Witaj w moim REST API <br> Aby sprawdzic czy jestes w bazie dopisz do adresu /users";
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Instructor getAllUsers(@PathVariable Long id){
        return instructorService.getById(id).isPresent() ? instructorService.getById(id).get() : new Instructor();
    }

    @GetMapping(value = "/name/{name}")
    public List<Instructor> getUsersByName(@PathVariable String name){
        return instructorService.findByName(name);
    }

    @GetMapping(value = "/all")
    public List<Instructor> getAll(){
        return instructorService.getAllUsers();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteUser(@PathVariable Long id){
        instructorService.deleteUser(id);
        return HttpStatus.NO_CONTENT;
    }

    @PostMapping
    public HttpStatus insertUser(@RequestBody Instructor instructor){
        return instructorService.addUser(instructor) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @PutMapping
    public HttpStatus updateUser(@RequestBody Instructor instructor) {
        return instructorService.updateUser(instructor) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }
}
