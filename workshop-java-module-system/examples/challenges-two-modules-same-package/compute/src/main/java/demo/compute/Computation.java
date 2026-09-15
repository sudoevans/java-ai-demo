package demo.compute;

import demo.util.Verifier;

public class Computation {
    private final float result;
    private final int operand1;
    private final int operand2;
    private final String operator;

    public Computation(int operand1, String operator, int operand2) {
        Verifier.verify(operator);

        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;

        result = calculate();
    }

    private float calculate() {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> (1.0f * operand1) / operand2;
            default -> throw new UnsupportedOperationException("Unknown operation: " + operator);
        };
    }

    @Override
    public String toString() {
        return "%d %s %d = %f".formatted(operand1, operator, operand2, result);
    }
}
