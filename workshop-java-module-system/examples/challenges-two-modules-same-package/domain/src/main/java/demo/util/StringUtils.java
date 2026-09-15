package demo.util;

public final class StringUtils {

    public static String failIfBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Provided a blank string");
        }
        return value;
    }

    private StringUtils() {}
}
