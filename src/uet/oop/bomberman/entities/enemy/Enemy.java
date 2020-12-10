package uet.oop.bomberman.entities.enemy;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphic.Sprite;
import javafx.scene.image.Image;

public abstract class Enemy extends Entity {
    private double speed = Sprite.DEFAULT_SIZE / 10;
    private boolean isAlive = true;

    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public abstract void update();

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
