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
        assertEquals(morenames, othername);
    }

    @Test
    public void test2() throws IOException {
        String variablename = Files.readString(Path.of("test-file(1).md"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("https://something.com", "some-page.html");
        assertEquals(morenames, othername);
    }

    @Test
    public void test3() throws IOException {
        String variablename = Files.readString(Path.of("test-file(2).md"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        ArrayList<String> morenames = new ArrayList<String>();
        morenames.add("");
        assertEquals(morenames, othername);
    }

    @Test
    public void test4() throws IOException {
        String variablename = Files.readString(Path.of("test-file(3).md"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        ArrayList<String> morenames = new ArrayList<String>();
        morenames.add("");
        assertEquals(morenames, othername);
    }

    @Test
    public void test5() throws IOException {
        String variablename = Files.readString(Path.of("test-file(4).md"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        ArrayList<String> morenames = new ArrayList<String>();
        morenames.add("");
        assertEquals(morenames, othername);
    }

    @Test
    public void test6() throws IOException {
        String variablename = Files.readString(Path.of("test-file(5).md"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("page.com");
        assertEquals(morenames, othername);
    }

    @Test
    public void test7() throws IOException {
        String variablename = Files.readString(Path.of("test-file(6).md"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        ArrayList<String> morenames = new ArrayList<String>();
        morenames.add("");
        assertEquals(morenames, othername);
    }

    @Test
    public void test8() throws IOException {
        String variablename = Files.readString(Path.of("test-file(7).md"));
        ArrayList<String> othername = MarkdownParse.getLinks(variablename);
        List morenames = List.of("https://something.com");
        assertEquals(morenames, othername);
    }
}