package com.example.api.domain.gateways;

import com.example.api.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {

    List<User> getAll();
    Optional<List<User>> getByTypeDocument(int idTypeDocument);
    User getUserById(int id);
    User saveUser(User user);
    Optional<List<User>> getUserLessThanEqual(int age);
    Optional<List<User>> getUserLessThan(int age);
    Optional<List<User>> getUserGreaterThanEqual(int age);
    Optional<List<User>> getUserGreaterThan(int age);
    void deleteUserById(int id);

}
