package uet.oop.bomberman.entities.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.EntityArr;

public class BombItem extends Item {
    public BombItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (checkBoundBomber()) {
            this.isVisible = false;
            EntityArr.bombers.forEach(b -> b.setNumBombs(b.getNumBombs() + 1));
        }
    }
}
