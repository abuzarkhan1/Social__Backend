package com.social.webdevproject.controller;

import com.social.webdevproject.models.User;
import com.social.webdevproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user ){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setId(user.getId());

        User savedUser = userRepository.save(newUser);
        return savedUser;
    }


    @GetMapping("/users")
    public List<User> getUsers(){

        List<User> users = new ArrayList<>();

        User user1 =  new User(1,"Abuzar","khan","abuzarkhan1242@gmail.com","123456");

        User user2 =  new User(2,"Ismail","Azam","ismailazam@gmail.com","abcdef");

        users.add(user1);
        users.add(user2);

        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id){

        User user1 =  new User(1,"Abuzar","khan","abuzarkhan1242@gmail.com","123456");
        user1.setId(id);
        return user1;
    }



    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        User user1 =  new User(1,"Abuzar","khan","abuzarkhan1242@gmail.com","123456");
        if(user.getFirstName()!=null){
            user1.setFirstName(user.getFirstName());
        }
        return  user1;
    }
    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable Integer userId){
        return "user deleted by id " + userId;
    }
}

//1:53:39