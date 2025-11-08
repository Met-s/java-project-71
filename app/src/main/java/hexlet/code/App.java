package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.FileSystems;
import java.util.concurrent.Callable;


@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {

    @Option(names = {"-f", "--format"},
            paramLabel = "format",
            defaultValue = "stylish",
            description = "output format [default: stylish]")
    private String format;

    @Parameters(index = "0",
            paramLabel = "filepath1",
            description = "path too first file")
    private String filepath1;

    @Parameters(index = "1",
            paramLabel = "filepath2",
            description = "path to second file")
    private String filepath2;

    private static String getFixturePath(String filename) {
        return FileSystems.getDefault().getPath(
                "src", "test", "resources", "fixtures", filename).toString();
    }

    @Override
    public String call() throws Exception {

        String pathFile1 = getFixturePath(filepath1);
        String pathFile2 = getFixturePath(filepath2);

        var result = Differ.generate(pathFile1, pathFile2, format);

        System.out.println(result);

        return "";
    }

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
