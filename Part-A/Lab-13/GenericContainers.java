class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

class Pair<A, B> {
    A first;
    B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    void show() {
        System.out.println(first + " - " + second);
    }
}

public class GenericContainers {

    static <T> T first(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {

        Box<Integer> b1 = new Box<>();
        b1.set(10);
        System.out.println(b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Java");
        System.out.println(b2.get());

        Pair<String, Integer> p = new Pair<>("Dhruti", 20);
        p.show();

        String[] names = {"Riya", "Jay", "Neha"};
        System.out.println(first(names));
    }
}