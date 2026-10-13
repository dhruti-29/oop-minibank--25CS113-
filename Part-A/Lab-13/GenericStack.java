class Stack<T> {
    T[] items;
    int top = -1;

    Stack(int size) {
        items = (T[]) new Object[size];
    }

    void push(T value) {
        items[++top] = value;
    }

    T pop() {
        if (top == -1)
            return null;

        return items[top--];
    }
}

public class GenericStack {
    public static void main(String[] args) {

        Stack<Integer> numbers = new Stack<>(5);
        numbers.push(10);
        numbers.push(20);

        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());

        Stack<String> names = new Stack<>(5);
        names.push("Dhruti");
        names.push("Riya");

        System.out.println(names.pop());
        System.out.println(names.pop());
    }
}