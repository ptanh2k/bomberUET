package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphic.Sprite;

public class Kondoria extends Enemy {
    public Kondoria(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (isAlive()) {
            if (checkBounds2() || checkBoundsBomb()) {
                this.setSpeed(getSpeed() * (-1));
            }
            if (this.getSpeed() > 0) {
                this.y -= this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.kondoria_right1, Sprite.kondoria_right2
                        , Sprite.kondoria_right3, this.y, Sprite.DEFAULT_SIZE).getFxImage();
            } else {
                this.y -= this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.kondoria_left1, Sprite.kondoria_left2
                        , Sprite.kondoria_left3, this.y, Sprite.DEFAULT_SIZE).getFxImage();
            }
        } else {
            this.img = Sprite.kondoria_die.getFxImage();
        }
    }
}
