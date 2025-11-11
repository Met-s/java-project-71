package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Formatter {
    public static String format(Map<String, List<Object>> map, String format) throws IOException {

        if (Objects.equals(format, "stylish")) {
            return Stylish.stylish(map);
        }
        if (Objects.equals(format, "plain")) {
            return Plain.plain(map);
        }
        if (Objects.equals(format, "json")) {
            return Json.json(map);
        }
        return format + " - Formatter name is incorrect";
    }
}
