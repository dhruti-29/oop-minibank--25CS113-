class Cinema {
    int seatsLeft = 5;

    boolean book() {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }

            seatsLeft--;
            return true;
        }
        return false;
    }
}

public class SeatBooking {
    public static void main(String[] args) throws Exception {
        Cinema cinema = new Cinema();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                if (cinema.book())
                    System.out.println("Seat booked");
                else
                    System.out.println("No seat");
            });
            threads[i].start();
        }

        for (Thread t : threads)
            t.join();

        System.out.println("Seats left: " + cinema.seatsLeft);
    }
}