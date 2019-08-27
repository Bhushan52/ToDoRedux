package com.yash.todo.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.todo.model.Role;
import com.yash.todo.model.User;
import com.yash.todo.service.UserServiceCustom;

@RestController
public class UserController {

    @Autowired
    UserController itemService;
    
    @Autowired
    UserServiceCustom userServiceCustom;

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {  	
    	Set<Role> roles=new HashSet<Role>(); 	
		user.setRoles(roles);
    	userServiceCustom.saveUser(user);
    }

}

