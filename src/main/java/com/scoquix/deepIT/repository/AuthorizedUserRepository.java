package com.scoquix.deepIT.repository;

import com.scoquix.deepIT.entity.AuthorizedUser;
import org.springframework.data.repository.CrudRepository;

public interface AuthorizedUserRepository<P> extends CrudRepository<AuthorizedUser, String> {

}
