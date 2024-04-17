package com.mongodb.CRUD.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.CRUD.model.user.User;
import com.mongodb.CRUD.model.user.UserDTO;
import com.mongodb.CRUD.model.user.exceptions.UserNotFoundException;
import com.mongodb.CRUD.repository.UserRepository;

@Service
public class UserService {
@Autowired
public UserRepository userRepository;

public User createUser(UserDTO userDTO) {
	User newUser = new User(userDTO);
	User createdUser = this.userRepository.save(newUser);
	return createdUser;
}
public User uptadeUser(String id, UserDTO userDTO) {
	User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	if(!(userDTO.email().isEmpty())) user.setEmail(userDTO.email());
	if(!(userDTO.cpf()==null)) user.setCpf(userDTO.cpf());
	return this.userRepository.save(user);
}
public User getUserById(String Id) {
	return this.userRepository.findById(Id).orElseThrow(UserNotFoundException::new);
}
public List<User> getAllUsers() {
	return this.userRepository.findAll();
}
public void deleteUserById(String id) {
	this.userRepository.deleteById(id);
}
}
