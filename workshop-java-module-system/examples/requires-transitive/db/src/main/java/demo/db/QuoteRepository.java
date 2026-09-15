package demo.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.domain.Quote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class QuoteRepository {

    private static final QuoteRepository INSTANCE = new QuoteRepository();

    private QuoteRepository() {}

    public static QuoteRepository instance() {
        return INSTANCE;
    }

    public List<Quote> list() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/quotes.json"), StandardCharsets.UTF_8))) {
            final TypeReference<List<Quote>> typeReference = new TypeReference<>() {};
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(reader, typeReference);
        } catch (final IOException e) {
            throw new UncheckedIOException("Failed to read quotes", e);
        }
    }
}
