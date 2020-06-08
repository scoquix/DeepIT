package com.scoquix.deepIT.repository;

import com.scoquix.deepIT.entity.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository<P> extends CrudRepository<Authority, String> {

}
