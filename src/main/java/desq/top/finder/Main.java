package desq.top.finder;

import desq.top.finder.repository.FileRepositoryImpl;
import desq.top.finder.service.FindServiceImpl;

public class Main {

    public static void main(String[] args) {
        FindServiceImpl service = new FindServiceImpl(new FileRepositoryImpl());
        service.run();
    }
}
