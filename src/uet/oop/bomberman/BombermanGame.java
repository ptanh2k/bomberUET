package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.EntityArr;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.Flame;
import uet.oop.bomberman.entities.enemy.Enemy;
import uet.oop.bomberman.graphic.Sprite;
import uet.oop.bomberman.sound.Sound;

import java.io.IOException;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class BombermanGame extends Application {

    public static int WIDTH = 20;
    public static int HEIGHT = 15;

    private GraphicsContext gc;
    private Canvas canvas;

    public static int level = 1;

    public static boolean gameOver = false;

    public static void main(String[] args) {
        Sound.play("soundtrack");
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Tao Canvas
        Map.createMapByLevel(1);
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        /**
         * Hanh dong cua bomber
         */
        scene.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("RIGHT")) {
                EntityArr.bomberman.goRight();
            } else if (event.getCode().toString().equals("LEFT")) {
                EntityArr.bomberman.goLeft();
            } else if (event.getCode().toString().equals("UP")) {
                EntityArr.bomberman.goUp();
            } else if (event.getCode().toString().equals("DOWN")) {
                EntityArr.bomberman.goDown();
            }

            //For testing
            else if (event.getCode().toString().equals("C")) {
                EntityArr.enemies.clear();
            }
            // Place bomb
            else if (event.getCode().toString().equals("SPACE")) {
                Sound.play("BOM_SET");
                Bomb bomb = new Bomb(EntityArr.bomberman.getX() / Sprite.SCALED_SIZE
                        , EntityArr.bomberman.getY() / Sprite.SCALED_SIZE, Sprite.bomb.getFxImage());
                boolean duplicate = false;
                for (Bomb b : EntityArr.bomberman.bombs) {
                    if (b.getX() == bomb.getX() && b.getY() == bomb.getY()) {
                        duplicate = true;
                    }
                }

                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        bomb.setImg(Sprite.bomb_exploded.getFxImage());
                        bomb.setExploded(true);
                        bomb.addFlame();
                    }
                };
                TimerTask timerTask1 = new TimerTask() {
                    @Override
                    public void run() {
                        Iterator<Brick> brickIterator = EntityArr.bricks.listIterator();
                        while (brickIterator.hasNext()) {
                            Brick brick = brickIterator.next();
                            if (brick.isBroken()) {
                                brickIterator.remove();
                            }
                        }
                        EntityArr.bomberman.removeBomb(bomb);
                        EntityArr.removeEnemy();
                    }
                };
                if (!duplicate && EntityArr.bomberman.getNumBombs() >= EntityArr.bomberman.bombs.size() + 1) {
                    EntityArr.bomberman.bombs.add(bomb);
                    Timer timerEx = new Timer();
                    timerEx.schedule(timerTask, 2000);
                    Timer timerRev = new Timer();
                    timerRev.schedule(timerTask1, 3000L);
                }
            }
        });

//        if (gameOver) {
//            ActionEvent event = new ActionEvent();
//            Stage end_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/fxml/EndGame.fxml"));
//            Parent EndGameUI = loader.load();
//            Scene end_scene = new Scene(EndGameUI);
//            end_stage.setScene(end_scene);
//            end_stage.show();
//        }
    }

    // update
    public void update() {
        EntityArr.bomberman.update();
        EntityArr.enemies.forEach(Enemy::update);
        EntityArr.bomberman.bombs.forEach(Bomb::update);
        EntityArr.bricks.forEach(Brick::update);
        // update flame
        EntityArr.bomberman.bombs.forEach(g -> g.getfUp().forEach(Flame::update));
        EntityArr.bomberman.bombs.forEach(g -> g.getfDown().forEach(Flame::update));
        EntityArr.bomberman.bombs.forEach(g -> g.getfLeft().forEach(Flame::update));
        EntityArr.bomberman.bombs.forEach(g -> g.getfRight().forEach(Flame::update));
        // Update item
        EntityArr.items.forEach(g -> {
            if (g.isVisible()) g.update();
        });
        EntityArr.portals.forEach(Entity::update);
    }

    // vẽ
    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        EntityArr.grasses.forEach(g -> g.render(gc));
        EntityArr.items.forEach(g -> {
            if (g.isVisible()) {
                g.render(gc);
            }
        });
        EntityArr.walls.forEach(g -> g.render(gc));
        EntityArr.portals.forEach(g -> g.render(gc));
        EntityArr.bricks.forEach(g -> g.render(gc));
        EntityArr.enemies.forEach(g -> {
            if (g.isAlive()) g.render(gc);
        });
        EntityArr.bomberman.bombs.forEach(g -> g.render(gc));
        EntityArr.bombers.forEach(g -> g.render(gc));
        EntityArr.bomberman.bombs.forEach(g -> g.flames.forEach(g1 -> g1.render(gc)));
    }

}