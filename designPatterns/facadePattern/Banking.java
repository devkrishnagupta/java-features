package designPatterns.facadePattern;

class CustomerAccount{
    public void debitAccount(String fromAccount, double amount){
        System.out.println("Amount: "+amount+" debited from account id: "+fromAccount);
    }

    public void creditAccount(String toAccount, double amount){
        System.out.println("Amount: "+amount+" credited to account id: "+toAccount);
    }
}

class Transactions{
    public void recordTransaction(String fromAccount, String toAccount, double amount){
        System.out.println("Trasaction from account: "+fromAccount+" to account: "+toAccount+" and amount: "+amount+" recorded");
    }
}

class Audit{
    public void logTransaction(String fromAccount, String toAccount, double amount){
        System.out.println("Trasaction from account: "+fromAccount+" to account: "+toAccount+" and amount: "+amount+" loggeded");
    }
}

class BankingFacade {
    private CustomerAccount customerAccount;
    private Transactions transactions;
    private Audit audit;

    public BankingFacade(CustomerAccount customerAccount, Transactions transactions, Audit audit) {
        this.customerAccount = customerAccount;
        this.transactions = transactions;
        this.audit = audit;
    }

    public void makeTransaction(String fromAccount, String toAccount, double amount) {
        customerAccount.debitAccount(fromAccount, amount);
        customerAccount.creditAccount(toAccount, amount);
        transactions.recordTransaction(fromAccount, toAccount, amount);
        audit.logTransaction(fromAccount, toAccount, amount);
    }
}


public class Banking {
    public static void main(String[] args) {
        BankingFacade bankingFacade = new BankingFacade(new CustomerAccount(), new Transactions(), new Audit());
        bankingFacade.makeTransaction("#From_ID", "#TO_ID", 500.00);
    }
}
