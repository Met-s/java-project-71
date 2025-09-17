package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

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
    @DisplayName("FilePath")
    public void testFilePatch() throws Exception {

        String absPath = Paths.get("/home/admint/Hexlet_Game/"
                        + "java-project-71/app/src/test/resources")
                .toAbsolutePath().normalize().toString();
        String path = "src/test/resources";
        String fileName = "file1.json";

        assertTrue(Files.exists(ReadFile.getPath(absPath, fileName)));
        assertTrue(Files.exists(ReadFile.getPath(path, fileName)));
        assertTrue(Files.exists(ReadFile.getPath(fileName)));
    }

    @Test
    @DisplayName("Reading a file")
    public void testReadFile() throws Exception {
        assertTrue(Files.exists(ReadFile.getPath("file1.json")));
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
