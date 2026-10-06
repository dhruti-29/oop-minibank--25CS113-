import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    public String toString() {
        return name + " " + age;
    }
}

public class ColumnMapper {

    public static void main(String[] args) throws Exception {

        String[] headers = {"name", "age"};
        String[] data = {"Riya", "20"};

        Student student = new Student();

        for (Field field : Student.class.getDeclaredFields()) {

            Column column = field.getAnnotation(Column.class);

            for (int i = 0; i < headers.length; i++) {

                if (column.name().equals(headers[i])) {

                    field.setAccessible(true);

                    if (field.getType() == String.class) {
                        field.set(student, data[i]);
                    } else {
                        field.set(student, Integer.parseInt(data[i]));
                    }
                }
            }
        }

        System.out.println(student);
    }
}