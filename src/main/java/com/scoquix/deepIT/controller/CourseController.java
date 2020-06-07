package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.entity.Course;
import com.scoquix.deepIT.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Course getAllCourses(@PathVariable Long id){
        return courseService.getById(id).isPresent() ? courseService.getById(id).get() : new Course();
    }

    @RequestMapping(value = "/title/{name}", method = RequestMethod.GET)
    public List<Course> getCoursesByTitle(@PathVariable String name) {
        return courseService.findByTitle(name);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Course> getAll(){
        return courseService.getAllCourses();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public HttpStatus insertCourse(@RequestBody Course course){
        return courseService.addCourse(course) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    public HttpStatus updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }
}
