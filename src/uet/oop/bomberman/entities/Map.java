package uet.oop.bomberman.entities;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.blocks.Grass;
import uet.oop.bomberman.entities.blocks.Portal;
import uet.oop.bomberman.entities.blocks.Wall;
import uet.oop.bomberman.entities.enemy.*;
import uet.oop.bomberman.graphic.Sprite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Map {

    public static void createMapByLevel(int level) {
        EntityArr.clearArr();
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
                    Portal portal;
                    Entity object;
                    Balloom balloom;
                    Oneal oneal;
                    Doll doll;
                    Minvo minvo;
                    Kondoria kondoria;
                    BomberFake bomberFake;
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
                        portal = new Portal(i, j, Sprite.portal.getFxImage());
                        EntityArr.portals.add(portal);
                    }
                    // create brick
                    if (maps[j][i] == 'x' || maps[j][i] == '*') {
                        brick = new Brick(i, j, Sprite.brick.getFxImage());
                        EntityArr.bricks.add(brick);
                    } else if (maps[j][i] == '1') {
                        balloom = new Balloom(i, j, Sprite.baloom_left1.getFxImage());
                        EntityArr.enemies.add(balloom);
                    } else if (maps[j][i] == '2') {
                        oneal = new Oneal(i, j, Sprite.oneal_right1.getFxImage());
                        EntityArr.enemies.add(oneal);
                    } else if (maps[j][i] == '3') {
                        doll = new Doll(i, j, Sprite.doll_left2.getFxImage());
                        EntityArr.enemies.add(doll);
                    } else if (maps[j][i] == '4') {
                        minvo = new Minvo(i, j, Sprite.minvo_right2.getFxImage());
                        EntityArr.enemies.add(minvo);
                    } else if (maps[j][i] == '5') {
                        kondoria = new Kondoria(i, j, Sprite.kondoria_right1.getFxImage());
                        EntityArr.enemies.add(kondoria);
                    } else if (maps[j][i] == '6') {
                        bomberFake = new BomberFake(i, j, Sprite.bomber_look_right.getFxImage());
                        EntityArr.enemies.add(bomberFake);
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
