package demo.sl;

import demo.spi.QuoteService;

import java.util.ServiceLoader;

public final class QuoteServiceLoader {

    public Iterable<QuoteService> services() {
        return ServiceLoader.load(QuoteService.class);
    }

    public static QuoteServiceLoader instance() {
        return INSTANCE;
    }

    private QuoteServiceLoader() {}

    private static final QuoteServiceLoader INSTANCE = new QuoteServiceLoader();
}
