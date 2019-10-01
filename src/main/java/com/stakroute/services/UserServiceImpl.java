package com.stakroute.services;

import com.stakroute.domain.User;
import com.stakroute.exceptions.UserAlreadyExistsException;
import com.stakroute.exceptions.UserDoesNotExists;
import com.stakroute.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private User1Repository user1Repository;


    @Autowired
   public UserServiceImpl(User1Repository userRepository) {
        this.user1Repository = userRepository;
    }

    @Override
    public User saveUser(User userObj)throws UserAlreadyExistsException {
        if(user1Repository.existsById(userObj.getId()))
        {
            throw new UserAlreadyExistsException("user id already exists");
        }
        User savedUser= user1Repository.save(userObj);
        if(savedUser==null)
        {
            throw new UserAlreadyExistsException("user id already exists can't save null");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return user1Repository.findAll();
    }

    @Override
    public User getUserById(int id) throws UserDoesNotExists {

        List<User> allInList=user1Repository.findAll();
        User findOneUser=new User();
        if(user1Repository.existsById(id))
        {
            for (int i = 0; i < allInList.size(); i++)
            {
                if (allInList.get(i).getId() == id)
                {
                    findOneUser = allInList.get(i);
                }
            }
        }
        else
        {
            throw new UserDoesNotExists("user does not exists with given id= "+id);
        }
        if(findOneUser==null)
            throw new UserDoesNotExists("user does not exists with given id= "+id);
        return findOneUser;
    }
}
