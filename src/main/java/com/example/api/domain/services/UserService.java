package com.example.api.domain.services;

import com.example.api.domain.entities.User;
import com.example.api.domain.gateways.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserGateway gateway;

    public List<User> getAll(){
        return gateway.getAll();
    }

    public User getUserById(int id){
        return gateway.getUserById(id);
    }

    public Optional<List<User>> getUsersByIdDocumet(int idDocument){
        return gateway.getByTypeDocument(idDocument);
    }

    public User saveUser(User user){
        return gateway.saveUser(user);
    }

    public Optional<List<User>> getLessThan(int age){
        return gateway.getUserLessThan(age);
    }

    public Optional<List<User>> getLessThanEqual(int age){
        return gateway.getUserLessThanEqual(age);
    }

    public Optional<List<User>> getGreaterThan(int age){
        return gateway.getUserGreaterThan(age);
    }

    public Optional<List<User>> getGreaterThanEqual(int age){
        return gateway.getUserGreaterThanEqual(age);
    }

    public void deleteById(int id){
        gateway.deleteUserById(id);
    }
}
