package com.example.api.persistence.crud;


import com.example.api.persistence.models.UserDAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<UserDAO,Integer> {

    List<UserDAO> findByDocumentTypeIdOrderByAgeAsc(int documentTypeId);
    Optional<List<UserDAO>> findByAgeGreaterThanOrderByAgeAsc(int age);
    Optional<List<UserDAO>> findByAgeLessThanOrderByAgeAsc(int age);
    Optional<List<UserDAO>> findByAgeGreaterThanEqualOrderByAgeAsc(int age);
    Optional<List<UserDAO>> findByAgeLessThanEqualOrderByAgeAsc(int age);

}
