package demo.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public final class Query {

    public static <T> List<T> queryList(
            final DataSource dataSource,
            final String sql,
            final SqlFunction<ResultSet, T> mapper) {
        requireNonNull(dataSource);
        requireNonNull(sql);
        requireNonNull(mapper);

        return applyConnection(dataSource, connection -> {
            try (final PreparedStatement statement = connection.prepareStatement(sql)) {
                try (final ResultSet resultSet = statement.executeQuery()) {
                    final List<T> list = new ArrayList<>();

                    while (resultSet.next()) {
                        final T item = mapper.apply(resultSet);
                        list.add(item);
                    }

                    return List.copyOf(list);
                }
            } catch (final SQLException e) {
                throw new UncheckedSqlException(e);
            }
        });
    }

    public static <T> T applyConnection(final DataSource dataSource, final SqlFunction<Connection, T> function) {
        requireNonNull(dataSource);
        requireNonNull(function);

        try (final Connection connection = dataSource.getConnection()) {
            return applyTransaction(connection, function);
        } catch (final SQLException e) {
            throw new UncheckedSqlException(e);
        }
    }

    private static <T> T applyTransaction(final Connection connection, final SqlFunction<Connection, T> function) {
        try {
            connection.setAutoCommit(false);
            final T result = function.apply(connection);
            connection.commit();
            return result;
        } catch (final SQLException e) {
            rollback(connection);
            throw new UncheckedSqlException(e);
        } catch (final RuntimeException e) {
            rollback(connection);
            throw e;
        }
    }

    private static void rollback(final Connection connection) {
        try {
            connection.rollback();
        } catch (final SQLException e) {
            throw new UncheckedSqlException(e);
        }
    }

    private Query() {}
}
