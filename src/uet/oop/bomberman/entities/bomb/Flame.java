package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.EntityArr;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.enemy.Enemy;
import uet.oop.bomberman.graphic.Sprite;
import uet.oop.bomberman.sound.Sound;

public abstract class Flame extends Entity {
    private boolean isVisible = true;
    public Flame(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        checkEnemy();
        checkBomber();
        checkBoundsBomb();
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    protected boolean checkWall() {
        for (Entity w : EntityArr.walls) {
            if (this.getX() == w.getX() && this.getY() == w.getY()) {
                this.setVisible(false);
                return true;
            }
        }
        return false;
    }

    protected boolean checkBrick() {
        for (Brick b : EntityArr.bricks) {
            if (this.getX() == b.getX() && this.getY() == b.getY()) {
                this.setVisible(false);
                b.setBroken(true);
                return true;
            }
        }
        return false;
    }

    protected void checkEnemy() {
        for (Enemy e : EntityArr.enemies) {
            if (this.intersects(e)) {
                e.setAlive(false);
            }
        }
    }

    protected void checkBomber() {
        for (Bomber b : EntityArr.bombers) {
            if (this.intersects(b)) {
                b.setAlive(false);
                Sound.play("endgame3");
                BombermanGame.gameOver = true;
                setImg(Sprite.movingSprite(Sprite.bomber_die, Sprite.bomber_die1, Sprite.bomber_die2
                        , this.animate, Sprite.DEFAULT_SIZE).getFxImage());
                Map.createMapByLevel(BombermanGame.level);
            }
        }
    }
}