package demo.db;

import demo.spi.Quote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DbQuoteServiceTest {

    private final QuoteRepository repository = mock(QuoteRepository.class);

    private final DbQuoteService service = new DbQuoteService(repository);

    @BeforeEach
    void setUp() {
        reset(repository);
    }

    @Test
    void returnsOptionalEmptyWhenNoQuotesAreReturnedByRepository() {
        /* Given */
        when(repository.list()).thenReturn(List.of());

        /* When */
        final Optional<Quote> random = service.random();

        /* Then */
        assertThat(random).isEmpty();
    }

    @Test
    void returnsTheSingleQuoteReturnedByRepository() {
        /* Given */
        final Quote quote = new Quote("Author name", "The quote!!");
        when(repository.list()).thenReturn(List.of(quote));

        /* When */
        final Optional<Quote> random = service.random();

        /* Then */
        assertThat(random).isEqualTo(Optional.of(quote));
    }
}
