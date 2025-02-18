public class ThreadPriorityName extends Thread {
    @Override
    public void run() {
        int c = 0;
        for (int i = 0; i < 5; i++) {
            c++;
            System.out.println("Name: " + Thread.currentThread().getName() + ", Count: " + c);
        }
    }

    public static void main(String[] args) {
        ThreadPriorityName l = new ThreadPriorityName();
        ThreadPriorityName m = new ThreadPriorityName();
        ThreadPriorityName h = new ThreadPriorityName();

        System.out.println("Initial name & Priority:");
        System.out.println("Name: " + l.getName() + ", Priority: " + l.getPriority());
        System.out.println("Name: " + m.getName() + ", Priority: " + m.getPriority());
        System.out.println("Name: " + h.getName() + ", Priority: " + h.getPriority());

        System.out.println("After setting name:");
        l.setName("Low");
        m.setName("Medium");
        h.setName("High");
        System.out.println("Name: " + l.getName() + ", Priority: " + l.getPriority());
        System.out.println("Name: " + m.getName() + ", Priority: " + m.getPriority());
        System.out.println("Name: " + h.getName() + ", Priority: " + h.getPriority());

        System.out.println("After setting priorities:");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name: " + l.getName() + ", Priority: " + l.getPriority());
        System.out.println("Name: " + m.getName() + ", Priority: " + m.getPriority());
        System.out.println("Name: " + h.getName() + ", Priority: " + h.getPriority());

        l.start();
        m.start();
        h.start();
    }
}
