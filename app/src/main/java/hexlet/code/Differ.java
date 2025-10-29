package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
//import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.type.TypeReference;


public class Differ {
    public static String generate() {

        return "generate";
    }

    public static Path getPath(String path) throws Exception {
        return (path.startsWith("/") ? Paths.get(path)
                : Paths.get(path).toAbsolutePath().normalize());
    }

    public static String readFile(String path) throws Exception {
        Path pathFile = getPath(path);
        return Files.readString(pathFile).trim();
    }

    public static Map<String, Object> parser(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        var result = mapper.readValue(readFile(path), Map.class);

        return result;
    }
}
