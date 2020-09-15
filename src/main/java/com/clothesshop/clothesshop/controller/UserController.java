package com.clothesshop.clothesshop.controller;

import com.clothesshop.clothesshop.modell.User;
import com.clothesshop.clothesshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/test")
    public ResponseEntity<User> saveUser(){
        User user = new User();
        user.setFirstName("Adam");
        user.setLastName("Pinter");
        user.setPassword("asd");
        user.setEmail("asd@asd");


        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
    }

/*
    @GetMapping("/createrole")
    public void createRole(){
        userService.createRole();
    }

 */
}
