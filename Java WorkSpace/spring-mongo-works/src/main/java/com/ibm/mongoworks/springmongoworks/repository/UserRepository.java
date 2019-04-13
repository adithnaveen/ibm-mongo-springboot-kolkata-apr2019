package com.ibm.mongoworks.springmongoworks.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ibm.mongoworks.springmongoworks.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	public User findByName(String name);
	

	// given income it shows name and country (embedded document) 
	@Query(value= "{'income':{$gt:?0}}", fields="{'name':1, 'address.country':1}")
	List<User> findByUserIncome(double income); 	
}
