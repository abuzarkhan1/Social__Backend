package com.social.webdevproject.controller;

import com.social.webdevproject.models.User;
import com.social.webdevproject.repository.UserRepository;
import com.social.webdevproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;



    @GetMapping("/api/users")
    public List<User> getUsers(){

        List<User> users = userRepository.findAll();

        return users;
    }

    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id) throws Exception {
        User user = userService.findUserById(id);
        return user;
    }



    @PutMapping("/api/users")
    public User updateUser(@RequestHeader("Authorization") String jwt,@RequestBody User user) throws Exception{

        User reqUser = userService.findUserByJwt(jwt);
        User updatedUser = userService.updateUser(user,reqUser.getId());
        return updatedUser;
    }


    @PutMapping("/api/users/follow/{userId2}")
    public User followUserHandler(@RequestHeader("Authorization") String jwt,@PathVariable Integer userId2) throws Exception{
        User reqUser = userService.findUserByJwt(jwt);
       User user = userService.followUser(reqUser.getId(),userId2);
       return user;
    }


    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable Integer userId) throws Exception{
        Optional<User>  user =  userRepository.findById(userId);
        if(user.isEmpty()){
            throw new Exception("user not exist with id" + userId);
        }
        userRepository.delete(user.get());
        return "user deleted successfully with id " + userId;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query){
        List<User> users = userService.searchUser(query);
        return users;
    }

    @GetMapping("/api/users/profile")
    public User getUserFromToken(@RequestHeader("Authorization") String jwt){

        User user = userService.findUserByJwt(jwt);

        user.setPassword(null);
        return user;
    }
}
