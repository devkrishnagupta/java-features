package threads.synchronization;

public class RaceConditionSolUsingSynchronizationBlock {
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
        thread1.start();
        thread3.start();
        thread2.start();
        

        System.out.println("--> Final balance after all transactions:- "+bankAccount.getBalance());
    }
}

class BankAccount {

    private int balance;

    public BankAccount(int initialBalance){
        this.balance=initialBalance;
    }

    public synchronized void deposite(int amount, int i){
        balance+=amount;
        System.out.println(Thread.currentThread()+" Deposited "+i+" and "+amount+" dollers. New balance "+balance);
    }

    public synchronized void withdraw(int amount, int i){
        if (balance >= amount) {
            balance-=amount;
            System.out.println(Thread.currentThread()+" Withdrawn "+i+" and "+amount+" dollers. New balance "+balance);
        }else{
            System.out.println(Thread.currentThread()+" Insufficient "+i+" funds--> ");
        }
    }

    public int getBalance(){
        return this.balance;
    }
}