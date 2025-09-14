package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference.")

class MyApp implements Callable<String> {

    @Option(names = {"-f", "--format"},
            defaultValue = "stylish",
            description = "output format [default: stylish]")
    private String format;

    @Parameters(index = "0",
            defaultValue = "",
            description = "path to first file")
    String filepath1;

    @Parameters(index = "1",
            defaultValue = "",
            description = "path to second file")
    String filepath2;

    @Override
    public String call() {

        String result = "Hello, World!";
        System.out.println(result);

        return result;
    }
}


public class App {

    public static void main(String[] args) throws Exception {

        int exitCode = new CommandLine(new MyApp()).execute(args);
        System.exit(exitCode);

    }
}
