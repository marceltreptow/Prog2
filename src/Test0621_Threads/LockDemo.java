package Test0621_Threads;

import static java.lang.Thread.sleep;

public class LockDemo {
    private static Object lock = new Object();

    public /*synchronized*/ void doIt(){
        synchronized (lock) {
            System.out.println("started");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finished");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }
    }

    public static void main(String[] args) {
        LockDemo demo1 = new LockDemo();
        LockDemo demo2 = new LockDemo();

        //new Thread(() -> demo1.doIt()).start();
        new Thread(demo1::doIt).start();
        new Thread(demo1::doIt).start();
        new Thread(demo2::doIt).start();

    }
}
