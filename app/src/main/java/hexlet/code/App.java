package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {

    @Option(names = {"-f", "--format"},
            paramLabel = "format",
            defaultValue = "stylish",
            description = "output format [defaule: stylish]")
    private String format;

    @Parameters(index = "0",
            paramLabel = "filepath1",
            description = "path too first file")
    String filepath1;

    @Parameters(index = "1",
            paramLabel = "filepath2",
            description = "path to second file")
    String filepath2;

    @Override
    public String call() throws Exception {

        return "";
    }


    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
