package hexlet.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final String relativePath = "src/test/resources/fileTest.txt";

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("File path")
    public void testDifferGetPath() throws Exception {
        String absolutePath =
                "/home/admint/Hexlet_Game/java-project-71/app/src/test/resources/fileTest.txt";

        assertTrue(Files.exists(Differ.getPath(absolutePath)));
        assertTrue(Files.exists(Differ.getPath(relativePath)));
    }

    @Test
    @DisplayName("Reading a file")
    public void testDifferReadFile() throws Exception {

        String expected = "Hi, Hexlet!";
        assertEquals(expected, Differ.readFile(relativePath));
    }

    @Test
    @DisplayName("Parser")
    public void testDifferParser() throws Exception {
        String expected = "{host=hexlet.io, timeout=50, proxy=123.234.53.22, follow=false}";
        String absolutePath = "/home/admint/Hexlet_Game/java-project-71/app/src/test/resources/file1.json";
        String actual = Differ.parser(absolutePath).toString();
        assertEquals(expected, actual);
    }

    @Disabled("Deleted method")
    @Test
    public void testMain() {
        App.main(null);
        assertEquals("Hello World!",
                output.toString(StandardCharsets.UTF_8).trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
