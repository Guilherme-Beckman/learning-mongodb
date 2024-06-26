package com.mongodb.CRUD.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.CRUD.model.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
