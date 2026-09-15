package demo.domain;

final class StringUtils {

    static String failIfBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Provided a blank string");
        }

        return value;
    }

    private StringUtils() {}
}
