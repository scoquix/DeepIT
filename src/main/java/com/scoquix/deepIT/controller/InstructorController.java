package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.entity.Instructor;
import com.scoquix.deepIT.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Witaj w moim REST API <br> Aby sprawdzic czy jestes w bazie dopisz do adresu /users";
    }

    @RequestMapping(value = "/instr/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Instructor getAllUsers(@PathVariable Long id){
        return instructorService.getById(id).isPresent() ? instructorService.getById(id).get() : new Instructor();
    }

    @RequestMapping(value = "instrByName/{name}",method = RequestMethod.GET)
    public List<Instructor> getUsersByName(@PathVariable String name){
        return instructorService.findByName(name);
    }

    @RequestMapping(value = "/instructors",method = RequestMethod.GET)
    public List<Instructor> getAll(){
        return instructorService.getAllUsers();
    }

    @RequestMapping(value = "/instr/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteUser(@PathVariable Long id){
        instructorService.deleteUser(id);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/instr", method = RequestMethod.POST)
    public HttpStatus insertUser(@RequestBody Instructor instructor){
        return instructorService.addUser(instructor) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/instr", method = RequestMethod.PUT)
    public HttpStatus updateUser(@RequestBody Instructor instructor) {
        return instructorService.updateUser(instructor) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }
}
