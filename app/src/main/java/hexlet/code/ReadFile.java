package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {

    public static Path getPath(String path, String fileName) throws Exception {

        Path dir = Paths.get(path);
        Path file = dir.resolve(fileName);

        return file;
    }

    public static Path getPath(String fileName) throws Exception {

        Path dir = Paths.get("src/test/resources");
        Path file = dir.resolve(fileName);

        return file;
    }
}
