import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
public class TextUserInterface {
    
    private Scanner reader;
    private Dictionary dictionary;        
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start() {
        System.out.println("Statement:\n" +
"  quit - quit the text user interface\n\n");
        askUser();
    }
    
    private void askUser() {
        String userInput;
        String[] commands = {"quit", "add", "translate"};
        while (true) {
            System.out.println("Statement: ");
            userInput = reader.nextLine();
            userInput = stringCleaner(userInput);
            if (!Arrays.asList(commands).contains(userInput)) {
                System.out.println("Unknown statement");
                continue;
            }
            if (userInput.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (userInput.equals("add")) {
                add();
            } else if (userInput.equals("translate")) {
                translate();
            }
        }
    }
    
    private String stringCleaner(String string) {
        if (string == null) {
            return "";
        }

        string = string.toLowerCase();
        return string.trim();
    }
    
    private void add() {
        System.out.println("In Finnish: ");
        String finnish = reader.nextLine();
        System.out.println("Translation: ");
        String trans = reader.nextLine();
        dictionary.add(finnish, trans);
    }
    
    private void translate() {
        System.out.println("Give a word: ");
        String finnish = reader.nextLine();
        String trans = dictionary.translate(finnish);
        System.out.println("Translation: " + trans);
    }
}
