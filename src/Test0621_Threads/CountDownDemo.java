package Test0621_Threads;

public class CountDownDemo {
    public static void main(String[] args) {
        CountDown cd = new CountDown();
        cd.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //cd.interrupt();
        cd.cancel();

    }
}
