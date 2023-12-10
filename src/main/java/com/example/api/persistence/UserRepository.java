package com.example.api.persistence;

import com.example.api.domain.entities.User;
import com.example.api.domain.gateways.UserGateway;
import com.example.api.persistence.crud.UserCrudRepository;
import com.example.api.persistence.mappers.UserMapper;
import com.example.api.persistence.models.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserGateway {

    @Autowired
    private UserCrudRepository crudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        List<UserDAO> users = (List<UserDAO>) crudRepository.findAll();
        return mapper.toUsers(users);
    }

    @Override
    public Optional<List<User>> getByTypeDocument(int idTypeDocument) {
        List<UserDAO> userDAOS = crudRepository.findByDocumentTypeIdOrderByAgeAsc(idTypeDocument);
        return Optional.of(mapper.toUsers(userDAOS));
    }

    @Override
    public User getUserById(int id) {
        // con el método get saco el valor que tiene por dentro el optional
        UserDAO userDAO = crudRepository.findById(id).get();
        return mapper.toUser(userDAO);
    }

    @Override
    public User saveUser(User user) {
        UserDAO userDAO = crudRepository.save(mapper.toUserDAO(user));
        return mapper.toUser(userDAO);
    }

    @Override
    public Optional<List<User>> getUserLessThanEqual(int age) {
        Optional<List<UserDAO>> userDAO = crudRepository.findByAgeLessThanEqualOrderByAgeAsc(age);
        return Optional.of(mapper.toUsers(userDAO.get()));

    }

    @Override
    public Optional<List<User>> getUserLessThan(int age) {
        Optional<List<UserDAO>> userDAO = crudRepository.findByAgeLessThanOrderByAgeAsc(age);
        return Optional.of(mapper.toUsers(userDAO.get()));
    }

    @Override
    public Optional<List<User>> getUserGreaterThanEqual(int age) {
        Optional<List<UserDAO>> userDAO = crudRepository.findByAgeGreaterThanEqualOrderByAgeAsc(age);
        return Optional.of(mapper.toUsers(userDAO.get()));
    }

    @Override
    public Optional<List<User>> getUserGreaterThan(int age) {
        Optional<List<UserDAO>> userDAO = crudRepository.findByAgeGreaterThanOrderByAgeAsc(age);
        return Optional.of(mapper.toUsers(userDAO.get()));
    }

    @Override
    public void deleteUserById(int id) {
        crudRepository.deleteById(id);
    }
}
