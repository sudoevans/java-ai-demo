package demo.domain;

import static java.util.Objects.requireNonNull;

public final class FormatterBridge {

    public static String multiLine(final Quote quote) {
        requireNonNull(quote);

        return Formatter.multiLine(quote);
    }

    private FormatterBridge() {}
}
