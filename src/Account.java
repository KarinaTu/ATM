public class Account {

    private String clientName;
    private double balance;
    private int pin;

    public Account(String clientName, double balance, int pin) {
        this.clientName = clientName;
        this.balance = balance;
        this.pin = pin;
    }

    public String getClientName() {
        return clientName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }
}
