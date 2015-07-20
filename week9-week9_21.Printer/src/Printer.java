
import java.io.File;
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
public class Printer {

    private File file;
    private Scanner reader;

    public Printer(String fileName) throws Exception {
        this.file = new File(fileName);
    }

    public void printLinesWhichContain(String word) throws Exception {
        this.reader = new Scanner(this.file);
        String line = "";
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            if (line.contains(word)) {
                System.out.println(line);
            }
        }
        reader.close();
    }
}
