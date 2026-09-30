public class Shape {

    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(4, 5)
        };

        double total = 0;
        double largest = 0;

        for (Shape shape : shapes) {

            double area = shape.area();

            System.out.println("Area: " + area);

            total = total + area;

            if (area > largest) {
                largest = area;
            }
        }

        System.out.println("Total area: " + total);
        System.out.println("Largest area: " + largest);
    }

    public double area() {
        return 0;
    }
}

class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}