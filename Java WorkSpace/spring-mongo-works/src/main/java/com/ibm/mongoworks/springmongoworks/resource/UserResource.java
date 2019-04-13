package com.ibm.mongoworks.springmongoworks.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mongoworks.springmongoworks.exception.UserNotFoundException;
import com.ibm.mongoworks.springmongoworks.model.User;
import com.ibm.mongoworks.springmongoworks.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	// http://localhost:9090/users
	@GetMapping(path = "/users")
	public List<User> getAllUsersFromDb() {
		return this.userService.getAllUsers();
	}

	@GetMapping(path = "/users/{id}")
	public Resource<User> getUser(@PathVariable Integer id) {
		User user = this.userService.getUserByIdAsObject(id);

		if (user == null) {
			throw new UserNotFoundException("Sorry user with id " + id  +" Not found"); 
		}

		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder allUsersLink = linkTo(methodOn(this.getClass()).getAllUsersFromDb());
		resource.add(allUsersLink.withRel("all-users"));
		return resource;
	}

	
	@GetMapping(path = "/users/name/{name}")
	public Resource<User> getUserByName(@PathVariable String name) {
		User user = this.userService.getUserByName(name); 

		if (user == null) {
			throw new UserNotFoundException("Sorry user with Name " + name +" Not found"); 

		}

		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder allUsersLink = linkTo(methodOn(this.getClass()).getAllUsersFromDb());
		resource.add(allUsersLink.withRel("all-users"));
		return resource;
	}
	
	@PostMapping(path = "/users")
	public User insertDBUser(@RequestBody User user) {
		return this.userService.insertUser(user);
	}

	@PutMapping(path="/users")
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}

	
	@DeleteMapping(path="/users/{id}")
	public String deleteUserById(@PathVariable Integer id) {
		if(this.userService.getUserById(id).isPresent()) {
			this.userService.deleteUserById(id);
			return "User Deleted with Id " + id;
		}
		return "Sorry User Not Found for : " + id; 
	}

	@GetMapping(path="/users/income/{income}")
	public List<User> getUserGreaterThanIncome(@PathVariable double income){
		return this.userService.getUserGreaterThanIncome(income); 
	}
}
