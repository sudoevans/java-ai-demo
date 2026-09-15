package demo.domain;

import static java.util.Objects.requireNonNull;

public final class Formatter {

    public static String multiLine(final Quote quote) {
        requireNonNull(quote);

        return """
                "%s"
                by %s"""
                .formatted(quote.quote(), quote.author());
    }

    private Formatter() {}
}
