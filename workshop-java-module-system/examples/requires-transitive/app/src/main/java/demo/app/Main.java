package demo.app;

import demo.db.QuoteRepository;

public final class Main {

    public static void main(final String[] args) {
        final QuoteRepository repository = QuoteRepository.instance();

        System.out.println("Quotes");
        repository.list()
                .forEach(quote -> System.out.printf(" - %s%n   by %s%n", quote.quote(), quote.author()));
    }
}
