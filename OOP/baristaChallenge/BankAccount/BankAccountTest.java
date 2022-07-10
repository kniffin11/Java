public class BankAccountTest {
    public static void main(String [] args){
        BankAccount Bob = new BankAccount();

        Bob.depositChecking(200.1);
        Bob.withdrawChecking(72.5);
        Bob.depositSavings(1040.2);
        System.out.println(Bob.getCheckingBalance());
        System.out.println(Bob.getAccountNumber());
        System.out.println(Bob.totalMoney());
    }
}
