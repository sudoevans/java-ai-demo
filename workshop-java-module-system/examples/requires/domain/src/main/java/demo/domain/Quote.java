package demo.domain;

import demo.domain.internal.Formatter;

import static demo.domain.StringUtils.failIfBlank;

public record Quote(String author, String quote) {

    public Quote {
        failIfBlank(author);
        failIfBlank(quote);
    }

    @Override
    public String toString() {
        return Formatter.singleLine(this);
    }
}
