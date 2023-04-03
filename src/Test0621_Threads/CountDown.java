package Test0621_Threads;

public class CountDown extends Thread{
    private boolean cancelled;

    public void cancel(){
        cancelled = true;

    }

    @Override
    public void run(){
        for(int i = 10; i >= 0 && !cancelled; i--) {
            if (i > 0) {
                System.out.println(currentThread());
                System.out.println(i + " ...");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
                System.out.println("Go!");
        }
    }
}
