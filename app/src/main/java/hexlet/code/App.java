package hexlet.code;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference.")

class MyApp implements Callable<String> {

    @Override
    public String call() throws Exception {

        return "";
    }
}


public class App {
    static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {

        int exitCode = new CommandLine(new MyApp()).execute(args);
        System.exit(exitCode);

//        System.out.println("Hello World!");
//        logger.info("Hello World!");
    }
}
