package demo.quote;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@SpringBootTest
class QuoteControllerTest {

    @Autowired
    private TestQuoteService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnNotFoundWhenNoQuotesAreFound() throws Exception {
        /* Given */
        service.respondWith(Optional.empty());

        /* When */
        final MvcResult response = makeGetRandomQuoteRequest();

        /* Then */
        assertThat(response.getResponse().getStatus())
                .describedAs("Return HTTP NOT_FOUND when a random quote is not found")
                .isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void returnFoundWithTheRandomQuote() throws Exception {
        /* Given */
        final Quote quote = new Quote(1L, "Albert Einstein", "Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.");
        service.respondWith(Optional.of(quote));

        /* When */
        final MvcResult response = makeGetRandomQuoteRequest();

        /* Then */
        assertThat(response.getResponse().getStatus())
                .describedAs("Return HTTP OK when a random quote is found")
                .isEqualTo(HttpStatus.OK.value());
        assertThat(response.getResponse().getContentAsString())
                .describedAs("Return the random quote as a JSON object")
                .contains("\"id\":1")
                .contains("\"author\":\"Albert Einstein\"")
                .contains("\"quote\":\"Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.\"");
    }

    private MvcResult makeGetRandomQuoteRequest() throws Exception {
        return mockMvc.perform(get("/quote/random"))
                .andReturn();
    }

    @TestConfiguration
    static class TestApplication {

        @Bean
        @Primary
        TestQuoteService testQuoteService() {
            return new TestQuoteService();
        }
    }

    static class TestQuoteService extends QuoteService {

        private Optional<Quote> response = Optional.empty();

        TestQuoteService() {
            super(new UnsupportedQuoteRepository());
        }

        void respondWith(final Optional<Quote> response) {
            this.response = response;
        }

        @Override
        public Optional<Quote> random() {
            return response;
        }
    }

    private static class UnsupportedQuoteRepository implements QuoteRepository {

        @Override
        public <S extends Quote> S save(final S entity) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <S extends Quote> java.util.List<S> saveAll(final Iterable<S> entities) {
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
        public java.util.List<Quote> findAll() {
            throw new UnsupportedOperationException();
        }

        @Override
        public java.util.List<Quote> findAllById(final Iterable<Long> ids) {
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
