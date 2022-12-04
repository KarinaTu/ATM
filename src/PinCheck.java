import java.util.Scanner;
public class PinCheck implements Action {
    @Override
    public void execute(Account account, Scanner scanner) {
        System.out.println("Please enter your PIN as 4 digits");
        boolean access = false;
        while (!access) {
            try {
                int inputtedPin = scanner.nextInt();
                if (inputtedPin != account.getPin()) {
                    if (inputtedPin < 999 || inputtedPin > 9999){
                        System.out.println("PIN code must contain 4 digits. Please try again.");
                        System.out.print("Enter your PIN: ");
                        continue;
                    }
                    System.out.println("Incorrect PIN. Please try again.");
                    System.out.print("Enter your PIN: ");
                    continue;
                }
                access = true;
                System.out.println("PIN verified.\n" + account.getClientName() + ", welcome to your bank!");
            } catch (java.util.InputMismatchException e){
                System.out.println("Incorrect PIN. Please try again.");
                scanner.next();
            }
        }
    }
}


