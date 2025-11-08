package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(Map<String, List<Object>> map) {

        var result = new StringBuilder("{\n");

        for (var entry : map.entrySet()) {

            var key = entry.getValue().get(0);
            var value1 = entry.getValue().get(1);
            var value2 = entry.getValue().get(2);

            if (key == "0") {
                result.append("    ").append(entry.getKey()).append(": ")
                        .append(value1).append("\n");

            } else if (key == "1") {
                result.append("  - ").append(entry.getKey()).append(": ")
                        .append(value1).append("\n");

                result.append("  + ").append(entry.getKey()).append(": ")
                        .append(value2).append("\n");

            } else if (key == "2") {
                result.append("  - ").append(entry.getKey()).append(": ")
                        .append(value1).append("\n");

            } else if ((entry.getValue().get(0)) == "3") {
                result.append("  + ").append(entry.getKey()).append(": ")
                        .append(value2).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
