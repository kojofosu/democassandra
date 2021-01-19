package com.example.democassandra.controllers;

import com.example.democassandra.datatypes.User;
import com.example.democassandra.datatypes.UserResponse;
import com.example.democassandra.exchanges.ServiceExchange;
import com.example.democassandra.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());

    @Autowired
    ServiceExchange serviceExchange;

    @PostMapping(name = "Add new user", value = "/adduser")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user){
        logger.info("Received request to add new user.");
        UserResponse data = serviceExchange.addUser(user);
        return new ResponseEntity<>(data, data.getStatus());
    }
}
