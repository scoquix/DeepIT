package com.scoquix.deepIT.repository;

import com.scoquix.deepIT.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository<P> extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName);
}
