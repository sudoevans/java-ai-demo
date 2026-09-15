package demo.common;

import java.util.Locale;

public final class StringUtils {

    public static String toUpperCase(final String value) {
        return value == null
                ? null
                : value.toUpperCase(Locale.ROOT);
    }

    private StringUtils() {}
}
