package com.DSSystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DSSystem.entity.Actor;
import com.DSSystem.entity.User;
import com.DSSystem.repository.UserRepository;





@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerJpaRepo {
	//Dependency injection to get access to repository auto-created by hybernate
/*
 * what is dependancy injection?
 * Dependency injection is an implementation of “inversion of control” principle. 
 * Inversion of control (IoC) says that objects don’t create other objects that they rely on to do their job; 
 * instead, they get the objects they need from an external source (eg, an XML configuration file).	
 */
	//We inject the productRepository into the prdtRepo field.
	@Autowired
	private UserRepository userRepository;
	
	
	//The @GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
	@GetMapping("/users")
	public List<User> getUsersDb() {
		List<User> lstUSers = userRepository.findAll();
		System.out.print(lstUSers);
		return lstUSers;
	}
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}
// /users/itsmetulsi@gmail.com/test
	@GetMapping("/users/{email}/{pass}")
	public User authenticate(@PathVariable(value="email") String email, @PathVariable(value="pass")String pass) {
		System.out.print(email+ " "+ pass);
		User authenticatedUser = userRepository.findByEmailAndPassword(email,pass);
		return  authenticatedUser;
	}
	
	@GetMapping("/users/checkEmail/{email}")
	public Boolean emailInUse(@PathVariable(value="email") String email) {
		
		User exictingUser = userRepository.findByEmail(email);
		if(exictingUser != null)
			return true;
		else
			return false;
	}
	
	@GetMapping("/users/checkPhone/{phone}")
	public Boolean phoneInUse(@PathVariable(value="phone") String phone) {
		
		User exictingUser = userRepository.findByPhone(phone);
		if(exictingUser != null)
			return true;
		else
			return false;
	}
	
	
	
	
}
