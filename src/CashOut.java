import java.util.Scanner;

public class CashOut implements Action{
    @Override
    public void execute(Account account, Scanner scanner) {
        System.out.println("Please insert the amount to withdraw");
            double amount = scanner.nextDouble();
            if (amount > account.getBalance()) {
                System.out.println("Insufficient amount on your account");
            } else if(amount < 0){
                System.out.println("Amount must be positive");
            } else {
                account.setBalance(account.getBalance() - amount);
                System.out.println(amount + "eur successfully withdrawn");
            }
        }
    }

