import demo.spi.QuoteService;

module demo.sl {
    requires transitive demo.spi;
    uses QuoteService;

    exports demo.sl;
}
