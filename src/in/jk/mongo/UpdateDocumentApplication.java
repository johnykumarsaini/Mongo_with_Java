package in.jk.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class UpdateDocumentApplication {

	public static void main(String[] args) {

		try {

			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase database = mongoClient.getDatabase("employeedata");
			// database.createCollection("empcollection");
			MongoCollection<Document> collection = database.getCollection("empcollection");
			System.out.println("Size of Collection :: " + collection.count());
            FindIterable<Document> findItr = collection.find();
            MongoCursor<Document> cursor = findItr.iterator();
            while (cursor.hasNext()) {
				Document document2 = (Document) cursor.next();
                System.out.println(document2);

			}
			System.out.println();
			MongoCollection<Document> empCollection1 = database.getCollection("empcollection");
			empCollection1.updateOne(Filters.eq("name", "JK"), Updates.set("name", "johny"));
			System.out.println("After Update :: ");
			System.out.println("Size of Collection :: " + collection.count());
            FindIterable<Document> findItr1 = collection.find();
            MongoCursor<Document> cursor1 = findItr1.iterator();
            while (cursor1.hasNext()) {
				Document document2 = (Document) cursor1.next();
                System.out.println(document2);

			}

			mongoClient.close();

		} catch (Exception e) {

			System.out.println("Exception ::" + e);
		}

	}

}
