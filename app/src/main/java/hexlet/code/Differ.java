package hexlet.code;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.Map;


public class Differ {
    public static String generate(String file1,
                                  String file2, String format) throws Exception {

        Path file1Path = Differ.getPath(file1);
        Path file2Path = Differ.getPath(file2);

        String file1Read = Differ.readFile(file1Path);
        String file2Read = Differ.readFile(file2Path);

        Map<String, Object> file1Parser = Parser.parser(file1Read, file1);
        Map<String, Object> file2Parser = Parser.parser(file2Read, file2);

        var mapCompare = Compare.compareFiles(file1Parser, file2Parser);

        return Formatter.format(mapCompare, format);
    }

    public static String generate(String file1, String file2) throws Exception {
        return Differ.generate(file1, file2, "stylish");
    }

    public static Path getPath(String path) {
        Path path1 = Paths.get(path);

        return (path1.isAbsolute()) ? path1.normalize()
                    : path1.toAbsolutePath().normalize();
    }

    public static String readFile(Path path) throws Exception {

        try {
            return Files.readString(path).trim();
        } catch (Exception e) {
            throw new FileNotFoundException(path
                    + " - There is no such file or the path is incorrect.");
        }
    }
}
