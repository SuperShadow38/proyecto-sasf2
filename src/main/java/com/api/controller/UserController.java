package com.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.service.UserService;
import com.api.model.User;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService  userService;

    @Autowired
    public UserController( UserService userService  ){
        this.userService= userService;

    }

     @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
        }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserId(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED); 
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.getUserId(id);
        if (user != null) {
            updatedUser.setId(id); 
            User savedUser = userService.saveUser(updatedUser);
            return new ResponseEntity<>(savedUser, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userService.getUserId(id);
        if (user != null) {
            userService.deletUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public List<User> searchUsersByKeyword(@RequestParam("keyword") String keyword) {
        return userService.searchUsersByKeyword(keyword);
    }
}