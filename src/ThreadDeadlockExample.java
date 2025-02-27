class Pen {
    public synchronized void WriteWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to use paper ");
        paper.finishWriting();
    }
    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
    }
}

class Paper {
    public synchronized void WriteWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to use pen ");
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
    }
}

    class Task1 implements Runnable {
    private Paper paper;
    private Pen pen;
    public Task1(Paper paper, Pen pen) {
    this.paper = paper;
    this.pen = pen;
    }
    public void run() {
        pen.WriteWithPenAndPaper(paper);
    }
    }

    class Task2 implements Runnable {
        private Paper paper;
        private Pen pen;
        public Task2(Paper paper, Pen pen) {
            this.paper = paper;
            this.pen = pen;
        }
        public void run() {
            paper.WriteWithPaperAndPen(pen);
        }
    }

public class ThreadDeadlockExample {
    public static void main(String[] args) {
        Paper paper = new Paper();
        Pen pen = new Pen();

        Thread thread1 = new Thread(new Task1(paper, pen), "Thread1");
        Thread thread2 = new Thread(new Task2(paper, pen), "Thread2");
        thread1.start();
        thread2.start();
    }
}
