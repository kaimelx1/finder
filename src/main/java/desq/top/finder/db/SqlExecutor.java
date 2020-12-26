package desq.top.finder.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlExecutor<T> {

    T execute(PreparedStatement st) throws SQLException;
}