package advanceSerializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by yangmin on 16/8/7.
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 123456L;
	public int id;
	public transient String name;
	public String message = "great";

	public Person(int id, String name, String message) {
		this.id = id;
		this.name = name;
		this.message = message;
	}

	public Person() {


		this.message = "once more";


	}

	public void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {

		id = objectInputStream.readInt();
		name = (String) objectInputStream.readObject();


	}

	public void writeObject(ObjectOutputStream objectOutputStream) throws IOException {

		objectOutputStream.writeInt(id);
		objectOutputStream.writeObject(name);

	}


	public String toString() {
		return "Person: " + id + " " + name;
	}
}
