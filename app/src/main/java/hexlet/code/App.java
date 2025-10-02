package hexlet.code;

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
    public String call() {

        String result = "Hello, World!";
        System.out.println(result);

        return result;
    }
}


public class App {

    public static void main(String[] args) throws Exception {

//        int exitCode = new CommandLine(new MyApp()).execute(args);
//        System.exit(exitCode);
//----------------------------------
        System.out.println(System.getenv("SONAR_TOKEN"));
//----------------------------------
        String puth1 = "src/test/resources/file1.json";
        String puth2 = "src/test/resources/file2.json";
        var file1 = ReadFile.parser(puth1);
        var file2 = ReadFile.parser(puth2);

        var file1Key = file1.keySet();
        var file2Key = file2.keySet();
//        System.out.println(file1 + "\n" + file2);
        System.out.println(file1);
        System.out.println(file2);


//        var names = file1Key.stream()
//                .map()
//                .sorted()
//                .toList();
//        names.forEach(s -> System.out.println(s + ": " + file1.get(s)));

//        System.out.println(names);



//        for (String key1 : file1.keySet()) {
//            for (String key2 : file2.keySet()) {
//                if (key1.equals(key2)) {
//                    System.out.println("+ " + key1);
//                } else{
//                    System.out.println("- " + key1);
//                }
//            }
//        }


//        System.out.println(result1Key);

//
//        var result = result1Key.stream()
//                .sorted()
//                .toList();
//        System.out.println(result);
//                .forEach(System.out::println);


//        result1Key.forEach(s -> System.out.println(s.charAt(0)));

//        var result = result1.stream();



    }
}
