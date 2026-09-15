import demo.db.DbQuoteService;
import demo.spi.QuoteService;

module demo.sp.db {
    requires demo.spi;
    provides QuoteService with DbQuoteService;

    requires java.sql;
    requires org.slf4j;
    requires com.zaxxer.hikari;
    requires flyway.core;
    opens db.migration;
}
