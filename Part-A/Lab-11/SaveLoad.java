import java.io.*;

class Student implements Serializable {
    String name;
    int age;
    transient String password;

    Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}

public class SaveLoad {
    public static void main(String[] args) throws Exception {

        Student[] students = {
            new Student("Dhruti", 20, "1234"),
            new Student("Riya", 21, "5678")
        };

        ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("students.dat"));

        out.writeObject(students);
        out.close();

        ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("students.dat"));

        Student[] loaded = (Student[]) in.readObject();
        in.close();

        for (Student s : loaded) {
            System.out.println("Name: " + s.name);
            System.out.println("Age: " + s.age);
            System.out.println("Password: " + s.password);
            System.out.println();
        }
    }
}