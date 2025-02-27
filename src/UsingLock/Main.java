package UsingLock;

public class Main {
    public static void main(String[] args) {
        BankAcc bankAcc = new BankAcc();
        Runnable task = new Runnable() {

            @Override
            public void run() {
                bankAcc.withdraw(50);
            }
        };

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        t1.start();
        t2.start();
    }
}
