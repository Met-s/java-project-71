package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import static hexlet.code.Constants.UNCHANGED;
import static hexlet.code.Constants.MODIFIED;
import static hexlet.code.Constants.DELETED;

public class Stylish {
    public static String stylish(Map<String, List<Object>> map) {

        var result = new StringBuilder("{\n");

        for (var entry : map.entrySet()) {

            var key = (int) entry.getValue().get(0);
            var value1 = entry.getValue().get(1);
            var value2 = entry.getValue().get(2);

            switch (key) {
                case UNCHANGED ->
                        result.append("    ").append(entry.getKey())
                                .append(": ").append(value1).append("\n");

                case MODIFIED ->
                        result.append("  - ").append(entry.getKey())
                                .append(": ").append(value1).append("\n")

                        .append("  + ").append(entry.getKey())
                                .append(": ").append(value2).append("\n");

                case DELETED -> result.append("  - ").append(entry.getKey())
                        .append(": ").append(value1).append("\n");

                default -> result.append("  + ").append(entry.getKey())
                        .append(": ").append(value2).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
