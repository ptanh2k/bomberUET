package uet.oop.bomberman.entities;

import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.enemy.Balloom;
import uet.oop.bomberman.entities.enemy.Oneal;
import uet.oop.bomberman.entities.item.Item;
import uet.oop.bomberman.graphic.Sprite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityArr {
    public static List<Bomber> bombers = new ArrayList<>();
    public static List<Entity> grasses = new ArrayList<>();
    public static List<Entity> walls = new ArrayList<>();
    public static List<Brick> bricks = new ArrayList<>();
    public static List<Entity> portals = new ArrayList<>();
    public static List<Balloom> balloms = new ArrayList<>();
    public static List<Oneal> oneals = new ArrayList<>();
    public static List<Item> items = new ArrayList<>();
    public static Bomber bomberman = new Bomber(1, 1, Sprite.bomber_look_right.getFxImage());
//    public static List<Flame> flames = new ArrayList<>();

    public static void removeEnemy() {
        Iterator<Balloom> balloomIterator = balloms.listIterator();
        Iterator<Oneal> onealIterator = oneals.listIterator();
        while (balloomIterator.hasNext()) {
            Balloom balloom = balloomIterator.next();
            if (!balloom.isAlive()) balloomIterator.remove();
        }
        while (onealIterator.hasNext()) {
            Oneal oneal = onealIterator.next();
            if (!oneal.isAlive()) balloomIterator.remove();
        }
    }
}
