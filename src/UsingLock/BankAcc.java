package UsingLock;

public class BankAcc {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        if(balance>= amount) {
            System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawals ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " Remaining balance after withdrawals " + balance);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " Insufficient balance ");
        }
    }
}
