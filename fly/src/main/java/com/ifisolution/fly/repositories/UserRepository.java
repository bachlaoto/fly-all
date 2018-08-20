package com.ifisolution.fly.repositories;

import com.ifisolution.fly.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

}
