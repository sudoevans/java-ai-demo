package demo.util;

public class Verifier {
    private Verifier() {}

    ;

    public static void verify(String operator) {
        if (operator == null || operator.length() != 1) {
            throw new IllegalArgumentException("operator must be 1 character long.");
        }
        if (!"+-*/".contains(operator)) {
            throw new IllegalArgumentException("operator must be one of +, -, *, /.");
        }
    }
}