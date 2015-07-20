package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mika
 */
public class WordInspection {

    private File file;

    public WordInspection(File file) throws Exception {
        this.file = file;
    }

    public int wordCount() {
        int wordCnt = 0;
        try {
            Scanner reader = new Scanner(this.file, "UTF-8");
            while (reader.hasNext()) {
                reader.next();
                wordCnt++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Couldn't read the file: " + e.getMessage());
        }
        return wordCnt;
    }

    public List<String> wordsContainingZ() {
        List<String> words = new ArrayList<String>();
        String word;
        try {
            Scanner reader = new Scanner(this.file, "UTF-8");
            while (reader.hasNext()) {
                word = reader.next();
                if (word.contains("z")) {
                    words.add(word);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Couldn't read the file: " + e.getMessage());
        }
        return words;
    }

    public List<String> wordsEndingInL() {
        List<String> words = new ArrayList<String>();
        String word;
        try {
            Scanner reader = new Scanner(this.file, "UTF-8");
            while (reader.hasNext()) {
                word = reader.next();
                if (word.endsWith("l")) {
                    words.add(word);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Couldn't read the file: " + e.getMessage());
        }
        return words;
    }

    public List<String> palindromes() {
        List<String> words = new ArrayList<String>();
        String word, reverse = "";
        try {
            Scanner reader = new Scanner(this.file, "UTF-8");
            while (reader.hasNext()) {
                word = reader.next();
                for (int i = word.length() - 1; i >= 0; i--) {
                    reverse = reverse + word.charAt(i);
                }
                if (word.equals(reverse)) {
                    words.add(word);
                    reverse = "";
                } else {
                    reverse = "";
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Couldn't read the file: " + e.getMessage());
        }
        return words;
    }
    
     public List<String> wordsWhichContainAllVowels() {
        List<String> words = new ArrayList<String>();
        String word;
        try {
            Scanner reader = new Scanner(this.file, "UTF-8");
            while (reader.hasNext()) {
                word = reader.next();
                if (word.contains("a") && word.contains("e") && word.contains("i") && word.contains("o") && word.contains("u") && word.contains("y") && word.contains("ä") && word.contains("ö")) {
                    words.add(word);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Couldn't read the file: " + e.getMessage());
        }
        return words;
     }
}
