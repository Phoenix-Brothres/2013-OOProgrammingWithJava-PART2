/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Mika
 */
public class MindfulDictionary {

    private Map<String, String> wordTrans = new HashMap<String, String>();
    private Map<String, String> transWord = new HashMap<String, String>();
    private String file;

    public MindfulDictionary() {
    }

    public MindfulDictionary(String file) {
        this.file = file;
    }

    public boolean load() {
        try {
            File f = new File(file);
            Scanner reader = new Scanner(f);
            while (reader.hasNext()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void add(String word, String translation) {
        if (!wordTrans.containsKey(word)) {
            wordTrans.put(word, translation);
        }
        if (!transWord.containsKey(translation)) {
            transWord.put(translation, word);
        }
    }

    public String translate(String word) {
        if (wordTrans.containsKey(word)) {
            return wordTrans.get(word);
        } else if (transWord.containsKey(word)) {
            return transWord.get(word);
        } else {
            return null;
        }
    }

    public void remove(String word) {
        String translation1 = wordTrans.get(word);
        String translation2 = transWord.get(word);
        wordTrans.remove(word);
        wordTrans.remove(translation1);
        wordTrans.remove(translation2);
        transWord.remove(word);
        transWord.remove(translation1);
        transWord.remove(translation2);
    }
    
    public boolean save() {
        try {
            FileWriter f = new FileWriter(file);
            for (String word : wordTrans.keySet()) {
                f.write(word);
                f.write(":");
                f.write(wordTrans.get(word));
                f.write("\n");
            }
            f.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}