package com.scoquix.deepIT.services;

import com.scoquix.deepIT.model.Course;
import com.scoquix.deepIT.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository<Course> courseRepository;

    @Autowired
    public CourseService(CourseRepository<Course> courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Transactional
    public Course findByTitle(String title) {
        return courseRepository.findByTitle(title);
    }

    @Transactional
    public Optional<Course> getById(Long id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Transactional
    public boolean addCourse(Course course) {
        return courseRepository.save(course) != null;
    }

    @Transactional
    public boolean updateCourse(Course course) {
        return courseRepository.save(course) != null;
    }
}