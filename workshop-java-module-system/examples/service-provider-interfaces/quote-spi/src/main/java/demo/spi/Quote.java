package demo.spi;

import static java.util.Objects.requireNonNull;

public record Quote(String author, String quote) {

    public Quote {
        requireNonNull(author);
        requireNonNull(quote);
    }

    @Override
    public String toString() {
        return quote + " by " + author;
    }
}
