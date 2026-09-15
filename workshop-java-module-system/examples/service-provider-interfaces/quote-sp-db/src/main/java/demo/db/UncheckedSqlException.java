package demo.db;

import java.io.Serial;
import java.sql.SQLException;

public class UncheckedSqlException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UncheckedSqlException(final SQLException e) {
        super(e);
    }
}
