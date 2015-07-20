package wordinspection;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection wordinspect = new WordInspection(file);
        
        List<String> words = wordinspect.palindromes();
        for (String s : words) {
            System.out.println(s);
        }
        words = wordinspect.wordsContainingZ();
        for (String s : words) {
            System.out.println(s);
        }
        words = wordinspect.wordsWhichContainAllVowels();
        for (String s : words) {
            System.out.println(s);
        }
    }
}
