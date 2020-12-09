package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphic.Sprite;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;

    protected int animate;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
        this.animate = this.x;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }

    public boolean intersects(Entity e) {
        return e.getBoundary().intersects(this.getBoundary());
    }

    public boolean checkBounds() {
        for (Entity e : EntityArr.walls) {
            if (this.intersects(e)) return true;
        }

        for (Entity e : EntityArr.bricks) {
            if (this.intersects(e)) return true;
        }
        return false;
    }

    public boolean checkBoundsBomb() {
        for (Entity e : EntityArr.bomberman.bombs) {
            if (this.intersects(e)) return true;
        }
        return false;
    }

//    public boolean checkBombForBomber() {
//
//    }
}