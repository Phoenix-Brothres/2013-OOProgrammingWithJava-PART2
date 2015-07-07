/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
public class Change {
        private char fromCharacter;
        private char toCharacter;

        public Change(char fromCharacter, char toCharacter) {
            this.fromCharacter = fromCharacter;
            this.toCharacter = toCharacter;
        }
        
        public String change(String characterString) {
            //int i
            
            char[] charArray = characterString.toCharArray();
            for (int i  = 0; i < characterString.length(); i ++) {
                if (characterString.charAt(i) == this.fromCharacter) {
                    charArray[i] = toCharacter;
                }
            }
            characterString = String.valueOf(charArray);
            return characterString;
        }
}
