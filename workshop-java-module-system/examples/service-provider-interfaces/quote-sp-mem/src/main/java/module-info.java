import demo.mem.InMemoryQuoteService;
import demo.spi.QuoteService;

module demo.sp.basic {
    requires demo.spi;
    provides QuoteService with InMemoryQuoteService;
}
