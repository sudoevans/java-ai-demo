package demo.domain;

public record Quote(String author, String quote) {

    public Quote {
        StringUtils.failIfBlank(author);
        StringUtils.failIfBlank(quote);
    }

    @Override
    public String toString() {
        return "%s by %s".formatted(quote, author);
    }
}
