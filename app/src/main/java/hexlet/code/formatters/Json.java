package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Json {
    public static String json(Map<String, List<Object>> map) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Map<String, Object>> resultFile = new LinkedHashMap<>();

        for (var keys : map.entrySet()) {

            var key = keys.getKey();
            var values = keys.getValue();
            var status = (String) values.get(0);
            var oldValue = values.get(1);
            var newValue = values.get(2);

            Map<String, Object> result = new LinkedHashMap<>();

            resultFile.put(key, result);

            if (status.equals("0")) {
                result.put("status", "unchanged");
                result.put("value", oldValue);

            } else if (status.equals("1")) {
                result.put("status", "modified");
                result.put("oldValue", oldValue);

                result.put("status", "modified");
                result.put("newValue", newValue);

            } else if (status.equals("2")) {
                result.put("status", "deleted");
                result.put("oldValue", oldValue);


            } else if (status.equals("3")) {
                result.put("status", "added");
                result.put("newValue", newValue);
            }
        }
        return mapper.writeValueAsString(resultFile);
    }
}
