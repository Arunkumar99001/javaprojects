**Bank Account Management System**

This is a simple Java program to manage bank accounts. It allows users to:

- Create an account with an initial deposit (minimum 1000 rupees)
- Deposit money into the account
- Withdraw money from the account, with warnings if the balance falls below the minimum required
- Check the current account balance
- Pay a monthly charge if the balance falls below the minimum required

**Features**

- Account creation with a minimum deposit of 1000 rupees
- Deposit and withdrawal options
- Check account balance
- Warning before withdrawal if balance falls below the minimum required

**How to Use**

1. **Clone the repository:**
   git clone <repository-url>
   cd <repository-folder>

2. **Compile and run:**

   javac BankAccount.java BankApp.java
   java BankApp

3. Create an account: Enter your name and an initial deposit (at least 1000 rupees).
4. Choose an option: You can deposit money, withdraw money, check your balance, or exit the program.
<br>
**Output:**<br>
Welcome to the Bank! <br>
Enter your name to open an account: king <br>
Enter initial deposit (minimum 1000 rupees): 2000 <br>
Account created successfully for king <br>

Choose an option:
1. Deposit Money
2. Withdraw Money
3. Check Balance
4. Exit
Enter your choice: 1
Enter amount to deposit: 500
500 rupees deposited successfully.

Choose an option:
1. Deposit Money
2. Withdraw Money
3. Check Balance
4. Exit
Enter your choice: 3
Current balance: 2500 rupees.

Choose an option:
1. Deposit Money
2. Withdraw Money
3. Check Balance
4. Exit
Enter your choice: 4
Thank you for using our bank. Goodbye!
