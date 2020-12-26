package desq.top.finder.repository;

import java.util.List;

public interface FileRepository {

    List<String> getFileNames();

    void add(String path);

    void clear();
}
