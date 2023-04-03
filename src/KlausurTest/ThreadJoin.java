package KlausurTest;

public class ThreadJoin {
    static class BankAccount {
        int balance;
        void increment() {
            int tmp = balance;
            balance = tmp + 1;
        }
    }

    static class IncJob implements Runnable {
        BankAccount account;
        IncJob(BankAccount account) { this.account = account; }
        public void run() {
            for (int i = 0; i < 1000; i++)
                account.increment();
            System.out.println
                    ("Job finished. Account balance: " + account.balance);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(new IncJob(account));
        Thread t2 = new Thread(new IncJob(account));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println
                ("Final account balance: " + account.balance);
    }
}

