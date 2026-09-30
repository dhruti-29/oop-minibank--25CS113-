public class Employee {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public double monthlySalary() {
        return 0;
    }

    public static void main(String[] args) {

        Employee[] employees = {
            new FullTime("Rahul", 101, 50000),
            new PartTime("Riya", 102, 20, 300),
            new Intern("Amit", 103, 10000)
        };

        double total = 0;

        for (Employee employee : employees) {

            double salary = employee.monthlySalary();

            System.out.println(employee.name + ": " + salary);

            if (employee instanceof Intern) {
                System.out.println("This is an intern.");
            }

            total = total + salary;
        }

        System.out.println("Total salary: " + total);
    }
}

class FullTime extends Employee {

    private double salary;

    public FullTime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    public double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {

    private int hours;
    private double rate;

    public PartTime(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {

    private double stipend;

    public Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    public double monthlySalary() {
        return stipend;
    }
}