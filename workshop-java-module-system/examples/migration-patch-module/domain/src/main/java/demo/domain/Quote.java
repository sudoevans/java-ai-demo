package demo.domain;

import demo.common.Formatter;

public record Quote(String author, String quote) {
    @Override
    public String toString() {
        return Formatter.singleLine(this);
    }
}
