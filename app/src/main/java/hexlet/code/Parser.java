package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;


public class Parser {

    public static Map<String, Object> parser(String file, String fileName) throws Exception {

        ObjectMapper mapper = fileExtentsDef(fileName);

        return mapper.readValue(file, new TypeReference<>() { });
    }

    static ObjectMapper fileExtentsDef(String fileName) throws UnsupportedOperationException {

        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

        return switch (extension) {
            case "json" -> new ObjectMapper();
            case "yaml", "yml" -> new YAMLMapper();
            default -> throw new IllegalArgumentException(
                    "Unsupported file extension" + fileName);
        };
    }
}
