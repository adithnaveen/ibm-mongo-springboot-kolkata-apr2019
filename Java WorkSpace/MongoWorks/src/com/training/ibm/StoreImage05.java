package com.training.ibm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class StoreImage05 {
	public static void main(String[] args) throws FileNotFoundException {
		MongoClient mongoClient = new MongoClient(); 
		
		DB db = mongoClient.getDB("ibmdb"); 
		
		GridFS gfs = new GridFS(db, "myimages");
		
		String path="C:\\Users\\Naveen\\Desktop\\mongod\\Notes & Images\\"; 
		File folderPath = new File(path); 
		
		for(File file : folderPath.listFiles()) {
			InputStream inputStream = new FileInputStream(file); 
			
			GridFSInputFile myFile = 
					gfs.createFile(inputStream, file.getName()); 
			
			myFile.setMetaData(new BasicDBObject("description", "image "
					+ file.getName() +" stored in IBM"));
					
			myFile.save(); 
			
		}
		
		mongoClient.close(); 
		System.out.println("Files stored Successfully");
		
	}
}
