package com.stakroute.controller;

import com.stakroute.domain.User;
import com.stakroute.exceptions.UserAlreadyExistsException;
import com.stakroute.exceptions.UserDoesNotExists;
import com.stakroute.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/v1")
public class UserController {
    private UserService userService;  //Interface

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUserHttpPostHandler(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        }
        catch (UserAlreadyExistsException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }


   @GetMapping("/user")
    public ResponseEntity<?> getAllUsersHttpPostHandler()
    {
        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;

    }

    @GetMapping("/userById")
    public ResponseEntity<?> getUserByIdHttpPostHandler()
    {
        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity<User>(userService.getUserById(3),HttpStatus.OK);
        }
        catch (UserDoesNotExists ex)
        {
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
