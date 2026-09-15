package demo.app;

import demo.db.QuoteRepository;
import demo.domain.Formatter;

public final class Main {

    public static void main(final String[] args) {
        final QuoteRepository repository = QuoteRepository.instance();
        repository.quotes()
                .forEach(quote -> {
                    System.out.println("1. Formatter.multiLine(Quote)");
                    System.out.println(Formatter.multiLine(quote));
                    System.out.println();

                    System.out.println("2. Formatter.singleLine(Quote)");
                    System.out.println(Formatter.singleLine(quote));
                });
    }
}
