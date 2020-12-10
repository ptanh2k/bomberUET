package uet.oop.bomberman.entities.enemy;

import uet.oop.bomberman.graphic.Sprite;
import javafx.scene.image.Image;

public class Oneal extends Enemy {
    public Oneal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (isAlive()) {
            if (checkBoundsWall() || checkBoundsBomb() || checkBoundsBrick()) {
                this.setSpeed(getSpeed() * (-1.00001));
            }
            if (this.getSpeed() > 0) {
                this.x += this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            } else {
                this.x += this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            }
        } else {
            this.img = Sprite.movingSprite(Sprite.oneal_die, Sprite.enemy_die1, Sprite.enemy_die2, this.animate, Sprite.DEFAULT_SIZE).getFxImage();
        }
    }
}
