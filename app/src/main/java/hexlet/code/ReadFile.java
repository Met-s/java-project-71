package hexlet.code;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class ReadFile {

    public static Path getPath(String path) throws Exception {

        return  (path.startsWith("/") ? Paths.get(path)
                : Paths.get(path).toAbsolutePath().normalize());
    }

    public static String read(Path path) throws Exception {
//        String content = Files.readString(path);
        return Files.readString(path).trim();
    }

    public static TreeMap<String, Object> parser(String path) throws Exception {

        String json = ReadFile.read(getPath(path));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,
                new TypeReference<>() { });

    }

    public static TreeMap<String, Object> parserNew(String data,
                                                  String fileType) throws IOException {
        ObjectMapper objectmapper = chooseFormat(fileType);
        return objectmapper.readValue(data, new TypeReference<>() { });
    }

    private static ObjectMapper chooseFormat(String fileType) {
        return "json".equals(fileType) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }



}
