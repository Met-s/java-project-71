package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;
//import picocli.CommandLine;
//import java.util.Map;
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
    public String call() throws Exception {
        var path1 = "src/test/resources/" + filepath1;
        var path2 = "src/test/resources/" + filepath2;
        String result = Diff.diff(path1, path2);
        System.out.println(path1);


        System.out.println(result);

//        var file1Key = ReadFile.parser("src/test/resources/" + filepath1);
//        var file2Key = ReadFile.parser("src/test/resources/" + filepath2);
//        var file1 = ReadFile.parser(filepath1)
//        System.out.println(filepath1);
//
//        System.out.println(file1Key + "\n" + file2Key);
        return result;
    }
}


public class App {

    public static void main(String[] args) throws Exception {

        int exitCode = new CommandLine(new MyApp()).execute(args);

        System.exit(exitCode);
//----------------------------------
//
//        String puth1 = "src/test/resources/file1.json";
//        String puth2 = "src/test/resources/file2.json";
//        var file1 = ReadFile.parser(puth1);
//        var file2 = ReadFile.parser(puth2);
//
//        var file1Key = file1.keySet();
//        var file2Key = file2.keySet();
//
//        System.out.println(file1);
//        System.out.println(file2);

//        make run-dist "src/test/resources/file1.json" "src/test/resources/file2.json"



    }
}
