package demo.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

import static java.util.Objects.requireNonNull;

public final class Database {

    public static DataSource init() {
        return init(databaseProperties());
    }

    public static DataSource init(final Properties properties) {
        requireNonNull(properties);

        return createDataSource(properties);
    }

    private static DataSource createDataSource(final Properties properties) {
        requireNonNull(properties);

        final HikariConfig config = new HikariConfig(properties);
        config.setAutoCommit(false);

        return new HikariDataSource(config);
    }

    private static Properties databaseProperties() {
        final Properties properties = new Properties();
        properties.setProperty("jdbcUrl", "jdbc:h2:mem:quotes;MODE=MYSQL");
        properties.setProperty("username", "quotes");
        properties.setProperty("password", "release door defend");
        return properties;
    }

    private Database() {}
}
