package multiThread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/3 下午7:51
 * @description
 */
public class GetPutPear {

	public static void main(String[] args) {

		UtilBox box = new UtilBox(new ArrayList(), new Object());


		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					box.get();
				}
			}
		}).start();


		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					box.put();
				}
			}
		}).start();
	}


}


class UtilBox {

	volatile List<Pear> items;
	final Object obj;


	public UtilBox(List items, Object obj) {
		this.items = items;
		this.obj = obj;
	}


	void get() {

		try {
			synchronized (obj) {
				while (items.size() == 0)
					obj.wait();
				items.remove(0);
				System.out.println("Ann has get an pear" + " now " + items.size() + " left");
				obj.notify();

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void put() {


		try {
			synchronized (obj) {
				while (items.size() == 5)
					obj.wait();
				items.add(new Pear("hangzhou", "yellow", 20));
				System.out.println("Jim has put an pear" + " now " + items.size() + " left");
				obj.notify();
			}


		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}


}

/**
 * pear entity
 */
class Pear {

	String location;
	String color;
	int weight;

	public Pear() {
		super();
	}

	public Pear(String location, String color, int weight) {
		this.location = location;
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}