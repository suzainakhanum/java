public class program2 {
    static class Printer {
        public synchronized void printTable(int number) {
            String threadName = Thread.currentThread().getName();
            System.out.println("--- " + threadName + " STARTING table for " + number + " ---");
            try {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(50);
                    System.out.println(threadName + ": " + number + " x " + i + " = " + (number * i));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("--- " + threadName + " FINISHED table for " + number + " ---");
        }
    }
    static class TableTask implements Runnable {
        private Printer printer;
        private int number;

        public TableTask(Printer printer, int number) {
            this.printer = printer;
            this.number = number;
        }
        @Override
        public void run() {
            printer.printTable(this.number);
        }
    }
    public static void main(String[] args) {
        Printer sharedPrinter = new Printer();
        int tableNumber = 5;
        System.out.println("Starting two threads to print the multiplication table of " + tableNumber + " sequentially.");
        System.out.println("----------------------------------------");
        TableTask task1 = new TableTask(sharedPrinter, tableNumber);
        Thread thread1 = new Thread(task1, "Printer_Thread_A");
        TableTask task2 = new TableTask(sharedPrinter, tableNumber);
        Thread thread2 = new Thread(task2, "Printer_Thread_B");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }
        System.out.println("----------------------------------------");
        System.out.println("Program finished. Output should show one table complete before the next begins.");
    }
}
