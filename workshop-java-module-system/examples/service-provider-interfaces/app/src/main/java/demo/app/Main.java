package demo.app;

import demo.sl.QuoteServiceLoader;
import demo.spi.Quote;
import demo.spi.QuoteService;

import java.util.Optional;

public final class Main {

    public static void main(final String[] args) {
        final QuoteServiceLoader serviceLocator = QuoteServiceLoader.instance();

        for (final QuoteService quoteService : serviceLocator.services()) {
            final Optional<Quote> quote = quoteService.random();

            final String formattedQuote = quote.map(Quote::toString).orElse("No Quote!!");
            final String providerName = quoteService.getClass().getCanonicalName();
            System.out.println(formattedQuote + " (Service: " + providerName + ')');
        }
    }
}
