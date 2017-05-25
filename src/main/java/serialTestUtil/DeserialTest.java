package serialTestUtil;


import advanceSerializable.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by yangmin on 16/8/7.
 */
public class DeserialTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person person;

		FileInputStream fis = new FileInputStream("Person.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		person = (Person) ois.readObject();
		ois.close();
		System.out.println("Person Deserial" + person.message);
	}

}
