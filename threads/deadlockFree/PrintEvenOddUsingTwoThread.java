package threads.deadlockFree;

class EvenOddPrinting implements Runnable{

    static int counter = 1;
    Object lock;

    public EvenOddPrinting(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        while (counter < 10) {
            if (Thread.currentThread().getName().equals("even") && counter%2==0) {
                synchronized(lock){
                    System.out.println("Even Thread "+Thread.currentThread().getName()+" and Number is "+counter);
                    counter++;
                    lock.notify();
                }
            }
            if (Thread.currentThread().getName().equals("odd") && counter%2!=0) {
                synchronized(lock){
                    System.out.println("Odd Thread "+Thread.currentThread().getName()+" and Number is "+counter);
                    counter++;
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}

public class PrintEvenOddUsingTwoThread {
    public static void main(String[] args) {
        Object lock = new Object();
        Runnable run1 = new EvenOddPrinting(lock);
        Runnable run2 = new EvenOddPrinting(lock);
        Thread thread1 = new Thread(run1, "even");
        Thread thread2 = new Thread(run2, "odd");
        thread1.start();
        thread2.start();
    }

}
