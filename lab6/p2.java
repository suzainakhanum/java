public class BankAccount {
    private int balance = 1000;

    // Synchronized withdraw method to make thread-safe
    public synchronized void withdraw(int amount, String person) {
        if (balance >= amount) {
            System.out.println(person + " is trying to withdraw " + amount);
            try {
                // Simulate delay to increase chance of thread interference
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(person + " completed withdrawal of " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println(person + " tried to withdraw " + amount + " but insufficient balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Thread 1
        Thread person1 = new Thread(() -> {
            account.withdraw(700, "Person 1");
        });

        // Thread 2
        Thread person2 = new Thread(() -> {
            account.withdraw(700, "Person 2");
        });

        person1.start();
        person2.start();
    }
}
