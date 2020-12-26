package desq.top.finder.repository;

import java.util.ArrayList;
import java.util.List;

public class ImMemoryFileRepositoryImpl implements FileRepository {

    private final List<String> repository = new ArrayList<>();

    @Override
    public List<String> getFileNames() {
        return repository;
    }

    @Override
    public void add(String path) {
        repository.add(path);
    }

    @Override
    public void clear() {
        repository.clear();
    }
}
