public class program4 {
    static class TicketManager {
        private int availableTickets = 5;
        public synchronized boolean bookTicket() {
            String threadName = Thread.currentThread().getName();
            if (availableTickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                availableTickets--;
                System.out.println(threadName + " SUCCESSFULLY booked a ticket. Tickets remaining: " + availableTickets);
                return true;
            } else {
                System.out.println(threadName + " FAILED to book a ticket. ALL TICKETS SOLD OUT.");
                return false;
            }
        }
        public int getAvailableTickets() {
            return availableTickets;
        }
    }
    static class BookingTask implements Runnable {
        private TicketManager manager;

        public BookingTask(TicketManager manager) {
            this.manager = manager;
        }

        @Override
        public void run() {
            manager.bookTicket();
        }
    }

    public static void main(String[] args) {
        TicketManager manager = new TicketManager();
        int numUsers = 8;
        Thread[] users = new Thread[numUsers];
        System.out.println("Starting " + numUsers + " users to book tickets (Total tickets: " + manager.getAvailableTickets() + ")");
        System.out.println("----------------------------------------");
        for (int i = 0; i < numUsers; i++) {
            users[i] = new Thread(new BookingTask(manager), "User_" + (i + 1));
            users[i].start();
        }
        try {
            for (Thread user : users) {
                user.join();
            }
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }
        System.out.println("\n----------------------------------------");
        System.out.println("Final System Status:");
        System.out.println("Total users who tried to book: " + numUsers);
        System.out.println("Tickets remaining: " + manager.getAvailableTickets()); // Should always be 0
    }
}
