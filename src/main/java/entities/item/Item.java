package entities.item;

import entities.Entity;
import javafx.scene.image.Image;

public abstract class Item extends Entity {
    protected boolean isVisible = false;

    public Item(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public abstract void update();

    protected boolean checkBoundBomber() {

    }
}
