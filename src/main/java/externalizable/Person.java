package externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by yangmin on 16/8/7.
 */
public class Person implements Externalizable {
	private static final long serialVersionUID = 123456L;
	public int id;
	public String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Person() {

		this.id = 0;
		this.name = "hello";


	}

	public String toString() {
		return "Person: " + id + " " + name;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeObject(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		id = in.readInt();
		name = (String) in.readObject();

	}


}
