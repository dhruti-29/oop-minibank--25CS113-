class PasswordChecker {

    static int checkLength(String pw) {
        if (pw.length() >= 8) {
            return 1;
        }
        return 0;
    }

    static int checkUppercase(String pw) {
        if (pw.matches(".*[A-Z].*")) {
            return 1;
        }
        return 0;
    }

    static int checkDigit(String pw) {
        if (pw.matches(".*[0-9].*")) {
            return 1;
        }
        return 0;
    }

    static int checkSpecial(String pw) {
        if (pw.matches(".*[^a-zA-Z0-9].*")) {
            return 1;
        }
        return 0;
    }

    static String strength(String pw) {

        int count = 0;

        count = count + checkLength(pw);
        count = count + checkUppercase(pw);
        count = count + checkDigit(pw);
        count = count + checkSpecial(pw);

        if (count <= 1) {
            return "Weak";
        } else if (count <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}


public class prac_1 {

    public static void main(String[] args) {

        String[] passwords = {
            "abc",
            "abcdefghi",
            "Abcdefgh",
            "Abcd1234",
            "Abcd1234!"
        };

        for (String pw : passwords) {

            System.out.println("Password: " + pw);

            if (PasswordChecker.checkLength(pw) == 1) {
                System.out.println("Length: Passed");
            } else {
                System.out.println("Length: Failed");
            }

            if (PasswordChecker.checkUppercase(pw) == 1) {
                System.out.println("Uppercase: Passed");
            } else {
                System.out.println("Uppercase: Failed");
            }

            if (PasswordChecker.checkDigit(pw) == 1) {
                System.out.println("Digit: Passed");
            } else {
                System.out.println("Digit: Failed");
            }

            if (PasswordChecker.checkSpecial(pw) == 1) {
                System.out.println("Special Character: Passed");
            } else {
                System.out.println("Special Character: Failed");
            }

            System.out.println("Strength: " + PasswordChecker.strength(pw));
            System.out.println();
        }
    }
}