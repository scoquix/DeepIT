package com.scoquix.deepIT.repository;

import com.scoquix.deepIT.entity.Instructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InstructorRepository<P> extends CrudRepository<Instructor, Long> {
    List<Instructor> findByFirstName(String firstName);
}
