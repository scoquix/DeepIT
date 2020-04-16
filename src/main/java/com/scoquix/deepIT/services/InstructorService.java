package com.scoquix.deepIT.services;

import com.scoquix.deepIT.entity.Instructor;
import com.scoquix.deepIT.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository<Instructor> instructorRepository;

    @Transactional
    public List<Instructor> getAllUsers() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Transactional
    public List<Instructor> findByName(String name) {
        return instructorRepository.findByFirstName(name);
    }

    @Transactional
    public Optional<Instructor> getById(Long id) {
        return instructorRepository.findById(id);
    }

    @Transactional
    public void deleteUser(Long personId) {
        instructorRepository.deleteById(personId);
    }

    @Transactional
    public boolean addUser(Instructor instructor) {
        return instructorRepository.save(instructor) != null;
    }

    @Transactional
    public boolean updateUser(Instructor instructor) {
        return instructorRepository.save(instructor) != null;
    }
}
