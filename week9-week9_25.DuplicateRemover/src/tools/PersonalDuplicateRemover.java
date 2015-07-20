/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mika
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    
    private Set<String> words;
    private int numDuplicate;
    
    public PersonalDuplicateRemover() {
        this.words = new HashSet<String>();
        numDuplicate = 0;
    }
    
    @Override
    public void add(String characterString) {
        if (this.words.contains(characterString)) {
            numDuplicate++;
            return;
        }
        words.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return numDuplicate;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.words;
    }

    @Override
    public void empty() {
        this.words.removeAll(words);
        this.numDuplicate = 0;
    }
    
}
