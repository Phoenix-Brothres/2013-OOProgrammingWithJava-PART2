/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mika
 */
public class Dungeon {

    private int length;
    private int height;
    private int vampires;
    private int moves;
    boolean vampiresMove;
    private Player player;
    private List<Vampire> vamps;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.player = new Player(length, height);
        createVamps(vampires, length, height);
    }

    public void run() {
        UserInterface UI = new UserInterface();

        String commands;
        while (true) {
            UI.printHUD(moves, player, vamps);
            UI.printMap(player, vamps, length, height);
            commands = UI.takeCommands();
            move(commands);
            player.killVamp(vamps);
            if (checkWinOrLose()) {
                break;
            }
        }
    }

    private void move(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            player.move(Character.toString(commands.charAt(i)));
            if (vampiresMove) {
                for (Vampire v : vamps) {
                    v.move(vamps);
                }
            }
        }
        this.moves--;
    }

    private void createVamps(int vampires, int length, int height) {
        this.vamps = new ArrayList<Vampire>();
        Random random = new Random();
        for (int i = 0; i < vampires; i++) {
            vamps.add(new Vampire(random.nextInt(length), random.nextInt(height), length, height));
        }
    }

    private boolean checkWinOrLose() {
        if (this.vamps.isEmpty()) {
            System.out.println("YOU WIN");
            return true;
        } else if (!(this.moves > 0)) {
            System.out.println("YOU LOSE");
            return true;
        }
        return false;
    }
}
