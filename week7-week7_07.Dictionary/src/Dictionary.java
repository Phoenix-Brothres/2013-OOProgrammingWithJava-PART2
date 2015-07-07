
import java.util.HashMap;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
public class Dictionary {
    
    private HashMap<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<String, String>();
    }
    
    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } else {
            return null;
        }
    }
    
    public void add(String word, String translation) {
        this.dictionary.put(word, translation);
    }
    
    public int amountOfWords() {
        return this.dictionary.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> translations = new ArrayList<String>(this.dictionary.values());
        ArrayList<String> words = new ArrayList<String>(this.dictionary.keySet());
        ArrayList<String> translationList = new ArrayList<String>();
        String entry = "";
        for (int i = 0; i < words.size(); i++) {
            entry = translations.get(i) + " = " + words.get(i);
            translationList.add(entry);
        }
        return translationList;
    }
}
