package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.EntityArr;
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.enemy.Balloom;
import uet.oop.bomberman.entities.enemy.Oneal;


public abstract class Flame extends Entity {
    private boolean isVisible = true;
    public Flame(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public abstract void update();

    public boolean isVisible() {
        return isVisible;
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
        for (Balloom b : EntityArr.ballooms) {
            if (this.intersects(b)) {
                b.setAlive(false);
            }
        }
        for (Oneal b : EntityArr.oneals) {
            if (this.intersects(b)) {
                b.setAlive(false);
            }
        }
    }

    protected void checkBomber() {
        for (Bomber b : EntityArr.bombers) {
            if (this.intersects(b)) {
                b.setAlive(false);
            }
        }
    }
}