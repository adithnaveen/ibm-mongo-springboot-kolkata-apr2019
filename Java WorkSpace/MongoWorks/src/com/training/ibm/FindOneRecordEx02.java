package com.training.ibm;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class FindOneRecordEx02 {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();

		DB db = mongoClient.getDB("ibmdb");
		DBCollection dbCollection = db.getCollection("emps");

		DBObject myObject = dbCollection.findOne();

		System.out.println("Emp Id " + myObject.get("empid"));
		System.out.println("Emp Name " + myObject.get("empname"));
		System.out.println("Emp Sal " + myObject.get("empsal"));
	}
}
