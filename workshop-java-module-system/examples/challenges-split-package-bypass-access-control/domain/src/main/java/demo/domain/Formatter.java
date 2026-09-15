package demo.domain;

import static java.util.Objects.requireNonNull;

final class Formatter {

    static String multiLine(final Quote quote) {
        requireNonNull(quote);

        return '"' + quote.quote() + "\"\nby " + quote.author();
    }

    private Formatter() {}
}
