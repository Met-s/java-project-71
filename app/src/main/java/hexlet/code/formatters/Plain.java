package hexlet.code.formatters;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import static hexlet.code.Constants.STATUS;
import static hexlet.code.Constants.OLD_VALUE;
import static hexlet.code.Constants.NEW_VALUE;
import static hexlet.code.Constants.MODIFIED;
import static hexlet.code.Constants.DELETED;
import static hexlet.code.Constants.ADDED;


public class Plain {
    public static String plain(Map<String, List<Object>> map) {

        var result = new StringBuilder();
        for (var entry : map.entrySet()) {

            var key = (String) entry.getValue().get(STATUS);
            var value1 = complexValue(entry.getValue().get(OLD_VALUE));
            var value2 = complexValue(entry.getValue().get(NEW_VALUE));

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
                        .append("' was added with value: ")
                        .append(value2);

                default -> { }
            }
        }
        return result.toString().trim();
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
