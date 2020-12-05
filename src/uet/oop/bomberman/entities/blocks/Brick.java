package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.EntityArr;
import uet.oop.bomberman.entities.item.BombItem;
import uet.oop.bomberman.entities.item.FlameItem;
import uet.oop.bomberman.entities.item.Item;
import uet.oop.bomberman.entities.item.SpeedItem;
import uet.oop.bomberman.graphic.Sprite;

import java.util.Random;


public class Brick extends Entity {
    private boolean isBroken = false;
    private Item item;

    public Brick(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        item = randomItem();
        if (item != null){
            EntityArr.items.add(item);
        }
    }

    @Override
    public void update() {
        if (isBroken) {
            if (item != null) {
                item.setVisible(true);
            }
            this.animate += Sprite.DEFAULT_SIZE / 10;
            this.setImg(Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1
                    , Sprite.brick_exploded2, animate, Sprite.DEFAULT_SIZE).getFxImage());
        }
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public boolean isBroken() {
        return isBroken;
    }

    private Item randomItem() {
        Random random = new Random();
        int num = random.nextInt(8);
        switch (num) {
            case 1:
                return new BombItem(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE
                        , Sprite.powerup_bombs.getFxImage());
            case 2:
                return new FlameItem(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE
                        , Sprite.powerup_flames.getFxImage());
            case 3:
                return new SpeedItem(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE
                        , Sprite.powerup_speed.getFxImage());
            default:
                return null;
        }
    }
}