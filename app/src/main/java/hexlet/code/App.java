package hexlet.code;

import picocli.CommandLine;
import java.util.concurrent.Callable;


@CommandLine.Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {

    @Override
    public String call() throws Exception {

        return "";
    }


    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
