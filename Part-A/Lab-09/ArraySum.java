class Sum {
    int total = 0;

    void add(int value) {
        total += value;
    }
}

public class ArraySum {
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[100000];

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = 1;

        Sum sum = new Sum();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25000; i++)
                sum.add(numbers[i]);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 25000; i < 50000; i++)
                sum.add(numbers[i]);
        });

        Thread t3 = new Thread(() -> {
            for (int i = 50000; i < 75000; i++)
                sum.add(numbers[i]);
        });

        Thread t4 = new Thread(() -> {
            for (int i = 75000; i < 100000; i++)
                sum.add(numbers[i]);
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Total: " + sum.total);
        System.out.println("Expected: 100000");
    }
}