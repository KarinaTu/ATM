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

        boolean isSessionActive = false;
        while (true) {
            if (!isSessionActive) {
                actions.get(0).execute(user, scanner);
                isSessionActive = true;
            }
            System.out.println("Your account balance is " + user.getBalance());
            boolean choice = false;
            while (!choice) {
                System.out.println("Please select the action: 1 = Withdrawal, 2= Deposit, 3 = Exit");
                try {
                    int inputtedChoice = scanner.nextInt();
                    if (inputtedChoice < 1 || inputtedChoice > 3) {
                        System.out.println("Incorrect selection. Please try again.");
                        continue;
                    } else if (inputtedChoice == 3) {
                        isSessionActive = false;
                    } else {
                        actions.get(inputtedChoice).execute(user, scanner);
                    }
                    choice = true;
                } catch (InputMismatchException e) {
                    System.out.println("Inserted wrong number. Please try again.");
                    scanner.next();
                }
            }
        }
    }
}







