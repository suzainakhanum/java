class SharedData {
    int num;
    boolean valueSet = false;

    synchronized void produce(int n) {
        if (valueSet) {
            try {
                wait();  // Wait until consumer consumes
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        num = n;
        System.out.println("Produced: " + num);
        valueSet = true;
        notify();  // Wake up consumer
    }

    synchronized void consume() {
        if (!valueSet) {
            try {
                wait();  // Wait until producer produces
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Consumed: " + num);
        valueSet = false;
        notify();  // Wake up producer
    }
}

class Producer extends Thread {
    SharedData data;

    Producer(SharedData d) {
        data = d;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            data.produce(i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}

class Consumer extends Thread {
    SharedData data;

    Consumer(SharedData d) {
        data = d;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            data.consume();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedData obj = new SharedData();
        Producer p = new Producer(obj);
        Consumer c = new Consumer(obj);

        p.start();
        c.start();
    }
}
