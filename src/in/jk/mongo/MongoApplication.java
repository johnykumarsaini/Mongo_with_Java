package in.jk.mongo;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoApplication {

	public static void main(String[] args) {

		try {

			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase database = mongoClient.getDatabase("employeedata");
			// database.createCollection("empcollection"); // create a collection if not
			// exist ..
			MongoCollection<Document> collection = database.getCollection("empcollection");
			Document document = new Document();
			document.put("empId", 4);
			document.put("name", "JK");
			document.put("company", "10 Gen Inc");
			collection.insertOne(document);
			System.out.println("Document Save Succussfully .");
			System.out.println();
			MongoCollection<Document> empCollection = database.getCollection("empcollection");
			System.out.println("Size of Collection :: " + empCollection.count());
			FindIterable<Document> findItr = empCollection.find();
			MongoCursor<Document> cursor = findItr.iterator();
			while (cursor.hasNext()) {
				Document document2 = (Document) cursor.next();
				System.out.println(document2);

			}

			mongoClient.close();

		} catch (Exception e) {

			System.out.println("Exception ::" + e);
		}

	}
}
