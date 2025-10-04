package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static hexlet.code.ReadFile.getPath;
import static hexlet.code.ReadFile.read;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final String relativePath = "src/test/resources/file1.json";

    @ParameterizedTest
    @CsvSource({
        "file1w.json, file2w.json, resultW.txt"
    })

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));

    }


    @Disabled
    @Test
    @DisplayName("Command ")
    public void testApp() throws Exception {
        App.main(new String[0]);
        assertEquals("Hello, World!",
                output.toString(StandardCharsets.UTF_8).trim());
    }

    @Test
    @DisplayName("PathFile")
    public void testPatchFile() throws Exception {
        String absolutePath = "/home/admint/Hexlet_Game/java-project-71/app/src/test/resources/file1.json";

        assertTrue(Files.exists(getPath(relativePath)));
        assertTrue(Files.exists(getPath(absolutePath)));
    }

    @Test
    @DisplayName("ReadFile")
    public void testReadFile() throws Exception {
        String pathSt = "src/test/resources/read.txt";
        Path path = getPath(pathSt);

        assertTrue(Files.exists(path));
        assertEquals("Hi, read file Hexlet!", read(path));
    }

    @Test
    @DisplayName("Parser_ReadFile")
    public void testParserFile() throws Exception {
        String expected = "{host=hexlet.io, timeout=50, proxy=123.234.53.22, follow=false}";
        String actual =
                ReadFile.parser(read(getPath(relativePath))).toString();
        assertEquals(expected, actual);
    }

    @Disabled
    @Test
    @DisplayName("'diff' method")
    public void testDiff() throws Exception {
        String file1 = "src/test/resources/file1w.json";
        String file2 = "src/test/resources/file2w.json";
        var actual = Diff.diff(file1, file2);
        var expected = "{host=hexlet.io, timeout=20, verbose=true}";
        assertEquals(expected, actual);
    }

    @Disabled("deleted method")
    @Test
    @DisplayName("'main' method works correctly")
    public void testMain() throws Exception {
        App.main(null);
        assertEquals("Hello, World!",
                output.toString(StandardCharsets.UTF_8).trim());
    }



    @Disabled
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
