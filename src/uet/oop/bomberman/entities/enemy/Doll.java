package uet.oop.bomberman.entities.enemy;

import uet.oop.bomberman.graphic.Sprite;
import javafx.scene.image.Image;

public class Doll extends Enemy {
    public Doll(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (isAlive()) {
            if (checkBoundsWall() || checkBoundsBomb() || checkBoundsBrick()) {
                this.setSpeed(getSpeed() * (-1));
            }
            if (this.getSpeed() > 0) {
                this.y -= this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2
                        , Sprite.doll_right3, this.y, Sprite.DEFAULT_SIZE).getFxImage();
            } else {
                this.y -= this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2
                        , Sprite.doll_left3, this.y, Sprite.DEFAULT_SIZE).getFxImage();
            }
        } else {
            this.img = Sprite.doll_die.getFxImage();
        }
    }
}
