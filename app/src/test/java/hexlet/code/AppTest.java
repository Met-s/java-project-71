package hexlet.code;

import hexlet.code.formats.StylishFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


public class AppTest {
//    private final PrintStream standardOut = System.out;
//    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private final String relativePath =  FileSystems.getDefault().getPath(
            "src", "test", "resources", "fixtures").toString();


    private final String absolutePath = FileSystems.getDefault().getPath(
            "/home", "admint", "Hexlet_Game", "java-project-71",
        "app", "src", "test", "resources", "fixtures").toString();

    Path filePath1;
    Path filePath2;

    String file1Read;
    String file2Read;

    Map<String, Object> file1Parser;
    Map<String, Object> file2Parser;

    @BeforeEach
    public void preparation() throws Exception {

        filePath1 = Differ.getPath(relativePath + "/file1.json");
        filePath2 = Differ.getPath(relativePath + "/file2.json");

        file1Read = Differ.readFile(filePath1);
        file2Read = Differ.readFile(filePath2);

        file1Parser = Differ.parser(file1Read);
        file2Parser = Differ.parser(file2Read);
    }

    @Test
    @DisplayName("File path")
    public void testDifferGetPath() throws Exception {

        assertTrue(Files.exists(
                Differ.getPath(relativePath + "/fileTest.txt")));
        assertTrue(Files.exists(Differ.getPath(
                absolutePath + "/fileTest.txt")));
    }

    @Test
    @DisplayName("Reading a file")
    public void testDifferReadFile() throws Exception {

        Path filePath = Differ.getPath(relativePath + "/fileRead.txt");
        String expected = "Hi, Hexlet!";
        assertEquals(expected, Differ.readFile(filePath));
    }

    @Test
    @DisplayName("Parser")
    public void testDifferParser() throws Exception {

        String expected = "{host=hexlet.io, timeout=50, proxy=123.234.53.22, follow=false}";
        String actual =
                Differ.parser(file1Read).toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test: Compare.compareFile")
    public void testCompareFile() throws Exception {

        var compareResult = Compare.compareFiles(file1Parser, file2Parser);

        String actual = "{follow=[2, false, null], "
                + "host=[0, hexlet.io, hexlet.io], "
                + "proxy=[2, 123.234.53.22, null], "
                + "timeout=[1, 50, 20], verbose=[3, null, true]}";
        assertEquals(compareResult.toString(), actual);
    }

    @Test
    @DisplayName("Test: Stylish Format")
    public void testStylishFormat() throws Exception {

        var map = Compare.compareFiles(file1Parser, file2Parser);
        String actual = StylishFormat.buildList(map);
        String expected = Differ.readFile(
                Differ.getPath(relativePath + "/fileTest.txt"));


        assertEquals(expected.trim(), actual.trim());
    }

    @Test
    @DisplayName("Test: Differ generate")
    public void testDiffGenerate() throws Exception {

        var actual = Differ.generate(relativePath + "/file1.json",
                relativePath + "/file2.json");
        var expected = Differ.readFile(
                Differ.getPath(relativePath + "/fileTest.txt"));
        System.out.println(actual);

        assertEquals(expected, actual);
    }


//    @BeforeEach
//    public void setUp() {
//        System.setOut(new PrintStream(output));
//    }


//    @Disabled("Deleted method")
//    @Test
//    public void testMain() {
//        App.main(null);
//        assertEquals("Hello World!",
//                output.toString(StandardCharsets.UTF_8).trim());
//    }
//
//    @AfterEach
//    public void tearDown() {
//        System.setOut(standardOut);
//    }
}
