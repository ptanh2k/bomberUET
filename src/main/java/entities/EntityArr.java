package entities;

import entities.blocks.Brick;
import entities.blocks.Grass;
import entities.blocks.Portal;
import entities.blocks.Wall;
import entities.enemy.Balloom;
import entities.enemy.Oneal;
import entities.item.Item;
import graphic.Sprite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityArr {
    public static List<Bomber> bombers = new ArrayList<>();
    public static List<Grass> grasses = new ArrayList<>();
    public static List<Wall> walls = new ArrayList<>();
    public static List<Brick> bricks = new ArrayList<>();
    public static List<Portal> portals = new ArrayList<>();
    public static List<Balloom> balloms = new ArrayList<>();
    public static List<Oneal> oneals = new ArrayList<>();
    public static List<Item> items = new ArrayList<>();
    public static Bomber bomberman = new Bomber(1, 1, Sprite.bomber_look_right.getFxImage());

    public static void removeEnemy() {
        Iterator<Balloom> balloomIterator = balloms.listIterator();
        Iterator<Oneal> onealIterator = oneals.listIterator();

        while (balloomIterator.hasNext()) {
            Balloom balloom = balloomIterator.next();
            if (!balloom.isAlive()) balloomIterator.remove();
        }

        while (onealIterator.hasNext()) {
            Oneal oneal = onealIterator.next();
            if (!oneal.isAlive()) onealIterator.remove();
        }
    }
}


