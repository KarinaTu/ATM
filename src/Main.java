import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account user = new Account("Tanel", 632.50, 5684);
        Scanner scanner = new Scanner(System.in);
        List<Action> actions = new ArrayList<Action>();
        actions.add(0, new PinCheck());
        actions.add(1, new CashOut());
        actions.add(2, new Deposit());

        boolean session = false;
        while (true) {
            if (!session) {
                actions.get(0).execute(user, scanner);
                session = true;
            }
            System.out.println("Your account balance is " + user.getBalance());
            boolean choice = false;
            while (!choice) {
                System.out.println("Please select the action: 1 = Withdrawal, 2= Deposit, 3 = Exit");
                try {
                    int inputtedChoice = scanner.nextInt();
                    if (inputtedChoice <= 0 || inputtedChoice > 3) {
                        System.out.println("Incorrect selection. Please try again.");
                        continue;
                    }
                    choice = true;
                    if (inputtedChoice == 3) {
                        session = false;
                    } else {
                        actions.get(inputtedChoice).execute(user, scanner);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Inserted wrong number. Please try again.");
                    scanner.next();
                }
            }
        }
    }
}







