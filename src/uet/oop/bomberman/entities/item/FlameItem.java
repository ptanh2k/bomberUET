package uet.oop.bomberman.entities.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.EntityArr;

public class FlameItem extends Item {
    public FlameItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if (checkBoundBomber()) {
            this.isVisible = false;
            EntityArr.bomberman.setFlameLength(EntityArr.bomberman.getFlameLength() + 1);
        }
    }
}
