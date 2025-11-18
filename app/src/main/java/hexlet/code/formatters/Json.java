package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.Constants.STATUS;
import static hexlet.code.Constants.OLD_VALUE;
import static hexlet.code.Constants.NEW_VALUE;
import static hexlet.code.Constants.UNCHANGED;
import static hexlet.code.Constants.MODIFIED;
import static hexlet.code.Constants.DELETED;


public class Json {
    @SuppressWarnings("checkstyle:LocalVariableName")
    public static String json(Map<String, List<Object>> map) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Map<String, Object>> resultFile = new LinkedHashMap<>();

        for (var keys : map.entrySet()) {

            var key = keys.getKey();
            var values = keys.getValue();
            String status = (String) values.get(STATUS);
            var oldValue = values.get(OLD_VALUE);
            var newValue = values.get(NEW_VALUE);

            Map<String, Object> result = new LinkedHashMap<>();

            resultFile.put(key, result);

            switch (status) {

                case UNCHANGED -> {
                    result.put("status", "unchanged");
                    result.put("value", oldValue);
                }

                case MODIFIED -> {
                    result.put("status", "modified");
                    result.put("oldValue", oldValue);

                    result.put("status", "modified");
                    result.put("newValue", newValue);
                }

                case DELETED -> {
                    result.put("status", "deleted");
                    result.put("oldValue", oldValue);
                }

                default -> {
                    result.put("status", "added");
                    result.put("newValue", newValue);
                }
            }
        }
        return mapper.writeValueAsString(resultFile).trim();
    }
}
