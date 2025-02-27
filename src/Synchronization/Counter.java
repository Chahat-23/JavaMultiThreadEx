package Synchronization;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }
    //sync ensures only one thread has access to the shared resource of counter at once - Also called mutual exclusion

    public int getCount() {
        return count;
    }
}
