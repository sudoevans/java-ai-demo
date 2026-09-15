package demo.domain;

import static demo.common.StringUtils.requireNonBlank;

public record Quote(String author, String quote) {

    public Quote {
        requireNonBlank(author);
        requireNonBlank(quote);
    }

    @Override
    public String toString() {
        return quote + " by " + author;
    }
}
