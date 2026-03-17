public class BankSystem {
    public static void main(String[] args) {
        try {
            withdraw(1000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    static void withdraw(int amount) throws InsufficientBalanceException {
        int balance = 500;
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough money!");
        } else {
            System.out.println("Withdrawal successful!");
        }
    }
}

// Custom Exception class
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Balance Error: " + super.getMessage();
    }
}

/*
Output : 

ERROR!
Caught: Balance Error: Not enough money!
*/
