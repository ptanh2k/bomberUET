package uet.oop.bomberman.entities;

import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.graphic.Sprite;
import javafx.scene.image.Image;
import uet.oop.bomberman.sound.Sound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bomber extends Entity {

    private int numBombs = 1;
    private int flameLength = 1;
    private int speed = Sprite.SCALED_SIZE / 8;
    private boolean isAlive = true;

    public boolean bombPasse = true;

    public boolean wallPass = true;

    public boolean flamePass = true;

    public List<Bomb> bombs = new ArrayList<>();

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public boolean isBombPasse() {
        return bombPasse;
    }

    public boolean isWallPass() {
        return wallPass;
    }

    public boolean isFlamePass() {
        return flamePass;
    }

    @Override
    public void update() {
        if (isAlive()) {
            if (touchDeadlyObstacle()) {
                Sound.play("endgame3");
                bomberDie();
            }
        }
        if (checkPortal()) {

        }
    }

    public void goUp() {
        for (int i = 1; i <= this.speed; ++i) {
            this.y -= 1;
            if (checkBounds() || checkBoundsBomb() || checkBoundsBomb()) {
                this.y += 1;
                if (this.x % Sprite.SCALED_SIZE >= 2 * Sprite.SCALED_SIZE / 3) {
                    this.x = Sprite.SCALED_SIZE * (this.x / Sprite.SCALED_SIZE) + Sprite.SCALED_SIZE;
                } else if (this.x % Sprite.SCALED_SIZE <= Sprite.SCALED_SIZE / 3) {
                    this.x = Sprite.SCALED_SIZE * (this.x / Sprite.SCALED_SIZE);
                }
                break;
            }
        }
        setImg(Sprite.movingSprite(Sprite.bomber_look_up, Sprite.bomber_move_up1, Sprite.bomber_move_up2, this.getY(), Sprite.DEFAULT_SIZE).getFxImage());
    }

    public void goRight() {
        for (int i = 1; i <= this.speed; ++i) {
            this.x += 1;
            if (checkBounds() || checkBoundsBomb() || checkBoundsBomb()) {
                this.x -= 1;
                checkBoundsBomb();
                if (this.y % Sprite.SCALED_SIZE >= 2 * Sprite.SCALED_SIZE / 3) {
                    this.y = Sprite.SCALED_SIZE * (this.y / Sprite.SCALED_SIZE) + Sprite.SCALED_SIZE;
                } else if (this.x % Sprite.SCALED_SIZE <= Sprite.SCALED_SIZE / 3) {
                    this.y = Sprite.SCALED_SIZE * (this.y / Sprite.SCALED_SIZE);
                }
                break;
            }
        }
        setImg(Sprite.movingSprite(Sprite.bomber_look_right, Sprite.bomber_move_right1, Sprite.bomber_move_right2, this.getX(), Sprite.DEFAULT_SIZE).getFxImage());
    }

    public void goDown() {
        for (int i = 1; i <= this.speed; ++i) {
            this.y += 1;
            if (checkBounds() || checkBoundsBomb() || checkBoundsBomb()) {
                this.y -= 1;
                if (this.x % Sprite.SCALED_SIZE >= 2 * Sprite.SCALED_SIZE / 3) {
                    this.x = Sprite.SCALED_SIZE * (this.x / Sprite.SCALED_SIZE) + Sprite.SCALED_SIZE;
                } else if (this.x % Sprite.SCALED_SIZE <= Sprite.SCALED_SIZE / 3) {
                    this.x = Sprite.SCALED_SIZE * (this.x / Sprite.SCALED_SIZE);
                }
                break;
            }
        }
        setImg(Sprite.movingSprite(Sprite.bomber_look_down, Sprite.bomber_move_down1, Sprite.bomber_move_down2, this.getY(), Sprite.DEFAULT_SIZE).getFxImage());
    }

    public void goLeft() {
        for (int i = 1; i <= this.speed; ++i) {
            this.x -= 1;
            if (checkBounds() || checkBoundsBomb() || checkBoundsBomb()) {
                this.x += 1;
                if (this.y % Sprite.SCALED_SIZE >= 2 * Sprite.SCALED_SIZE / 3) {
                    this.y = Sprite.SCALED_SIZE * (this.y / Sprite.SCALED_SIZE) + Sprite.SCALED_SIZE;
                } else if (this.y % Sprite.SCALED_SIZE <= Sprite.SCALED_SIZE / 3) {
                    this.y = Sprite.SCALED_SIZE * (this.y / Sprite.SCALED_SIZE);
                }
                break;
            }
        }
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

    public void putBomb() {
        int xBomb, yBomb;
        if (getX() % Sprite.SCALED_SIZE > Sprite.SCALED_SIZE / 3) {
            xBomb = (getX() / Sprite.SCALED_SIZE) + 1;
        } else {
            xBomb = (getX() / Sprite.SCALED_SIZE);
        }

        if (getY() % Sprite.SCALED_SIZE > Sprite.SCALED_SIZE / 3) {
            yBomb = (getY() / Sprite.SCALED_SIZE) + 1;
        } else {
            yBomb = (getY() / Sprite.SCALED_SIZE);
        }

        Bomb bomb = new Bomb(xBomb, yBomb, Sprite.bomb.getFxImage());

        if (getNumBombs() >= this.bombs.size() + 1) {
            Sound.play("BOM_SET");
            this.bombs.add(bomb);
        }
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

    public boolean checkPortal() {
     for (Entity e : EntityArr.portals) {
         if (EntityArr.enemies.size() != 0) break;
         if (this.intersects(e)) {
             return true;
         }
     }
     return false;
    }

    public boolean touchDeadlyObstacle() {
        for (Entity e : EntityArr.enemies) {
            if (this.intersects(e)) return true;
        }

        return false;
    }

    protected void bomberDie() {
        this.setAlive(false);
        setImg(Sprite.movingSprite(Sprite.bomber_die, Sprite.bomber_die1, Sprite.bomber_die2
                                    , this.animate, Sprite.DEFAULT_SIZE).getFxImage());
    }

    @Override
    public boolean checkBoundsBomb() {
        for (Bomb e : EntityArr.bomberman.bombs) {
            double diffX = this.getX() - e.getX();
            double diffY = this.getY() - e.getY();
            if (!(diffX > -32 && diffX < 32 && diffY > -32 && diffY < 32)) {
                e.allowedToPassThru = false;
            }
            if (e.allowedToPassThru) return false;
            if (this.intersects(e)) return true;
        }
        return false;
    }



}
