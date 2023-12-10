package com.example.api.web.controller;

import com.example.api.domain.entities.User;
import com.example.api.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        User user1 = service.saveUser(user);
        if(user1 == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/typeDocument/{id}")
    public ResponseEntity<Optional<List<User>>> getByTypeDocument(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getUsersByIdDocumet(id), HttpStatus.OK);
    }

    @GetMapping("/lessThan/{age}")
    public ResponseEntity<Optional<List<User>>> getLessThan(@PathVariable("age") int age){
        return new ResponseEntity<>(service.getLessThan(age), HttpStatus.OK);
    }

    @GetMapping("/lessThanEquals/{age}")
    public ResponseEntity<Optional<List<User>>> getLessThanEquals(@PathVariable("age") int age){
        return new ResponseEntity<>(service.getLessThanEqual(age), HttpStatus.OK);
    }

    @GetMapping("/greaterThanEquals/{age}")
    public ResponseEntity<Optional<List<User>>> getGreaterThanEquals(@PathVariable("age") int age){
        return new ResponseEntity<>(service.getGreaterThanEqual(age), HttpStatus.OK);
    }

    @GetMapping("/greaterThan/{age}")
    public ResponseEntity<Optional<List<User>>> gerGreaterThan(@PathVariable("age") int age){
        return new ResponseEntity<>(service.getGreaterThan(age), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        service.deleteById(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
