package UsingLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAcc {
    private int balance = 100;

    private Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        /*if(balance>= amount) {
            System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawals ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " Remaining balance after withdrawals " + balance);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " Insufficient balance ");
        }*/
        //commented to implement explicit lock now

        //EXPLICIT LOCK -
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance>= amount) {
                    System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawals ");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " Remaining balance after withdrawals " + balance);
                }
                else {
                    System.out.println(Thread.currentThread().getName() + " Insufficient balance ");
                }
            } else {
                System.out.println(Thread.currentThread().getName() +" Could not acquire the lock, try later ");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
