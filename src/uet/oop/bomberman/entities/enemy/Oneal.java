package uet.oop.bomberman.entities.enemy;

import uet.oop.bomberman.entities.EntityArr;
import uet.oop.bomberman.graphic.Sprite;
import javafx.scene.image.Image;

public class Oneal extends Enemy {
    public Oneal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (isAlive()) {
            int distanceX = Math.abs(getX() - EntityArr.bomberman.getX());
            int distanceY = Math.abs(getY() - EntityArr.bomberman.getY());
            if (this.getSpeedX() == 0) {
                this.y += this.getSpeedY();
                if (distanceX <= Sprite.SCALED_SIZE * 3 && distanceY <= Sprite.SCALED_SIZE * 3) {
                    this.chaseBomber();
                    if (checkBoundsBrick() || checkBoundsBomb() || checkBoundsWall()) {
                        this.y -= this.getSpeedY();
                        this.chaseBomber();
                    }
                } else
                if (checkBoundsBrick() || checkBoundsBomb() || checkBoundsWall() || getY() % Sprite.SCALED_SIZE == 0) {
                    if (checkBoundsBrick() || checkBoundsBomb() || checkBoundsWall()) {
                        this.y -= this.getSpeedY();
                    }
                    this.randomDirection();
                    this.randomSpeed();
                }
            } else {
                this.x += this.getSpeedX();
                if (distanceX <= Sprite.SCALED_SIZE * 3 && distanceY <= Sprite.SCALED_SIZE * 3) {
                    this.chaseBomber();
                    if (checkBoundsBrick() || checkBoundsBomb() || checkBoundsWall()) {
                        this.x -= this.getSpeedX();
                        this.chaseBomber();
                    }
                } else
                if (checkBoundsBrick() || checkBoundsBomb() || checkBoundsWall() || getX() % Sprite.SCALED_SIZE == 0) {
                    if (checkBoundsBrick() || checkBoundsBomb() || checkBoundsWall()) {
                        this.x -= this.getSpeedX();
                    }
                    this.randomDirection();
                    this.randomSpeed();
                }
            }
        } else {
            this.setImg(Sprite.movingSprite(Sprite.enemy_die1, Sprite.enemy_die2, Sprite.enemy_die3
                    , this.animate, Sprite.DEFAULT_SIZE).getFxImage());
        }
        if (isAlive()) {
            if (this.getSpeedX() > 0) {
                this.img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            } else if (this.getSpeedX() < 0){
                this.img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3
                        , this.x, Sprite.DEFAULT_SIZE).getFxImage();
            } else if (this.getSpeedY() > 0) {
                this.img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3
                        , this.y, Sprite.DEFAULT_SIZE).getFxImage();
            } else {
                this.img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3
                        , this.y, Sprite.DEFAULT_SIZE).getFxImage();
            }
        } else {
            this.img = Sprite.oneal_die.getFxImage();
        }
    }
}
