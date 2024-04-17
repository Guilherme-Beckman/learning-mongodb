package com.mongodb.CRUD.model.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
@Id
private String id;
private String name;
private Integer price;
private String description;
private String ownerId;

public Product() {
	super();
}
public Product(ProductDTO dto) {
	this.name = dto.name();
	this.price = dto.price();
	this.description = dto.description();
	this.ownerId = dto.ownerId();
}

public Product(String id, String name, Integer price, String description, String ownerId) {
	this.id = id;
	this.name = name;
	this.price = price;
	this.description = description;
	this.ownerId = ownerId;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
public String getOwnerId() {
	return ownerId;
}
public void setOwnerId(String ownerId) {
	this.ownerId = ownerId;
}




}
