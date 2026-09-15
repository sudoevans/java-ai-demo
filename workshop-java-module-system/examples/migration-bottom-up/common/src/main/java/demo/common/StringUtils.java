package demo.common;

public final class StringUtils {

    public static String requireNonBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Provided a blank string");
        }
        return value;
    }

    private StringUtils() {}
}
