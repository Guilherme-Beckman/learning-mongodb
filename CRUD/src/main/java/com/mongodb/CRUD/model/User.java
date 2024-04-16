package com.mongodb.CRUD.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
@Id
public String id;
public String email;
public Integer cpf;
public User() {
}
public User(UserDTO userDTO) {
	this.email= userDTO.email();
	this.cpf = userDTO.cpf();
}
public User(String id, String email, Integer cpf) {
	super();
	this.id = id;
	this.email = email;
	this.cpf = cpf;
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

}
