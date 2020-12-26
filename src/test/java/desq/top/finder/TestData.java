package desq.top.finder;

import desq.top.finder.repository.FileRepository;

public class TestData {

    static final String[][] EXMP1_EXPECTED = {{"d1\\f1.mov", "d1\\d2"}, {}};

    static final String[][] EXMP2_EXPECTED = {{"d1\\f1.mov", "d1\\d2"}, {"d1\\f3.txt"}};

    static void fill1(FileRepository repository) {
        repository.add("d1\\");
        repository.add("d1\\f1.mov");
        repository.add("d1\\d2");
        repository.add("d1\\d2\\f2.tif");
        repository.add("d1\\d2\\f-n.tif");
    }

    static void fill2(FileRepository repository) {
        repository.add("d1\\");
        repository.add("d1\\f1.mov");
        repository.add("d1\\f3.txt");
        repository.add("d1\\d2");
        repository.add("d1\\d2\\f2.tif");
        repository.add("d1\\d2\\f-n.tif");
        repository.add("d1\\d2\\d3");
        repository.add("d1\\d2\\d3\\f4.pdf");
    }
}
