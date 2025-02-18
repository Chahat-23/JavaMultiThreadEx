public class ThreadLifeCycle extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifeCycle t1 = new ThreadLifeCycle();
        System.out.println(t1.getState()); //New
        t1.start();
        System.out.println(t1.getState()); //Runnable
        Thread.sleep(100);
        System.out.println(t1.getState()); //Timed Waiting as it is in sleep
        t1.join();
        System.out.println(t1.getState()); //Terminated
    }
}
