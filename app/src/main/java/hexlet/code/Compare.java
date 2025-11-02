package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Arrays;


public class Compare {
    public static Map<String, List<Object>> compareFiles(
            Map<String, Object> file1, Map<String, Object> file2) {

        Map<String, Object> diff = new TreeMap<>(file1);
        diff.putAll(file2);

        Map<String, List<Object>> result = new LinkedHashMap<>();


        for (var key : diff.keySet()) {
            var value1 = file1.get(key);
            var value2 = file2.get(key);

            if (file1.containsKey(key) && file2.containsKey(key)
                    && Objects.equals(value1, value2)) {
                result.put(key, Arrays.asList("0", value1, value2));
            }
            if (file1.containsKey(key) && file2.containsKey(key)
                    && !Objects.equals(value1, value2)) {
                result.put(key, Arrays.asList("1", value1, value2));
            }
            if (file1.containsKey(key) && !file2.containsKey(key)) {
                result.put(key, Arrays.asList("2", value1, null));
            }
            if (!file1.containsKey(key) && file2.containsKey(key)) {
                result.put(key, Arrays.asList("3", null, value2));
            }
        }
        return result;
    }
}
