package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.EntityArr;
import uet.oop.bomberman.graphic.Sprite;
import uet.oop.bomberman.sound.Sound;

import java.util.*;

public class Bomb extends Entity {
    private int flameLength;
    private List<Flame> fLeft = new ArrayList<>();
    private List<Flame> fRight = new ArrayList<>();
    private List<Flame> fUp = new ArrayList<>();
    private List<Flame> fDown = new ArrayList<>();
    public List<Flame> flames = new ArrayList<>();

    private boolean isExploded = false;

    public int timerEx = 0;

    public boolean allowedToPassThru = true;

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        flameLength = EntityArr.bomberman.getFlameLength();
        if (this.isExploded()) {
            this.animate += Sprite.DEFAULT_SIZE / 10;
            this.setImg(Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1
                    , Sprite.bomb_exploded2, animate, Sprite.DEFAULT_SIZE).getFxImage());
        } else {
            this.animate += Sprite.DEFAULT_SIZE / 10;
            this.setImg(Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1
                    , Sprite.bomb_2, animate, Sprite.DEFAULT_SIZE).getFxImage());
        }
    }

    public void addFlame() {
        Flame flame;
        Sound.play("BOM_11_M");
        for (int i = 0; i < flameLength; ++i) {
            flame = new FlameV(getX() / Sprite.SCALED_SIZE, getY() / Sprite.SCALED_SIZE + 1 + i
                    , Sprite.explosion_vertical.getFxImage());
            if (!flame.checkBrick() && !flame.checkWall()) {
                fDown.add(flame);
                this.flames.add(flame);
            } else {
                break;
            }
        }

        for (int i = 0; i < flameLength; ++i) {
            flame = new FlameV(getX() / Sprite.SCALED_SIZE, getY() / Sprite.SCALED_SIZE - 1 - i
                    , Sprite.explosion_vertical.getFxImage());
            if (!flame.checkBrick() && !flame.checkWall()) {
                fUp.add(flame);
                this.flames.add(flame);
            } else {
                break;
            }
        }

        for (int i = 0; i < flameLength; ++i) {
            flame = new FlameH(getX() / Sprite.SCALED_SIZE + i + 1, getY() / Sprite.SCALED_SIZE
                    , Sprite.explosion_horizontal.getFxImage());
            if (!flame.checkBrick() && !flame.checkWall()) {
                fRight.add(flame);
                this.flames.add(flame);
            } else {
                break;
            }
        }

        for (int i = 0; i < flameLength; ++i) {
            flame = new FlameH(getX() / Sprite.SCALED_SIZE - i - 1, getY() / Sprite.SCALED_SIZE
                    , Sprite.explosion_horizontal.getFxImage());
            if (!flame.checkBrick() && !flame.checkWall()) {
                fLeft.add(flame);
                this.flames.add(flame);
            } else {
                break;
            }
        }
    }

    public int getFlameLength() {
        return flameLength;
    }

    public void setFlameLength(int flameLength) {
        this.flameLength = flameLength;
    }

    public boolean isExploded() {
        return isExploded;
    }

    public void setExploded(boolean exploded) {
        isExploded = exploded;
    }

    public List<Flame> getfLeft() {
        return fLeft;
    }

    public List<Flame> getfRight() {
        return fRight;
    }

    public List<Flame> getfUp() {
        return fUp;
    }

    public List<Flame> getfDown() {
        return fDown;
    }

    public void setTimeExploded() {
        Bomb bomb = this;

        TimerTask bombExplode = new TimerTask() {
            @Override
            public void run() {
                bomb.setExploded(true);
            }
        };

        if (!this.isExploded()) {
            Timer timerEx = new Timer();
            timerEx.schedule(bombExplode, 2000);
        }

        TimerTask removeFlame = new TimerTask() {
            @Override
            public void run() {
                EntityArr.removeBrick();
                EntityArr.removeBomb();
                EntityArr.removeEnemy();
            }
        };

        Timer timer = new Timer();
        timer.schedule(removeFlame, 2500L);
    }
}