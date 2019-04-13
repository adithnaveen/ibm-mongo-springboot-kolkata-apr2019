package com.ibm.mongoworks.springmongoworks.config;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ibm.mongoworks.springmongoworks.model.Address;
import com.ibm.mongoworks.springmongoworks.model.User;
import com.ibm.mongoworks.springmongoworks.repository.UserRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses=UserRepository.class)
public class MongoConfig {

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return string -> {
		/*	userRepository.insert(new User(110, "Naveen", new Date(), 4500, Arrays.asList(
					new Address("Personal", 10,"StevensKreek", "Kolkata", "India"),
					new Address("Office", 23,"Stevenscreek", "Cupertino", "USA")					
					)));

			userRepository.insert(new User(111, "Krishna", new Date(), 6500, Arrays.asList(
					new Address("Personal", 10,"MagadiRoad", "Bengaluru", "India"),
					new Address("Office", 43,"American Dream Way", "Reston", "USA")					
					))); */
		}; 
	} 
	
}
