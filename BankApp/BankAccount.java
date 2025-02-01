import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private double balance;
    private int monthsBelowMinimumBalance;
    private static final double MINIMUM_BALANCE = 1000;
    private static final double MONTHLY_CHARGE_PERCENTAGE = 0.01;
    private static final double MONTHLY_CHARGE = MINIMUM_BALANCE * MONTHLY_CHARGE_PERCENTAGE;

    public BankAccount(String accountHolderName, double initialDeposit) {
        if (initialDeposit < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial deposit must be at least " + MINIMUM_BALANCE + " rupees.");
        }
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.monthsBelowMinimumBalance = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println(amount + " rupees deposited successfully.");
        checkAndResetMinimumBalanceStatus(); 
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance - amount < MINIMUM_BALANCE) {
            System.out.println("Warning: Withdrawing this amount will cause your balance to fall below the minimum required balance of " + MINIMUM_BALANCE + " rupees.");
            System.out.println("If you proceed, a monthly charge of " + MONTHLY_CHARGE + " rupees (1% of " + MINIMUM_BALANCE + ") will be applied until the balance is restored.");
            System.out.print("Do you want to proceed? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("yes")) {
                balance -= amount;
                System.out.println(amount + " rupees withdrawn successfully.");
                applyMonthlyCharge();
            } else {
                System.out.println("Withdrawal cancelled.");
            }
        } else {
            balance -= amount;
            System.out.println(amount + " rupees withdrawn successfully.");
        }
    }

    private void applyMonthlyCharge() {
        if (balance < MINIMUM_BALANCE) {
            monthsBelowMinimumBalance++;
            balance -= MONTHLY_CHARGE;
            System.out.println("Monthly charge of " + MONTHLY_CHARGE + " rupees (1% of " + MINIMUM_BALANCE + ") applied.");
            System.out.println("Months below minimum balance: " + monthsBelowMinimumBalance);

            if (monthsBelowMinimumBalance >= 3) {
                System.out.println("Your account balance is now negative due to prolonged insufficient balance.");
            }
        }
    }

    private void checkAndResetMinimumBalanceStatus() {
        if (balance >= MINIMUM_BALANCE) {
            monthsBelowMinimumBalance = 0; 
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance + " rupees.");
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}