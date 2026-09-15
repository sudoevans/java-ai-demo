import demo.spi.QuoteService;

module demo.spring {
    requires demo.spi;
    uses QuoteService;

    requires org.slf4j;
    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    opens demo.spring to spring.core, spring.beans, spring.context;
}
