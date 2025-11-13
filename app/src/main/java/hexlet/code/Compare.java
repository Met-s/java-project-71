package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Arrays;

import static hexlet.code.Constants.UNCHANGED;
import static hexlet.code.Constants.MODIFIED;
import static hexlet.code.Constants.DELETED;
import static hexlet.code.Constants.ADDED;


public class Compare {

    public static Map<String, List<Object>> compareFiles(
            Map<String, Object> file1, Map<String, Object> file2) {

        Map<String, Object> diff = new TreeMap<>(file1);
        diff.putAll(file2);

        Map<String, List<Object>> result = new LinkedHashMap<>();


        for (var key : diff.keySet()) {
            var value1 = file1.get(key);
            var value2 = file2.get(key);
            var file1Key = file1.containsKey(key);
            var file2Key = file2.containsKey(key);

            if (file1Key && file2Key
                    && Objects.equals(value1, value2)) {
                result.put(key, Arrays.asList(UNCHANGED, value1, value2));
            }
            if (file1Key && file2Key
                    && !Objects.equals(value1, value2)) {
                result.put(key, Arrays.asList(MODIFIED, value1, value2));
            }
            if (file1Key && !file2Key) {
                result.put(key, Arrays.asList(DELETED, value1, null));
            }
            if (!file1Key && file2Key) {
                result.put(key, Arrays.asList(ADDED, null, value2));
            }
        }
        return result;
    }
}
