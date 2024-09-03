package com.crud.crudapis.services;

import com.crud.crudapis.entity.User;
import com.crud.crudapis.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private userRepo Repo;

    //create
    public User createUser(User user) {
        return  Repo.save(user);
    }

    //get all
    public List<User> getUser() {
        return  Repo.findAll();
    }

    //update
    public User updateUser(User user1) {
        return Repo.save(user1);
    }

    //by id
    public User getUserByid(Long id) {
        return Repo.findById(id).orElse(null);
    }

    public String  deleteUser(Long user) {
        Repo.deleteById(user);
        return "Deleted Sucessfully";
    }
}
