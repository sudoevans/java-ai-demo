package demo.db;

import demo.spi.Quote;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static demo.db.Query.queryList;
import static java.util.Objects.requireNonNull;

public final class QuoteRepository {

    private static final QuoteRepository INSTANCE = createRepository();

    private final DataSource dataSource;

    private QuoteRepository(final DataSource dataSource) {
        requireNonNull(dataSource);
        this.dataSource = dataSource;
    }

    public static QuoteRepository instance() {
        return INSTANCE;
    }

    public List<Quote> list() {
        final String sql = "SELECT * FROM quote";
        return queryList(dataSource, sql, QuoteRepository::toQuote);
    }

    private static Quote toQuote(final ResultSet resultSet) throws SQLException {
        return new Quote(
                resultSet.getString("author"),
                resultSet.getString("quote"));
    }

    private static QuoteRepository createRepository() {
        return new QuoteRepository(createDataSource());
    }

    private static DataSource createDataSource() {
        final DataSource dataSource = Database.init();
        migrateDatabase(dataSource);

        return dataSource;
    }

    private static void migrateDatabase(final DataSource dataSource) {
        requireNonNull(dataSource);

        Flyway.configure()
                .dataSource(dataSource)
                .load()
                .migrate();
    }
}
