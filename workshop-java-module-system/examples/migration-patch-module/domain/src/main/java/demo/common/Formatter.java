package demo.common;

import demo.domain.Quote;

import static java.util.Objects.requireNonNull;

public final class Formatter {

    public static String multiline(final Quote quote) {
        requireNonNull(quote);

        return """
                "%s"
                by %s"""
                .formatted(quote.quote(), quote.author());
    }

    public static String singleLine(final Quote quote) {
        requireNonNull(quote);

        return "%s by %s"
                .formatted(quote.quote(), quote.author());
    }

    private Formatter() {}
}
