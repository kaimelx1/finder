package desq.top.finder.repository;

import desq.top.finder.db.SqlHelper;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FileRepositoryImpl implements FileRepository {

    private final SqlHelper sqlHelper;

    public FileRepositoryImpl() {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection("jdbc:mysql://localhost:3306/dev", "dev", "root"));
    }

    @Override
    public List<String> getFileNames() {
        return sqlHelper.execute("SELECT FileName FROM san_content_999_calculated ORDER BY FileName", ps -> {
            ResultSet rs = ps.executeQuery();
            List<String> fileNames = new ArrayList<>(rs.getFetchSize());
            while (rs.next()) {
                fileNames.add(rs.getString("FileName"));
            }
            return fileNames;
        });
    }

    @Override
    public void add(String path) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
