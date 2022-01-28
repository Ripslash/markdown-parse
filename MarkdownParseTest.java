import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    
    
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test1() throws IOException {
        String variablename = Files.readString(Path.of("test-file.md"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("https://something.com", "some-page.html");
        assertEquals(othername, morenames);
    }

    @Test
    public void test2() throws IOException {
        String variablename = Files.readString(Path.of("test-file.md(1)"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("https://something.com", "some-page.html");
        assertEquals(othername, morenames);
    }

    @Test
    public void test3() throws IOException {
        String variablename = Files.readString(Path.of("test-file.md(2)"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("");
        assertEquals(othername, morenames);
    }

    @Test
    public void test4() throws IOException {
        String variablename = Files.readString(Path.of("test-file.md(3)"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("");
        assertEquals(othername, morenames);
    }

    @Test
    public void test5() throws IOException {
        String variablename = Files.readString(Path.of("test-file.md(4)"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("");
        assertEquals(othername, morenames);
    }

    @Test
    public void test6() throws IOException {
        String variablename = Files.readString(Path.of("test-file.md(5)"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("page.com");
        assertEquals(othername, morenames);
    }

    @Test
    public void test7() throws IOException {
        String variablename = Files.readString(Path.of("test-file.md(6)"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("");
        assertEquals(othername, morenames);
    }

    @Test
    public void test8() throws IOException {
        String variablename = Files.readString(Path.of("test-file.md(7)"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("https://something.com");
        assertEquals(othername, morenames);
    }
}