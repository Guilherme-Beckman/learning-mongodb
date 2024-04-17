package com.mongodb.CRUD.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.CRUD.model.product.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
