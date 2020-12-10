package uet.oop.bomberman.entities.enemy;

import uet.oop.bomberman.graphic.Sprite;
import javafx.scene.image.Image;

public class BomberFake extends Enemy {
    public BomberFake(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (isAlive()) {
            if (checkBoundsWall() || checkBoundsBomb() || checkBoundsBrick()) {
                this.setSpeed(getSpeed() * (-1));
            }
            if (this.getSpeed() > 0) {
                this.x += this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.bomber_look_right, Sprite.bomber_move_right1, Sprite.bomber_move_right2
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            } else {
                this.x += this.getSpeed();
                this.img = Sprite.movingSprite(Sprite.bomber_look_left, Sprite.bomber_move_left1, Sprite.bomber_move_left2
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            }
        } else {
            setImg(Sprite.movingSprite(Sprite.bomber_die, Sprite.bomber_die1, Sprite.bomber_die2
                    , this.x, Sprite.DEFAULT_SIZE).getFxImage());
        }
    }
}