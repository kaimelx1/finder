package desq.top.finder;

import desq.top.finder.repository.FileRepository;
import desq.top.finder.repository.ImMemoryFileRepositoryImpl;
import desq.top.finder.service.FindService;
import desq.top.finder.service.FindServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    private final FileRepository repository = new ImMemoryFileRepositoryImpl();

    @Test
    public void example1() {
        TestData.fill1(repository);
        FindService fs = new FindServiceImpl(repository);
        Assert.assertArrayEquals(TestData.EXMP1_EXPECTED, fs.run());
    }

    @Test
    public void example2() {
        TestData.fill2(repository);
        FindService fs = new FindServiceImpl(repository);
        Assert.assertArrayEquals(TestData.EXMP2_EXPECTED, fs.run());
    }

    @After
    public void clear() {
        repository.clear();
    }
}
