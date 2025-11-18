package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import static hexlet.code.Constants.STATUS;
import static hexlet.code.Constants.OLD_VALUE;
import static hexlet.code.Constants.NEW_VALUE;
import static hexlet.code.Constants.UNCHANGED;
import static hexlet.code.Constants.MODIFIED;
import static hexlet.code.Constants.DELETED;


public class Stylish {
    public static String stylish(Map<String, List<Object>> map) {

        var result = new StringBuilder("{\n");

        for (var entry : map.entrySet()) {

            var key = (String) entry.getValue().get(STATUS);
            var value1 = entry.getValue().get(OLD_VALUE);
            var value2 = entry.getValue().get(NEW_VALUE);

            switch (key) {
                case UNCHANGED -> result.append("    ").append(entry.getKey())
                                .append(": ").append(value1).append("\n");

                case MODIFIED -> result.append("  - ").append(entry.getKey())
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

        return result.toString().trim();
    }
}
