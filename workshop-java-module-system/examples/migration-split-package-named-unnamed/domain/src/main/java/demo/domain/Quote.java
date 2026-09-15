package demo.domain;

public record Quote(String author, String quote) {
    @Override
    public String toString() {
        return "%s by %s".formatted(quote, author);
    }
}
