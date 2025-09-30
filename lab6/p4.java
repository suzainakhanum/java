public class program3 {
    static class MessageSender {
        public synchronized void sendMessage(String msg) {
            String threadName = Thread.currentThread().getName();
            System.out.println("\n--- " + threadName + " STARTING to send message ---");
            System.out.print(threadName + " is sending: ");
            try {
                String[] words = msg.split(" ");
                for (String word : words) {
                    System.out.print(word + " ");
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("\n--- " + threadName + " FINISHED sending message ---");
        }
    }
    static class MessageTask implements Runnable {
        private MessageSender sender;
        private String message;

        public MessageTask(MessageSender sender, String message) {
            this.sender = sender;
            this.message = message;
        }
        @Override
        public void run() {
            sender.sendMessage(this.message);
        }
    }
    public static void main(String[] args) {
        MessageSender sharedSender = new MessageSender();
        String messageA = "Hello World! This is message A from the first thread.";
        String messageB = "Synchronization ensures message integrity and clarity for all users.";
        System.out.println("Starting two threads to send messages simultaneously.");
        System.out.println("----------------------------------------");
        MessageTask task1 = new MessageTask(sharedSender, messageA);
        Thread thread1 = new Thread(task1, "Sender_Thread_1");
        MessageTask task2 = new MessageTask(sharedSender, messageB);
        Thread thread2 = new Thread(task2, "Sender_Thread_2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }
        System.out.println("\n----------------------------------------");
        System.out.println("Program finished. Verify that the two full messages are printed sequentially.");
    }
}
