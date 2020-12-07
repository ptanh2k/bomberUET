package uet.oop.bomberman.entities;

import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.Flame;
import uet.oop.bomberman.entities.enemy.Balloom;
import uet.oop.bomberman.entities.enemy.Enemy;
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
    public static List<Item> items = new ArrayList<>();
    public static Bomber bomberman = new Bomber(1, 1, Sprite.bomber_look_right.getFxImage());
    public static List<Enemy> enemies = new ArrayList<>();

    public static void removeEnemy() {
        Iterator<Enemy> enemyIterator = enemies.listIterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            if (!enemy.isAlive()) enemyIterator.remove();
        }
    }

    public static void removeBrick() {
        Iterator<Brick> brickIterator = bricks.listIterator();
        while (brickIterator.hasNext()) {
            Brick brick = brickIterator.next();
            if (brick.isBroken()) brickIterator.remove();
        }
    }

    public static void removeBomb() {
        Iterator<Bomb> bombIterator = bomberman.bombs.listIterator();
        while (bombIterator.hasNext()) {
            Bomb bomb = bombIterator.next();
            if (bomb.isExploded()) bombIterator.remove();
        }
    }

    public static void clearArr() {
        bombers.clear();
        grasses.clear();
        bricks.clear();
        walls.clear();
        items.clear();
        portals.clear();
        enemies.clear();
    }
}
