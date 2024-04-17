package com.mongodb.CRUD.model.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
@Id
private String id;
private String email;
private Integer cpf;
private List<String> productsOwned;
public User() {
}
public User(UserDTO userDTO) {
	this.email= userDTO.email();
	this.cpf = userDTO.cpf();
	this.productsOwned = new ArrayList<String>();
}
public User(String id, String email, Integer cpf) {
	this.id = id;
	this.email = email;
	this.cpf = cpf;
	this.productsOwned = new ArrayList<String>();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getCpf() {
	return cpf;
}
public void setCpf(Integer cpf) {
	this.cpf = cpf;
}
public List<String> getProductsOwned() {
	return productsOwned;
}
public void setProductsOwned(List<String> productsOwned) {
	this.productsOwned = productsOwned;
}

}
