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

import com.mongodb.CRUD.model.user.User;
import com.mongodb.CRUD.model.user.UserDTO;
import com.mongodb.CRUD.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
@Autowired
public UserService userService;
@PostMapping
public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
		User newUser = this.userService.createUser(userDTO);
	     return ResponseEntity.ok().body(newUser);
}
@PutMapping("/{id}")
public ResponseEntity<User> uptadeUser(@PathVariable String id,@RequestBody UserDTO userDTO){
		User user = this.userService.uptadeUser(id, userDTO);
	     return ResponseEntity.ok().body(user);
}
@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable String id){
	User user = this.userService.getUserById(id);
	return ResponseEntity.ok().body(user);
}
@GetMapping
public ResponseEntity<List<User>> getUserAllUsers(){
	List<User> user = this.userService.getAllUsers();
	return ResponseEntity.ok().body(user);
}
@DeleteMapping("/{id}")
public void delteUser(@PathVariable String id){
   this.userService.deleteUserById(id);
}
}
