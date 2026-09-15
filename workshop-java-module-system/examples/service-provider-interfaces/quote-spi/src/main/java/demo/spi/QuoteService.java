package demo.spi;

import java.util.Optional;

public interface QuoteService {

    Optional<Quote> random();
}
