package demo.spring;

import demo.spi.Quote;
import demo.spi.QuoteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Demo implements CommandLineRunner {

    private final List<QuoteService> quoteServices;

    public Demo(final @Qualifier("quoteServices") List<QuoteService> quoteServices) {
        this.quoteServices = quoteServices;
    }

    @Override
    public void run(final String... args) {
        for (final QuoteService quoteService : quoteServices) {
            final Optional<Quote> quote = quoteService.random();

            final String formattedQuote = quote.map(Quote::toString).orElse("No Quote!!");
            final String providerName = quoteService.getClass().getCanonicalName();
            System.out.println(formattedQuote + " (Service: " + providerName + ')');
        }
    }
}
