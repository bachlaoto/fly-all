package com.ifisolution.fly.services;

import com.ifisolution.fly.domain.User;

public interface UserService {
    public User findUserByEmail(String email);

    public void saveUser(User user);
}
