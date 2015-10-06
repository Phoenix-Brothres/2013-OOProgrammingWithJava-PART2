package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);
        random = new Random();
        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
        while (true) {
            this.apple = new Apple(random.nextInt(width), random.nextInt(height));
            if (!worm.runsInto(apple)) {
                break;
            }
        }
        addActionListener(this);
        setInitialDelay(2000);
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        worm.move();
        if (worm.runsInto(apple)) {
            worm.grow();
            while (true) {
                apple = new Apple(random.nextInt(width), random.nextInt(height));
                if (!worm.runsInto(apple)) {
                    break;
                }
            }
        }
        if (worm.runsIntoItself()) {
            continues = false;
        }
        if (hitsBoarder()) {
            continues = false;
        }
        updatable.update();
        setDelay(1000 / worm.getLength());
    }

    private boolean hitsBoarder() {
        if (worm.getXY()[0] < 0 || worm.getXY()[1] < 0 || worm.getXY()[0] >= this.width || worm.getXY()[1] >= this.height) {
            return true;
        }
        return false;
    }
}
