package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Formatter {
    public static String format(Map<String, List<Object>> map, String format) {

        if (Objects.equals(format, "stylish")) {
            return Stylish.stylish(map);
        }
        if (Objects.equals(format, "plain")) {
            return Plain.plain(map);
        }
        return format + " - Formatter name is incorrect";
    }
}
