public class Media {

    private String title;

    public Media(String title) {
        this.title = title;
    }

    public double lateFee(int days) {
        return 0;
    }

    public static void main(String[] args) {

        Media[] media = {
            new Book("Java Book"),
            new Movie("Java Movie"),
            new Game("Java Game")
        };

        int days = 3;
        double total = 0;

        for (Media item : media) {

            double fee = item.lateFee(days);

            System.out.println(item.title + ": " + fee);

            total = total + fee;
        }

        System.out.println("Total late fee: " + total);
    }
}

class Book extends Media {

    public Book(String title) {
        super(title);
    }

    @Override
    public double lateFee(int days) {
        return days * 2;
    }
}

class Movie extends Media {

    public Movie(String title) {
        super(title);
    }

    @Override
    public double lateFee(int days) {
        return days * 5;
    }
}

class Game extends Media {

    public Game(String title) {
        super(title);
    }

    @Override
    public double lateFee(int days) {
        return days * 10;
    }
}