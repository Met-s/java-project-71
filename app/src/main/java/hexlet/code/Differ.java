package hexlet.code;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Differ {
    public static String generate() {

        return "generate";
    }

    public static Path getPath(String path) throws Exception {

        try {
            return (path.startsWith("/") ? Paths.get(path)
                    : Paths.get(path).toAbsolutePath().normalize());

        } catch (Exception e) {
            throw new FileNotFoundException(path + "There is no such file or the path is incorrect.");
        }
    }

    public static String readFile(String path) throws Exception {

        Path pathFile = getPath(path);
        return Files.readString(pathFile).trim();
    }

    public static Map parser(String path) throws Exception {
        var mapper = new ObjectMapper();

        return mapper.readValue(readFile(path), Map.class);
    }
}
