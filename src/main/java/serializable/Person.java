package serializable;

import java.io.Serializable;

/**
 * Created by yangmin on 16/8/7.
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 123456L;
	public int id;
	public transient String name;


	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}


	public String toString() {
		return "Person: " + id + " " + name;
	}


}
