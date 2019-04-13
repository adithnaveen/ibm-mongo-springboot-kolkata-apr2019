package com.training.ibm;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class StoreObject04 {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();

		DB db = mongoClient.getDB("ibmdb");
		DBCollection dbCollection = db.getCollection("emps");

		// first way
//		DBObject object = new BasicDBObject(); 
//		
//		object.put("empid", 2001); 
//		object.put("empname", "Kumar"); 
//		object.put("empsal", 3434); 
//		object.put("email", "kumar@gmail.com"); 
//		

		// second way 
//		Map<String, Object> map = new HashMap<>();
//		map.put("empid", 2002);
//		map.put("empname", "Harish");
//		map.put("empsal", 3344);
//		map.put("empemail", "harish@yahoo.com");
//
//		DBObject object = new BasicDBObject(map);


		// 3rd way 
//		String empJson ="{empid:2003, empname:'Roy', empsal:4455, empemail:'roy@gmail.com'}"; 
//		dbCollection.save((DBObject)JSON.parse(empJson));

		Employee emp = new Employee(2100, "Prateek", 5544, "prateek@gmail.com"); 

		dbCollection.save(emp); 
		
		
		System.out.println("Object Saved... ");

	}
}





















