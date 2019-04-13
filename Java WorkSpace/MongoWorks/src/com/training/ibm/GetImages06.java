package com.training.ibm;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

public class GetImages06 {
	public static void main(String[] args) throws IOException {

		String path = "C:\\Users\\Naveen\\Desktop\\retrivedimages\\";

		MongoClient mongoClient = new MongoClient();

		DB db = mongoClient.getDB("ibmdb");

		GridFS gfs = new GridFS(db, "myimages");

		List<GridFSDBFile> list = gfs.find(new BasicDBObject());

		for (GridFSDBFile file : list) {
			file.writeTo(path + file.getFilename());
		}
		
		System.out.println("Images retrived... ");
	}
}





