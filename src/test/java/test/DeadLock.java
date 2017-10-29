package test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Hercules
 * @mailto ym99929@alibaba-inc.com
 * @date 2017/8/4 下午3:23
 * @description
 */
public class DeadLock {

    private Object str1 = new Object();
    private Object str2 = new Object();

    void run1() throws Exception {

        synchronized (str1) {

            Thread.sleep(1000);

            synchronized (str2) {

                System.out.println("hi this is str2");
            }
        }

    }

    void run2() throws Exception {

        synchronized (str2) {

            Thread.sleep(1000);

            synchronized (str1) {

                System.out.println("hi this is str1");
            }

        }

    }

    public static void main(String[] args) throws Exception {
        //DeadLock hi=new DeadLock();
        //System.out.println("init---");
        //new Thread(new MyTask(false, hi)).start();
        //new Thread(new MyTask(true, hi)).start();
        //
        LockSupport.park();
    }

     static class MyTask implements Runnable {

        private DeadLock dl;

        public boolean flag;

        public MyTask(boolean flag, DeadLock dl) {
            this.flag = flag;
            this.dl = dl;
        }

        public void run() {

            if (flag == true)

            {
                try {
                    dl.run1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    dl.run2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
