public class PasswordChecker {

    public static String strength(String pw) {

        int count = 0;

        if (pw.length() >= 8) {
            count++;
        }

        if (pw.matches(".*[A-Z].*")) {
            count++;
        }

        if (pw.matches(".*[0-9].*")) {
            count++;
        }

        if (pw.matches(".*[^a-zA-Z0-9].*")) {
            count++;
        }

        if (count <= 1) {
            return "Weak";
        } else if (count <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void checkRules(String pw) {

        System.out.println("Password: " + pw);

        if (pw.length() >= 8) {
            System.out.println("Length: Passed");
        } else {
            System.out.println("Length: Failed");
        }

        if (pw.matches(".*[A-Z].*")) {
            System.out.println("Uppercase: Passed");
        } else {
            System.out.println("Uppercase: Failed");
        }

        if (pw.matches(".*[0-9].*")) {
            System.out.println("Digit: Passed");
        } else {
            System.out.println("Digit: Failed");
        }

        if (pw.matches(".*[^a-zA-Z0-9].*")) {
            System.out.println("Special character: Passed");
        } else {
            System.out.println("Special character: Failed");
        }

        System.out.println("Strength: " + strength(pw));
        System.out.println();
    }
}