package com.scoquix.deepIT.services;

import com.scoquix.deepIT.entity.Authority;
import com.scoquix.deepIT.repository.AuthorityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthorityService {
    private AuthorityRepository authorityRepository;

    @Transactional
    public Optional<Authority> findByUsername(String title) {
        return authorityRepository.findById(title);
    }

    @Transactional
    public boolean addAuthority(Authority authority) {
        return authorityRepository.save(authority) != null;
    }
}
