package demo.app;

import demo.domain.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Main {

    public static void main(final String[] args) {
        acceptConnection(connection -> {
            initDatabase(connection);

            final List<Quote> quotes = listQuotes(connection);

            System.out.println("Printing the contents of the quotes table");
            for (final Quote quote : quotes) {
                System.out.println(" - “" + quote.quote() + "” by " + quote.author());
            }
        });
    }

    private static List<Quote> listQuotes(final Connection connection) {
        System.out.println("Listing quotes");
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM quotes");
             ResultSet resultSet = statement.executeQuery()) {

            final List<Quote> quotes = new ArrayList<>();
            while (resultSet.next()) {
                final String author = resultSet.getString("author");
                final String quote = resultSet.getString("quote");
                quotes.add(new Quote(author, quote));
            }

            return quotes;
        } catch (final SQLException e) {
            throw new RuntimeException("Failed to list quotes", e);
        }
    }

    private static void initDatabase(final Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE quotes(author VARCHAR(255) NOT NULL, quote VARCHAR(255) NOT NULL)");
            statement.execute("INSERT INTO quotes VALUES('Albert Einstein', 'Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.')");
        } catch (final SQLException e) {
            throw new RuntimeException("Failed to initialise database", e);
        }
    }

    private static void acceptConnection(final SqlConsumer<Connection> consumer) {
        System.out.println("Connecting to database");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:demo")) {
            consumer.accept(connection);
        } catch (final SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }

    private interface SqlConsumer<T> {
        void accept(T t) throws SQLException;
    }
}
