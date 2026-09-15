package demo.db;

import demo.domain.Quote;

import java.util.List;

public final class QuoteRepository {

    public List<Quote> quotes() {
        return List.of(
                new Quote("Nelson Mandela", "The greatest glory in living lies not in never falling, but in rising every time we fall."));
    }

    private static final QuoteRepository INSTANCE = new QuoteRepository();

    public static QuoteRepository instance() {
        return INSTANCE;
    }

    private QuoteRepository() {}
}
