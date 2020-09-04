package in.jk.mongo;

import java.util.Iterator;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoCollectionApplication {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
        // create a database or if database with given already exist use it .
		MongoDatabase database = mongoClient.getDatabase("employeedata");
		database.createCollection("samplecollection"); // create a new collection
		MongoIterable<String>collectionNames=database.listCollectionNames();
		Iterator<String> iterator=collectionNames.iterator();
		System.out.println("All Collection Name ::");
		while (iterator.hasNext()) {
			String name = (String) iterator.next();
			System.out.println(name);
			
		}
		
		System.out.println();
		MongoCollection<Document> sampleCollection = database.getCollection("samplecollection");
		sampleCollection.drop();// drop a collection 
		MongoIterable<String>collectionNames1=database.listCollectionNames();
		Iterator<String> iterator1=collectionNames1.iterator();
		System.out.println("All Collection Name ::");
		while (iterator1.hasNext()) {
			String name = (String) iterator1.next();
			System.out.println(name);
			
		}
		
		mongoClient.close();

	}

}
