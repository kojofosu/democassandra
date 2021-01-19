package com.example.democassandra.exchanges;

import com.example.democassandra.datatypes.User;
import com.example.democassandra.datatypes.UserResponse;
import com.example.democassandra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ServiceExchange {

    private final UserRepository userRepository;

    public ServiceExchange(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse addUser(User user) {
        UserResponse response = new UserResponse();

        userRepository.save(user);


        List<User> userList = new ArrayList<>();
        userList.add(user);

        response.setData(userList);
        response.setStatus(HttpStatus.OK);

        response.setTimestamp(new Date().toString());
        return response;
    }
}
