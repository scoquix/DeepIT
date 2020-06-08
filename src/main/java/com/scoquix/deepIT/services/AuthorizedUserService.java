package com.scoquix.deepIT.services;

import com.scoquix.deepIT.entity.AuthorizedUser;
import com.scoquix.deepIT.repository.AuthorizedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorizedUserService {
    @Autowired
    private AuthorizedUserRepository userRepository;

    @Transactional
    public List<AuthorizedUser> getAllUsers() {
        return (List<AuthorizedUser>) userRepository.findAll();
    }

    @Transactional
    public Optional<AuthorizedUser> findById(String title) {
        return userRepository.findById(title);
    }

    @Transactional
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public boolean addUser(AuthorizedUser user) {
        return userRepository.save(user) != null;
    }

    @Transactional
    public boolean updateCourse(AuthorizedUser user) {
        return userRepository.save(user) != null;
    }
}
