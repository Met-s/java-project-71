package hexlet.code;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formats.StylishFormat;


public class Differ {
    public static String generate(String file1, String file2) throws Exception {

        Path file1Path = Differ.getPath(file1);
        Path file2Path = Differ.getPath(file2);

        String file1Read = Differ.readFile(file1Path);
        String file2Read = Differ.readFile(file2Path);

        Map<String, Object> file1Parser = Differ.parser(file1Read);
        Map<String, Object> file2Parser = Differ.parser(file2Read);

        var mapCompare = Compare.compareFiles(file1Parser, file2Parser);

        return StylishFormat.buildList(mapCompare);
    }

    public static Path getPath(String path) throws Exception {

        try {
            return (path.startsWith("/") ? Paths.get(path)
                    : Paths.get(path).toAbsolutePath().normalize());

        } catch (Exception e) {
            throw new FileNotFoundException(path + "There is no such file or the path is incorrect.");
        }
    }

    public static String readFile(Path path) throws Exception {

        return Files.readString(path).trim();
    }

    public static Map<String, Object> parser(String file) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<>() { });
    }
}
