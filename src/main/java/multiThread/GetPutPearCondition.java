package multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/3/3 下午8:14
 * @description
 */
public class GetPutPearCondition {


	public static void main(String[] args) {
		UtilBoxNew box = new UtilBoxNew(new ArrayList(), new ReentrantLock());
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

class UtilBoxNew {

	volatile List<Pear> items;
	volatile ReentrantLock lock;
	volatile Condition notEmpty;
	volatile Condition notFull;

	public UtilBoxNew(List items, ReentrantLock lock) {
		this.items = items;
		this.lock = lock;
		this.notEmpty = lock.newCondition();
		this.notFull = lock.newCondition();
	}


	void get() {

		try {
			lock.lock();
			while (items.size() == 0)
				notEmpty.await();
			items.remove(0);
			System.out.println("Ann has get an pear" + " now " + items.size() + " left");
			notFull.signal();
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void put() {

		try {
			lock.lock();
			while (items.size() == 5)
				notFull.await();
			items.add(new Pear("hangzhou", "yellow", 20));
			System.out.println("Jim has put an pear" + " now " + items.size() + " left");
			notEmpty.signal();
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}


}