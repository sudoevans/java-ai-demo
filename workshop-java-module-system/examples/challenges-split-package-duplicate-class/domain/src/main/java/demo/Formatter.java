package demo;

import static java.util.Objects.requireNonNull;

public final class Formatter {

    public static String multiLine(final Quote quote) {
        requireNonNull(quote);

        return """
                "%s"
                by %s
                (formatted by the domain formatter)"""
                .formatted(quote.quote(), quote.author());
    }

    private Formatter() {}
}
