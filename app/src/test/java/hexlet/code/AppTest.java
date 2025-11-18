package hexlet.code;

import hexlet.code.formatters.Stylish;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import picocli.CommandLine;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static hexlet.code.Constants.PLAIN;
import static hexlet.code.Constants.JSON;


final class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private String file1Read;
    private String file2Read;

    private Map<String, Object> file1Parser;
    private Map<String, Object> file2Parser;

    @BeforeEach
     void preparation() throws Exception {

        file1Read = Differ.readFile(Differ.getPath("file1.json"));
        file2Read = Differ.readFile(Differ.getPath("file2.json"));

        file1Parser = Parser.parser(file1Read, "file1.json");
        file2Parser = Parser.parser(file2Read, "file2.json");
    }

    @Test
    @DisplayName("File path")
    public void testDifferGetPath() {

        String absolutePath = FileSystems.getDefault().getPath(
                        "src", "test", "resources", "fixtures", "fileTest.txt")
                .toAbsolutePath()
                .normalize()
                .toString();

        assertTrue(Files.exists(Differ.getPath(absolutePath)));

        assertTrue(Files.exists(
                Differ.getPath("fileTest.txt")));
    }

    @Test
    @DisplayName("Reading a file")
    public void testDifferReadFile() throws Exception {

        Path filePath = Differ.getPath("fileRead.txt");
        String expected = "Hi, Hexlet!";

        assertEquals(expected, Differ.readFile(filePath));
    }

    @Test
    @DisplayName("File not readable")
    public void testDifferReadFileNotReadable() {
        assertThrows(FileNotFoundException.class,
                () -> Differ.readFile(
                        Path.of("file.j")));
    }

    @Test
    @DisplayName("Parser file.json")
    public void testDifferParser() throws Exception {

        String expected = "{host=hexlet.io, timeout=50, proxy=123.234.53.22, follow=false}";
        String actual =
                Parser.parser(file1Read, "file1.json").toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test: Compare.compareFile")
    public void testCompareFile() {

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
        String actual = Stylish.stylish(map);
        String expected = Differ.readFile(
                Differ.getPath("fileTest.txt"));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test: Differ generate")
    public void testDiffGenerate() throws Exception {

        var actual = Differ.generate("file1.json", "file2.json");

        var expected = Differ.readFile(
                Differ.getPath("fileTest.txt"));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Parser file.yaml")
    public void testReadFile() throws Exception {

        Path fileYaml = Differ.getPath("file1.yaml");
        var readFile = Differ.readFile(fileYaml);

        var actual = Parser.parser(readFile, "file1.yaml").toString();
        var expected = "{host=hexlet.io, timeout=50, proxy=123.234.53.22, follow=false}";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Failed to parse file")
    public void testFailedParseFile() {
        assertThrows(IllegalArgumentException.class,
                () -> Parser.parser(null, "file1.txt"));

    }

    @Test
    @DisplayName("Test: plain Format")
    public void testPlainFormat() throws Exception {
        var expected = Differ.readFile(
                Differ.getPath("filePlainTest.txt"));

        var actual = Differ.generate("filepath1.json", "filepath2.json",
                PLAIN);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test: Non-existent Format")
    public void testExceptionFormat() throws Exception {
        var actual = Differ.generate(
                        "file1.json",
                        "file2.json",
                "<Non-existent format>");

        assertEquals("<Non-existent format> - Formatter name is incorrect",
                actual.trim());
    }

    @Test
    @DisplayName("Test: Format json")
    public void testFormatJson() throws Exception {

        var actual = Differ.generate("file1.yaml", "file2.yaml", JSON);

        var expected = Differ.readFile(
                Differ.getPath("testJson.json"));

        assertEquals(expected, actual);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @DisplayName("Test: App.main")
    @Test
    public void testMain() {

        int exitCode = new CommandLine(new App()).execute();
        System.out.println(exitCode);
        String result = Objects.toString(exitCode);

        assertEquals(result,
                output.toString(StandardCharsets.UTF_8).trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
