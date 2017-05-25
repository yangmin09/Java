package serialTestUtil;


import advanceSerializable.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by yangmin on 16/8/7.
 */
public class SerialTest {

	public static void main(String[] args) throws IOException {
		Person person = new Person(1234, "wang", "hello");
		System.out.println("Person Serial" + person);
		FileOutputStream fos = new FileOutputStream("Person.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(person);
		oos.flush();
		oos.close();

	}
}
