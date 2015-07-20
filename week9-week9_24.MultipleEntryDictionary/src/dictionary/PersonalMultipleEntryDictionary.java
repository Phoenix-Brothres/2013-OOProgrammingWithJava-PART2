/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mika
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> dic;

    public PersonalMultipleEntryDictionary() {
        dic = new HashMap<String, Set<String>>();
    }
    
    @Override
    public void add(String word, String entry) {
        if (!dic.containsKey(word)) {
            dic.put(word, new HashSet<String>());
        }
        dic.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        return dic.get(word);
    }

    @Override
    public void remove(String word) {
        dic.remove(word);
    }
}
