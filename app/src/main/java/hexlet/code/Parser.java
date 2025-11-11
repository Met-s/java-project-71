package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String file, String fileName) {

        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

        try {
            ObjectMapper mapper = null;

            if (extension.equals("json")) {

                mapper = new ObjectMapper();

            } else if (extension.equals("yaml") || extension.equals("yml")) {

                mapper = new YAMLMapper();
            }
            assert mapper != null;
            return mapper.readValue(file, new TypeReference<>() { });

        } catch (Exception e) {
            throw new NullPointerException("Failed to parse file: " + fileName);
        }
    }
}
