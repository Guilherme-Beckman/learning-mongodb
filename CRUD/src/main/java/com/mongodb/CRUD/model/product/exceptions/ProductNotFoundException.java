package com.mongodb.CRUD.model.product.exceptions;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException() {
		super("Product Not Found");
		
	}
	

}
