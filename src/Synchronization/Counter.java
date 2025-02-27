package Synchronization;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }
    //sync ensures only one thread has access to the counter at once

    public int getCount() {
        return count;
    }
}
