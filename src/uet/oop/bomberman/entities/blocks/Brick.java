package uet.oop.bomberman.entities.blocks;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.item.Item;
import javafx.scene.image.Image;

public class Brick extends Entity {
    private boolean isDestroyed = false;
    private Item item;

    public Brick(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);

    }

    @Override
    public void update() {

    }
}
