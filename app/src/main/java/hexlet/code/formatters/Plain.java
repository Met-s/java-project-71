package hexlet.code.formatters;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import static hexlet.code.Constants.MODIFIED;
import static hexlet.code.Constants.DELETED;
import static hexlet.code.Constants.ADDED;


public class Plain {
    public static String plain(Map<String, List<Object>> map) {

        var result = new StringBuilder();
        for (var entry : map.entrySet()) {

            var key = (int) entry.getValue().get(0);
            var value1 = complexValue(entry.getValue().get(1));
            var value2 = complexValue(entry.getValue().get(2));

            switch (key) {
                case MODIFIED ->  result.append("\nProperty '")
                        .append(entry.getKey())
                        .append("' was updated. From ")
                        .append(value1).append(" to ").append(value2);

                case DELETED -> result.append("\nProperty '")
                        .append(entry.getKey())
                        .append("' was removed");

                case ADDED -> result.append("\nProperty '")
                        .append(entry.getKey())
                        .append("' was added with value: '")
                        .append(value2).append("'");

                default -> { }
            }
        }
        return result.toString();
    }

    public static Object complexValue(Object value) {
        if (value instanceof Map || value instanceof List || value instanceof Array) {

            return "[complex value]";

        } else if (value instanceof String) {

            return "'" + value + "'";
        }
        return value;
    }
}
