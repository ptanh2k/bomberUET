package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphic.Sprite;

public class Minvo extends Enemy {
    public Minvo(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (isAlive()) {
            if (checkBounds2() || checkBoundsBomb()) {
                this.setSpeed(getSpeed() * (-1));
            }
            if (this.getSpeed() > 0) {
                this.x += this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.minvo_right1, Sprite.minvo_right2
                        , Sprite.minvo_right3, this.x, Sprite.DEFAULT_SIZE).getFxImage();
            } else {
                this.x += this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.minvo_left1, Sprite.minvo_left2
                        , Sprite.minvo_left3, this.x, Sprite.DEFAULT_SIZE).getFxImage();
            }
        } else {
            this.img = Sprite.minvo_die.getFxImage();
        }
    }
}
