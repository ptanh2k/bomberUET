package uet.oop.bomberman.entities.enemy;

import uet.oop.bomberman.entities.EntityArr;
import uet.oop.bomberman.graphic.Sprite;
import javafx.scene.image.Image;

public class BomberFake extends Enemy {
    public BomberFake(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (isAlive()) {
            int distanceX = Math.abs(getX() - EntityArr.bomberman.getX());
            int distanceY = Math.abs(getY() - EntityArr.bomberman.getY());
            if (this.getSpeedX() == 0) {
                this.y += this.getSpeedY();
                if (distanceX <= Sprite.SCALED_SIZE * 5 && distanceY <= Sprite.SCALED_SIZE * 5) {
                    this.chaseBomber();
                    if (checkBoundsBomb() || checkBoundsWall()) {
                        this.y -= this.getSpeedY();
                        this.chaseBomber();
                    }
                } else
                if (checkBoundsBomb() || checkBoundsWall() || getY() % Sprite.SCALED_SIZE == 0) {
                    if (checkBoundsBomb() || checkBoundsWall()) {
                        this.y -= this.getSpeedY();
                    }
                    this.randomDirection();
                    this.randomSpeed();
                }
            } else {
                this.x += this.getSpeedX();
                if (distanceX <= Sprite.SCALED_SIZE * 5 && distanceY <= Sprite.SCALED_SIZE * 5) {
                    this.chaseBomber();
                    if (checkBoundsBomb() || checkBoundsWall()) {
                        this.x -= this.getSpeedX();
                        this.chaseBomber();
                    }
                } else
                if (checkBoundsBomb() || checkBoundsWall() || getX() % Sprite.SCALED_SIZE == 0) {
                    if (checkBoundsBomb() || checkBoundsWall()) {
                        this.x -= this.getSpeedX();
                    }
                    this.randomDirection();
                    this.randomSpeed();
                }
            }
        } else {
            this.setImg(Sprite.movingSprite(Sprite.bomber_die, Sprite.bomber_die1, Sprite.bomber_die2
                    , this.animate, Sprite.DEFAULT_SIZE).getFxImage());
        }
        if (isAlive()) {
            if (this.getSpeedX() > 0) {
                this.img = Sprite.movingSprite(Sprite.bomber_look_right, Sprite.bomber_move_right1, Sprite.bomber_move_right2
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            } else if (this.getSpeedX() < 0){
                this.img = Sprite.movingSprite(Sprite.bomber_look_left, Sprite.bomber_move_left1, Sprite.bomber_move_left2
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            } else if (this.getSpeedY() > 0) {
                this.img = Sprite.movingSprite(Sprite.bomber_look_down, Sprite.bomber_move_down1, Sprite.bomber_move_down2
                        , this.y, Sprite.DEFAULT_SIZE).getFxImage();
            } else {
                this.img = Sprite.movingSprite(Sprite.bomber_look_up, Sprite.bomber_move_up1, Sprite.bomber_move_up2
                        , this.y, Sprite.DEFAULT_SIZE).getFxImage();
            }
        } else {
            this.setImg(Sprite.movingSprite(Sprite.bomber_die, Sprite.bomber_die1, Sprite.bomber_die2
                    , this.animate, Sprite.DEFAULT_SIZE).getFxImage());
        }
    }
}