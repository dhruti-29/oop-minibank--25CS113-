import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {

    @NotBlank
    @MaxLength(20)
    String name;

    @NotBlank
    @MaxLength(30)
    String email;

    SignupForm(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class FormValidator {

    public static ArrayList<String> check(Object obj) {

        ArrayList<String> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {

            try {
                field.setAccessible(true);
                String value = (String) field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.trim().isEmpty()) {
                        errors.add(field.getName() + " is blank");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {
                    int max = field.getAnnotation(MaxLength.class).value();

                    if (value != null && value.length() > max) {
                        errors.add(field.getName() + " is too long");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error");
            }
        }

        return errors;
    }

    public static void main(String[] args) {

        SignupForm form = new SignupForm("", "verylongemailaddress@gmail.com");

        ArrayList<String> errors = check(form);

        for (String error : errors) {
            System.out.println(error);
        }
    }
}