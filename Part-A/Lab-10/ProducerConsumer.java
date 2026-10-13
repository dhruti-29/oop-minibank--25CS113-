import java.util.LinkedList;

class Buffer {
    LinkedList<Integer> list = new LinkedList<>();

    synchronized void produce(int value) throws Exception {
        list.add(value);
        System.out.println("Produced: " + value);
        notify();
    }

    synchronized void consume() throws Exception {
        while (list.isEmpty())
            wait();

        int value = list.removeFirst();
        System.out.println("Consumed: " + value);
        notify();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws Exception {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                    Thread.sleep(200);
                }
            } catch (Exception e) {
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                    Thread.sleep(300);
                }
            } catch (Exception e) {
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Done");
    }
}