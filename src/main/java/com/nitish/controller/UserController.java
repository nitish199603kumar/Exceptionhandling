package com.nitish.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitish.dto.UserRequest;
import com.nitish.entity.User;
import com.nitish.exception.NoUserFoundException;
import com.nitish.exception.UserNotFoundException;
import com.nitish.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest)
	{
		User saveUser = userService.saveUser(userRequest);
		return new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getalluser")
	public ResponseEntity<List<User>> getAllUser() throws NoUserFoundException
	{
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
	
	@GetMapping("/getoneuser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws UserNotFoundException
	{
		User user = userService.getUser(id);	
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	
	
}