package uet.oop.bomberman.entities;

import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.graphic.Sprite;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bomber extends Entity {

    private int numBombs = 1;
    private int flameLength = 1;
    private int speed = Sprite.SCALED_SIZE / 8;
    private boolean isAlive = true;
    public List<Bomb> bombs = new ArrayList<>();

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {

    }

    public void goUp() {
        this.y -= this.speed;
        if (checkBounds()) this.y += this.speed;
        checkBounds();
        setImg(Sprite.movingSprite(Sprite.bomber_look_up, Sprite.bomber_move_up1, Sprite.bomber_move_up2, this.getX(), Sprite.DEFAULT_SIZE).getFxImage());
    }

    public void goRight() {
        this.x += this.speed;
        if (checkBounds()) this.x -= this.speed;
        checkBounds();
        setImg(Sprite.movingSprite(Sprite.bomber_look_right, Sprite.bomber_move_right1, Sprite.bomber_move_right2, this.getX(), Sprite.DEFAULT_SIZE).getFxImage());
    }

    public void goDown() {
        this.y += this.speed;
        if (checkBounds()) this.x -= this.speed;
        checkBounds();
        setImg(Sprite.movingSprite(Sprite.bomber_look_down, Sprite.bomber_move_down1, Sprite.bomber_move_down2, this.getX(), Sprite.DEFAULT_SIZE).getFxImage());
    }

    public void goLeft() {
        this.x -= this.speed;
        if (checkBounds()) this.x += this.speed;
        checkBounds();
        setImg(Sprite.movingSprite(Sprite.bomber_look_left, Sprite.bomber_move_left1, Sprite.bomber_move_left2, this.getX(), Sprite.DEFAULT_SIZE).getFxImage());
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getNumBombs() {
        return numBombs;
    }

    public void setNumBombs(int numBombs) {
        this.numBombs = numBombs;
    }

    public int getFlameLength() {
        return flameLength;
    }

    public void setFlameLength(int flameLength) {
        this.flameLength = flameLength;
    }

    public void removeBomb(Bomb b) {
        Iterator<Bomb> bombIterator = this.bombs.iterator();
        while (bombIterator.hasNext()) {
            Bomb bomb = bombIterator.next();

            if (bomb.getX() == b.getX() && bomb.getY() == b.getY()) {
                bombIterator.remove();
            }
        }
    }
}
