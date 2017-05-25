package multiThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2016/11/5 上午12:35
 * @description
 */
class Reminder {
	Timer timer;

	public Reminder(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
	}

	public static void main(String args[]) {
		System.out.println("About to schedule task.");
		new Reminder(5);
		System.out.println("Task scheduled.");
	}

	class RemindTask extends TimerTask {
		public void run() {
			System.out.println("Time''s up!");
			timer.cancel(); //Terminate the timer thread
			System.out.println("the expected execution time is" + scheduledExecutionTime());
		}
	}
}


