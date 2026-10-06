import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class Tests {

    @Run
    public void testOne() {
        System.out.println("Test one");
    }

    @Run
    public void testTwo() {
        System.out.println("Test two");
    }

    public void normalMethod() {
        System.out.println("Normal method");
    }
}

public class MiniTestRunner {

    public static void main(String[] args) throws Exception {

        Tests test = new Tests();

        int count = 0;

        for (Method method : Tests.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Run.class)) {
                method.invoke(test);
                count++;
            }
        }

        System.out.println("Tests ran: " + count);
    }
}