package com.stakroute.services;

import com.stakroute.domain.User;
import com.stakroute.exceptions.UserAlreadyExistsException;
import com.stakroute.exceptions.UserDoesNotExists;

import java.util.List;

public interface UserService {
    public User saveUser(User userObj) throws UserAlreadyExistsException;
    public List<User> getAllUser();
    public User getUserById(int id) throws UserDoesNotExists;
}
