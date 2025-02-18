public class Main {
    public static void main(String[] args) {
        World world = new World();
        world.start();
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName());
        }

        World2 world2 = new World2(); //New state
        Thread t1 = new Thread(world2); //Runnable state
        t1.start(); //Running state
        //Blocked Waiting state
        //Terminated state
    }
}

