// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.w3c.dom.ls.LSException;

//javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
//java -cp ".;lib/junijavac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.javat-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1) break;
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if(nextCloseBracket == -1) break;
            int openParen = markdown.indexOf("(", nextCloseBracket); 
            if(openParen != nextCloseBracket + 1) {
                currentIndex = nextCloseBracket;
                continue;
            }
            System.out.println("words");
            if(openParen == -1) break;
            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen == -1) break;
            String newString =  markdown.substring(openParen + 1, closeParen);

            if(newString.indexOf("]") != -1) {
                nextCloseBracket = markdown.indexOf("", openParen + 1);
                openParen = markdown.indexOf("(", nextCloseBracket);
            } //java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore  MarkdownParseTest
            //javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar MarkdownParseTest.java
            //scp -r . cs15lwi22aun@ieng6.ucsd.edu:~/; ssh cs15lwi22aun@ieng6.ucsd.edu "javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar MarkdownParseTest.java; java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore MarkdownParseTest"


            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            System.out.println(currentIndex);
        } 
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        //System.out.println(links);
    }
}


