package hexlet.code;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ReadFile {

    public static Path getPath(String path) throws Exception {

        return  (path.startsWith("/") ? Paths.get(path)
                : Paths.get(path).toAbsolutePath().normalize());
    }

    public static String read(Path path) throws Exception {
//        String content = Files.readString(path);
        return Files.readString(path).trim();
    }

    public static Map<String, Object> parser(String path) throws Exception {

        String json = ReadFile.read(getPath(path));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,
                new TypeReference<Map<String, Object>>() { });

    }

//-------------------------------------------
//
//    static void writeFixture(Path filePath, String text) throws Exception {
////        var path = ReadFile.getPath(filePath);
//        Files.writeString(filePath, text);
//    }
//
////    private static void writeFixture(String fileName, String text) throws Exception {
////        var path = getFixturePath(fileName);
////        Files.writeString(path, text);
////    }
//
//
//
////    writeFixture("listS_4.yaml", format(coll, "yaml"));
//
////    writeFixture("listS_4.yaml", format(coll, "yaml"));

}
