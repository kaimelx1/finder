package desq.top.finder.service;

import desq.top.finder.repository.FileRepository;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FindServiceImpl implements FindService {

    private final FileRepository repository;

    public FindServiceImpl(FileRepository repository) {
        this.repository = repository;
    }

    public String[][] run() {

        List<String> forCode = forCode(repository.getFileNames());

        System.out.println("Список файлов/директорий на кодирование:");
        forCode.forEach(System.out::println);

        List<String> forCopy = forCopy(repository.getFileNames(), forCode);

        System.out.println("Список файлов/директорий на копирование:");
        forCopy.forEach(System.out::println);

        return new String[][]{forCode.toArray(new String[0]), forCopy.toArray(new String[0])};
    }

    /**
     * Файлы с расширениями не подлежащими кодированию (все кроме .tif .mov .avi) подлежат
     * копированию.
     *
     * Если папка подлежит кодированию, то все файлы и папки что в ней содержатся будут кодированы
     * и в отдельном копировании не нуждаются.
     *
     * @param list
     * @param forCode
     * @return
     */
    private List<String> forCopy(List<String> list, List<String> forCode) {
        return list.stream()
                .filter(str -> {
                    String ext = FilenameUtils.getExtension(str);
                    return !CodeExtension.has(ext) && !ext.isEmpty();
                }).filter(str -> forCode.stream().noneMatch(str::contains))
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Файлы в директориях могут иметь любое расширения. Кодированию подлежат только файлы с
     * расширениями .tif .mov .avi. При этом если в папке присутствует файл с расширением .tif -
     * кодированию подлежит вся родительская папка.
     *
     * @param list
     * @return
     */
    private List<String> forCode(List<String> list) {
        return list.stream()
                .filter(str -> CodeExtension.has(FilenameUtils.getExtension(str)))
                .map(str -> FilenameUtils.getExtension(str).equals(CodeExtension.TIF.getTitle()) ? getSubstring(str) : str)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Get file's directory
     *
     * @param str
     * @return
     */
    private String getSubstring(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }
}
