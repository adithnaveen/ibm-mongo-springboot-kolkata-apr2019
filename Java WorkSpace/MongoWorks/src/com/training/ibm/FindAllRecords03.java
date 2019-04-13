package com.training.ibm;

import java.util.HashMap;
import java.util.Map;

import javax.activation.MailcapCommandMap;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class FindAllRecords03 {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();

		DB db = mongoClient.getDB("ibmdb");
		DBCollection dbCollection = db.getCollection("emps");
		
	//	DBCursor dbCursor = dbCollection.find(); 
		
		
		// check if you do gt 
//		Map<String, String> myComplexQuery = new HashMap<>(); 
//		
//		myComplexQuery.put("empname", "Amit"); 
//		myComplexQuery.put("empsal", "2222"); 
		
		
		DBObject query = new BasicDBObject();
		
		DBObject sort = new BasicDBObject("empname", 1); 
		
		Map<String, Integer> map = new HashMap<>(); 
		map.put("empid", 1); 
		map.put("_id", 0); 
		map.put("empname", 1); 
		
		DBObject projection = new BasicDBObject(map);
		
//		DBCursor dbCursor = dbCollection.find(query);
		
		DBCursor dbCursor = dbCollection.find(query, projection).sort(sort); 
		
		while(dbCursor.hasNext()) {
			DBObject myObject = dbCursor.next(); 
			
			System.out.println(JSON.serialize(myObject));
			
//			System.out.println("Emp Id " + myObject.get("empid"));
//			System.out.println("Emp Name " + myObject.get("empname"));
//			System.out.println("Emp Sal " + myObject.get("empsal"));
			System.out.println("------------------------------------");
		}

	}
}
