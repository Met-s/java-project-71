package hexlet.code.formats;

import java.util.List;
import java.util.Map;

public class StylishFormat {
    public static String buildList(Map<String, List<Object>> map) {

        var result = new StringBuilder("{\n");

        for (var entry : map.entrySet()) {

            if ((entry.getValue().get(0)) == "0") {
                result.append("    ").append(entry.getKey()).append(": ")
                        .append(entry.getValue().get(1)).append("\n");

            } else if ((entry.getValue().get(0)) == "1") {
                result.append("  - ").append(entry.getKey()).append(": ")
                        .append(entry.getValue().get(1)).append("\n");

                result.append("  + ").append(entry.getKey()).append(": ")
                        .append(entry.getValue().get(2)).append("\n");

            } else if ((entry.getValue().get(0)) == "2") {
                result.append("  - ").append(entry.getKey()).append(": ")
                        .append(entry.getValue().get(1)).append("\n");

            } else if ((entry.getValue().get(0)) == "3") {
                result.append("  + ").append(entry.getKey()).append(": ")
                        .append(entry.getValue().get(2)).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
