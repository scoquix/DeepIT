package com.scoquix.deepIT.repository;

import com.scoquix.deepIT.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository<P> extends CrudRepository<Course,Long> {
    List<Course> findByTitle(String title);
}
