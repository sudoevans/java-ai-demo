package demo.domain;

public record Quote(String author, String quote) {
    private void print() {
        System.out.printf("%s by %s%n", quote, author);
    }
}
