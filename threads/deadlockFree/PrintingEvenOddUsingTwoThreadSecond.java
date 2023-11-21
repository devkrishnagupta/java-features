package threads.deadlockFree;

public class PrintingEvenOddUsingTwoThreadSecond {

    private static final int MAX_NUMBER = 10;
    private static volatile int number = 1;
    private static final Object lock = new Object();

    private static Thread evenThread = new Thread(() -> {
        while (number <= MAX_NUMBER) {
            synchronized(lock){
                if (number%2==0) {
                    System.out.println("Even Thread: "+number);
                    number++;
                    lock.notify();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    });

    private static Thread oddThread = new Thread(() -> {
        while (number <= MAX_NUMBER) {
            synchronized(lock){
                if (number%2!=0) {
                    System.out.println("Odd Thread: "+number);
                    number++;
                    lock.notify();
                }else{
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    });

    public static void main(String[] args) {
        oddThread.start();
        evenThread.start();
    }
}
