/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mika
 */
public class UserInterface {
    
    Scanner reader = new Scanner(System.in);

    public void printHUD(int moves, Player player, List<Vampire> vampires) {
        System.out.println(moves);
        System.out.println("");
        System.out.println(player);
        for (Vampire vamp : vampires) {
            System.out.println(vamp);
        }
        System.out.println("");
    }

    public void printMap(Player player, List<Vampire> vamps, int length, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                String whatIsThere = ".";
                for (Vampire v : vamps) {
                    if (v.checkObjectIsThere(j, i))
                        whatIsThere = "v";
                }
                if (player.checkObjectIsThere(j, i)) {
                    whatIsThere = "@";
                }
                System.out.print(whatIsThere);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public String takeCommands(){
        return reader.nextLine();
    }
}
