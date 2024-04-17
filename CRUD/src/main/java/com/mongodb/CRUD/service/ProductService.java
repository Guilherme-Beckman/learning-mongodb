package com.mongodb.CRUD.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.CRUD.model.product.Product;
import com.mongodb.CRUD.model.product.ProductDTO;
import com.mongodb.CRUD.model.product.exceptions.ProductNotFoundException;
import com.mongodb.CRUD.model.user.User;
import com.mongodb.CRUD.model.user.UserDTO;
import com.mongodb.CRUD.repository.ProductRepository;
import com.mongodb.CRUD.repository.UserRepository;

@Service
public class ProductService {
@Autowired 
public ProductRepository productRepository;
@Autowired
public UserService userService;
@Autowired
public UserRepository userRepository;
@Transactional
public Product insertProduct(ProductDTO productDTO) {
	User foundUser = this.userService.getUserById(productDTO.ownerId());
	Product newProduct = new Product(productDTO);
	Product addedProduct = this.productRepository.save(newProduct);
	List<String> userProducts = foundUser.getProductsOwned();
	userProducts.add(addedProduct.getId());
	foundUser.setProductsOwned(userProducts);
	this.userRepository.save(foundUser);
	return addedProduct;
}
public Product uptadeProduct(String id, ProductDTO productDTO) {
	Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
	if(!(productDTO.name().isEmpty())) product.setName(productDTO.name());
	if(!(productDTO.price()==null)) product.setPrice(productDTO.price());
	if(!(productDTO.description().isEmpty())) product.setDescription(productDTO.description());
	return this.productRepository.save(product);
}
public Product getProductById(String id) {
	return this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
	
}
public List<Product> getAllProducts() {
	return this.productRepository.findAll();
}
public List<Product> getAllProductsByUserId(String userId){
	User foundUser = this.userService.getUserById(userId);
	List<String> listOfUserProductsId = foundUser.getProductsOwned();
	List<Product> listOfUserProducts = new ArrayList<Product>();
	listOfUserProductsId.forEach(product ->{
		listOfUserProducts.add(this.productRepository.findById(product).orElseThrow(ProductNotFoundException::new));
	});
	return listOfUserProducts;
}
@Transactional
public void deleteProduct(String id) {
	Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
	this.productRepository.delete(product);
	User user = this.userService.getUserById(product.getOwnerId());
	List<String> listOfUserProductsId = user.getProductsOwned();
	listOfUserProductsId.remove(product.getId());
	this.userRepository.save(user);
	
}
}
