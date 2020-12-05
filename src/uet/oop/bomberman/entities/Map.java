package uet.oop.bomberman.entities;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.blocks.Grass;
import uet.oop.bomberman.entities.blocks.Portal;
import uet.oop.bomberman.entities.blocks.Wall;
import uet.oop.bomberman.entities.enemy.Balloom;
import uet.oop.bomberman.entities.enemy.Oneal;
import uet.oop.bomberman.graphic.Sprite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Map {

    public static void createMapByLevel(int level) {
        EntityArr.bombers.add(EntityArr.bomberman);
        try {
            String path = "resources/levels/Level" + level + ".txt";
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line = buffReader.readLine().trim();
            String[] str = line.split(" ");
            BombermanGame.HEIGHT = Integer.parseInt(str[1]);
            BombermanGame.WIDTH = Integer.parseInt(str[2]);
            char [][] maps = new char[BombermanGame.HEIGHT][BombermanGame.WIDTH];

            for (int i = 0; i < BombermanGame.HEIGHT; ++i) {
                line = buffReader.readLine();
                for (int j = 0; j < BombermanGame.WIDTH; ++j) {
                    maps[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < BombermanGame.WIDTH; ++i) {
                for (int j = 0 ; j < BombermanGame.HEIGHT; ++j) {
                    Brick brick;
                    Entity object;
                    Balloom balloom;
                    Oneal oneal;
                    // create wall and grass
                    if (j == 0 || j == BombermanGame.HEIGHT - 1 || i == 0 || i == BombermanGame.WIDTH - 1 || maps[j][i] == '#') {
                        object = new Wall(i, j, Sprite.wall.getFxImage());
                        EntityArr.walls.add(object);
                    } else {
                        object = new Grass(i, j, Sprite.grass.getFxImage());
                        EntityArr.grasses.add(object);
                    }
                    // create portal
                    if (maps[j][i] == 'x') {
                        object = new Portal(i, j, Sprite.portal.getFxImage());
                        EntityArr.grasses.add(object);
                    }
                    // create brick
                    if (maps[j][i] == 'x' || maps[j][i] == '*') {
                        brick = new Brick(i, j, Sprite.brick.getFxImage());
                        EntityArr.bricks.add(brick);
                    } else if (maps[j][i] == '1') {
                        balloom = new Balloom(i, j, Sprite.baloom_left1.getFxImage());
                        EntityArr.ballooms.add(balloom);
                    } else if (maps[j][i] == '2') {
                        oneal = new Oneal(i, j, Sprite.oneal_right1.getFxImage());
                        EntityArr.oneals.add(oneal);
                    }
                }
            }
            fileReader.close();
            buffReader.close();
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
        }
    }
}
