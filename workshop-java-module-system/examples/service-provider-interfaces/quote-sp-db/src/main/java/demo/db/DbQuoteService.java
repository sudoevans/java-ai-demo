package demo.db;

import demo.spi.Quote;
import demo.spi.QuoteService;

import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

import static java.util.Objects.requireNonNull;

public final class DbQuoteService implements QuoteService {

    private final QuoteRepository repository;

    public DbQuoteService() {
        this(QuoteRepository.instance());
    }

    public DbQuoteService(final QuoteRepository repository) {
        requireNonNull(repository);
        this.repository = repository;
    }

    @Override
    public Optional<Quote> random() {
        final List<Quote> quotes = repository.list();

        if (quotes.isEmpty()) {
            return Optional.empty();
        }

        final RandomGenerator random = RandomGenerator.getDefault();
        final int size = quotes.size();
        final int index = random.nextInt(size);

        return Optional.of(quotes.get(index));
    }
}
