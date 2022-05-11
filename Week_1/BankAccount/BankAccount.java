import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    private static int numberOfAccounts = 0;
    private static int totalMoneyStored = 0;

    public BankAccount(){
        accountNumber = makeAccountNumber();
        checkingBalance = 0;
        savingsBalance = 0;
        numberOfAccounts++;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void depositChecking(double money){
        checkingBalance += money;
        totalMoneyStored += money;
    }

    public void depositSavings(double money){
        savingsBalance += money;
        totalMoneyStored += money;
    }

    public void withdrawChecking(double money){
        if((checkingBalance - money) > 0){
            checkingBalance -= money;
            totalMoneyStored -= money;
        }
        else 
        {
            System.out.println("Insufficient Funds");
        }
    }

    public void withdrawSavings(double money){
        if((savingsBalance - money) > 0){
            savingsBalance -= money;
            totalMoneyStored -= money;
        }
        else 
        {
            System.out.println("Insufficient Funds");
        }
    }

    public double totalMoney(){
        return totalMoneyStored;
    }

    public String makeAccountNumber(){
        Random num = new Random();
        String temp = "";
        for(int i = 0; i < 10; i++){
            temp += num.nextInt(9) + 1;
        }
        return temp;
    }
}
