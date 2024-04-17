package com.mongodb.CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.CRUD.model.product.Product;
import com.mongodb.CRUD.model.product.ProductDTO;
import com.mongodb.CRUD.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
@Autowired
public ProductService productService;
@PostMapping
public ResponseEntity<Product> insertProduct(@RequestBody ProductDTO dto){
	Product newProduct = this.productService.insertProduct(dto);
	return ResponseEntity.ok().body(newProduct);
}
@PutMapping("/{id}")
public ResponseEntity<Product> uptadeProduct(@PathVariable String id, @RequestBody ProductDTO dto){
	Product product = this.productService.uptadeProduct(id, dto);
	return ResponseEntity.ok().body(product);
}
@GetMapping
public ResponseEntity<List<Product>> getAllProducts(){
	List<Product> allProducts = this.productService.getAllProducts();
	return ResponseEntity.ok().body(allProducts);
}
@GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable String id){
	Product foundProduct = this.productService.getProductById(id);
	return ResponseEntity.ok().body(foundProduct);
}
@GetMapping("/user/{userId}")
public ResponseEntity<List<Product>>getAllProductByUserId(@PathVariable String userId){
	List<Product> allUserProducts = this.productService.getAllProductsByUserId(userId);
	return ResponseEntity.ok().body(allUserProducts);
}
@DeleteMapping("/{id}")
public void deleteProduct(@PathVariable String id){
	this.productService.deleteProduct(id);
}


}
