package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")

class MyApp implements Callable<Integer> {

    @Override
    public Integer call() { // business logic

        return 1;
    }
}

public class App {
    public static void main(String[] args) {

        new CommandLine(new MyApp()).execute(args);
    }
}
