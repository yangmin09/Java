package multiThread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/3 下午7:05
 * @description an easy programme: Ann likes to eat apple, while Jim likes to deliver apple; so this programme
 * enable the process
 * synchronized+wait
 */
public class GetPutApple {


	public static void main(String[] args) {

		List<Apple> items = new ArrayList<>();
		Object obj = new Object();
		new Thread(new Get(items, obj)).start();
		new Thread(new Put(items, obj)).start();

	}

}

class Get implements Runnable {

	volatile List<Apple> items;
	final Object obj;

	public Get(List items, Object obj) {
		this.items = items;
		this.obj = obj;
	}

	@Override
	public void run() {

		synchronized (obj) {
			try {
				while (true) {
					while (items.size() == 0)
						obj.wait();
					items.remove(0);
					System.out.println("Ann has get an apple" + " now "+items.size()+" left");
					obj.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}


class Put implements Runnable {

	volatile List<Apple> items;
	final Object obj;

	public Put(List items, Object obj) {
		this.items = items;
		this.obj = obj;
	}

	@Override
	public void run() {

		synchronized (obj) {
			try {
				while (true) {
					while (items.size() == 5)
						obj.wait();
					items.add(new Apple("hangzhou", "red", 20));
					System.out.println("Jim has put an apple" + " now "+items.size()+" left");
					obj.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * apple entity
 */
class Apple {

	String location;
	String color;
	int weight;

	public Apple() {
		super();
	}

	public Apple(String location, String color, int weight) {
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
