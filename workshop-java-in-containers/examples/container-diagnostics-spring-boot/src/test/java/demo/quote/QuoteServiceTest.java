package demo.quote;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class QuoteServiceTest {

    @Test
    void returnOptionalEmptyWhenRepositoryReturnsNoQuotes() {
        /* Given */
        final QuoteService service = new QuoteService(new TestQuoteRepository(List.of()));

        /* When */
        final Optional<Quote> response = service.random();

        /* Then */
        assertThat(response)
                .describedAs("The repository returned no quotes")
                .isEmpty();
    }

    @Test
    void returnTheSingleQuote() {
        /* Given */
        final Quote quote = QUOTE_1;
        final QuoteService service = new QuoteService(new TestQuoteRepository(List.of(quote)));

        /* When */
        final Optional<Quote> response = service.random();

        /* Then */
        assertThat(response)
                .describedAs("The single quote returned by the repository")
                .isEqualTo(Optional.of(quote));
    }

    @Test
    void returnARandomQuote() {
        /* Given */
        final List<Quote> quotes = List.of(QUOTE_1, QUOTE_2);
        final QuoteService service = new QuoteService(new TestQuoteRepository(quotes));

        /* When */
        final Optional<Quote> response = service.random();

        /* Then */
        assertThat(response)
                .describedAs("One of the quotes returned by the repository")
                .isPresent();
        assertThat(response.get())
                .describedAs("One of the quotes returned by the repository")
                .isIn(quotes);
    }

    private static final Quote QUOTE_1 = new Quote(1L, "Albert Einstein", "Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.");

    private static final Quote QUOTE_2 = new Quote(2L, "Eleanor Roosevelt", "The future belongs to those who believe in the beauty of their dreams.");

    private record TestQuoteRepository(List<Quote> quotes) implements QuoteRepository {

        @Override
        public <S extends Quote> S save(final S entity) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <S extends Quote> List<S> saveAll(final Iterable<S> entities) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Optional<Quote> findById(final Long id) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean existsById(final Long id) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Quote> findAll() {
            return quotes;
        }

        @Override
        public List<Quote> findAllById(final Iterable<Long> ids) {
            throw new UnsupportedOperationException();
        }

        @Override
        public long count() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteById(final Long id) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void delete(final Quote entity) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteAllById(final Iterable<? extends Long> ids) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteAll(final Iterable<? extends Quote> entities) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteAll() {
            throw new UnsupportedOperationException();
        }
    }
}
