package com.scoquix.deepIT.repository;

import com.scoquix.deepIT.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository<P> extends CrudRepository<Course,Long> {
    Course findByTitle(String title);
}
