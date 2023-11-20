package threads.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionSolUsingReentrantLock {
    public static void main(String[] args) {
        
        BankAccount bankAccount = new BankAccount(10);

        Runnable depositTask = () -> {
            for(int i=0; i<10; i++){
                bankAccount.deposite(10, i);
            }
        };

        Runnable withdrawTask = () -> {
            for(int i=0; i<10; i++){
                bankAccount.withdraw(10, i);
            }
        };

        Thread thread1 = new Thread(depositTask);
        Thread thread2 = new Thread(depositTask);
        Thread thread3 = new Thread(withdrawTask);
        Thread thread4 = new Thread(withdrawTask);

        
        thread4.start();
        thread3.start();
        thread1.start();
        thread2.start();
        

        System.out.println("--> Final balance after all transactions:- "+bankAccount.getBalance());
    }
}

class BankAccount {

    private int balance;
    private Lock lock;

    public BankAccount(int initialBalance){
        this.balance=initialBalance;
        this.lock=new ReentrantLock();
    }

    public void deposite(int amount, int i){
        lock.lock(); // Acquire the lock
        try{
            balance+=amount;
            System.out.println(Thread.currentThread()+" Deposited "+i+" "+amount+" dollers. New balance "+balance);
        } finally {
            lock.unlock(); // Release the lock in a finally block
        }
    }

    public void withdraw(int amount, int i){
        lock.lock(); // Acquire the lock
        try{
            if (balance >= amount) {
                balance-=amount;
                System.out.println(Thread.currentThread()+" Withdrawn "+i+" "+amount+" dollers. New balance "+balance);
            }else{
                System.out.println(Thread.currentThread()+" Insufficient funds--> ");
            }
        } finally {
            lock.unlock(); // Release the lock in a finally block
        }
    }

    public int getBalance(){
        return this.balance;
    }
}
