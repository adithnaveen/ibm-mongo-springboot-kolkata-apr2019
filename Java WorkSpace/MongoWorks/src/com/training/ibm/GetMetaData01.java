package com.training.ibm;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

public class GetMetaData01 {
	public static void main(String[] args) {

		// localhost - 27017

		MongoClient mongoClient = new MongoClient();
		System.out.println("Connection Got to " + mongoClient);


		for (String dbName : mongoClient.getDatabaseNames()) {
			System.out.println("DB Name : " + dbName);

			DB db = mongoClient.getDB(dbName);

			System.out.println("Collections : ");
			for (String collectionName : db.getCollectionNames()) {
				System.out.println("\t\t" + collectionName);
			}
		}

	}
}
