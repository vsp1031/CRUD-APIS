package com.crud.crudapis.controller;

import com.crud.crudapis.entity.User;
import com.crud.crudapis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<User> getStudent(){
        return userService.getUser();
    }


    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User>getUserbyId(@PathVariable Long id){
        User user=userService.getUserByid(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(user);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<User>updateUser(@RequestBody User user, @PathVariable Long id){
        User user1=userService.getUserByid(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        User updateUser=userService.updateUser(user1);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long user){
        userService.deleteUser(user);
        return "Delete Sucessfully";
    }

}
