public class program5 {
    static class Counter {
        private int count = 0;
        public synchronized void increment() {
            count++;
        }
        public int getCount() {
            return count;
        }
    }
    static class CounterTask implements Runnable {
        private Counter counter;
        private final int increments;
        public CounterTask(Counter counter, int increments) {
            this.counter = counter;
            this.increments = increments;
        }
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " starting " + increments + " increments...");
            for (int i = 0; i < increments; i++) {
                counter.increment();
            }
            System.out.println(threadName + " finished.");
        }
    }
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();
        int incrementsPerThread = 1000;
        int totalExpectedCount = incrementsPerThread * 2;
        System.out.println("Starting two threads. Each will increment the counter " + incrementsPerThread + " times.");
        System.out.println("Total Expected Count: " + totalExpectedCount);
        System.out.println("----------------------------------------");
        CounterTask task1 = new CounterTask(sharedCounter, incrementsPerThread);
        Thread thread1 = new Thread(task1, "Incrementer_Thread_A");
        CounterTask task2 = new CounterTask(sharedCounter, incrementsPerThread);
        Thread thread2 = new Thread(task2, "Incrementer_Thread_B");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }
        System.out.println("\n----------------------------------------");
        System.out.println("Final System Status:");
        System.out.println("Final Counter Value: " + sharedCounter.getCount());
        if (sharedCounter.getCount() == totalExpectedCount) {
            System.out.println("SUCCESS: Synchronization worked! Final count matches expected total.");
        } else {
            System.out.println("FAILURE: Synchronization failed. Count is incorrect.");
        }
    }
}
