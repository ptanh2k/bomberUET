package entities.enemy;

import graphic.Sprite;
import javafx.scene.image.Image;

public class Balloom extends Enemy {
    public Balloom(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (isAlive()) {
            if (checkBounds()) {
                this.setSpeed(getSpeed() * (-1));
            }

            if (this.getSpeed() > 0) {
                this.x += this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.baloom_right1, Sprite.baloom_right2, Sprite.baloom_right3
                            , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            } else {
                this.x += this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.baloom_left1, Sprite.baloom_left2, Sprite.baloom_left3
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            }
        } else {
            this.img = Sprite.baloom_die.getFxImage();
        }
    }
}
