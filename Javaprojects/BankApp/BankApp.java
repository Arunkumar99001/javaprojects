import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank!");

        System.out.print("Enter your name to open an account: ");
        String name = scanner.nextLine();

        double initialDeposit = 0;
        boolean validDeposit = false;
        while (!validDeposit) {
            System.out.print("Enter initial deposit (minimum 1000 rupees): ");
            initialDeposit = scanner.nextDouble();

            try {
                BankAccount account = new BankAccount(name, initialDeposit);
                validDeposit = true; 
                System.out.println("Account created successfully for " + account.getAccountHolderName());
                startBankOperations(account, scanner); 
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }

        scanner.close();
    }

    private static void startBankOperations(BankAccount account, Scanner scanner) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        account.deposit(depositAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using our bank. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
