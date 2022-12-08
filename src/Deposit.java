import java.util.Scanner;

public class Deposit implements Action {
    @Override
    public void execute(Account account, Scanner scanner) {
        System.out.println("Please insert the amount to deposit");
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println("Amount must be positive");
        } else {
            account.setBalance(account.getBalance() + amount);
            System.out.println(amount + "eur successfully deposited");
        }
    }
}
