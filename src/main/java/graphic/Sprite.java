package graphic;

import javax.swing.*;

public class Sprite {
    public static final int DEFAULT_SIZE = 16;
    public static final int SCALED_SIZE = DEFAULT_SIZE * 2;
    public final int SIZE;
    public int[] _pixels;

    protected int _realWidth;
    protected int _realHeight;

    private int _x, _y;
    private SpriteSheet _sheet;

    private static final int TRANSPARENT_COLOR = 0xffff00ff;

    public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        _x = x * SIZE;
        _y = y * SIZE;
        _sheet = sheet;
        _realHeight = rh;
        _realWidth = rw;
        load();
    }


    public Sprite(int size, int color) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    private void setColor(int color) {

    }

    public int getSize() {
        return SIZE;
    }

    public int getPixel(int i) {
        return _pixels[i];
    }

    /*
	|--------------------------------------------------------------------------
	| Board sprites
	|--------------------------------------------------------------------------
	 */
    public static Sprite portal = new Sprite(DEFAULT_SIZE, 4, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite wall = new Sprite(DEFAULT_SIZE, 5, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite grass = new Sprite(DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite brick = new Sprite(DEFAULT_SIZE, 7, 0, SpriteSheet.tiles, 16, 16);

    /*
	|--------------------------------------------------------------------------
	| Bomber Sprites
	|--------------------------------------------------------------------------
	 */
    public static Sprite bomber_look_up = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_look_right = new Sprite(DEFAULT_SIZE, 1, 0, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_look_down = new Sprite(DEFAULT_SIZE, 2, 0, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_look_left = new Sprite(DEFAULT_SIZE, 3, 0, SpriteSheet.tiles, 14, 16);

    public static Sprite bomber_move_up_1 = new Sprite(DEFAULT_SIZE, 0, 1, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_move_right_1 = new Sprite(DEFAULT_SIZE, 1, 1, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_move_down_1 = new Sprite(DEFAULT_SIZE, 2, 1, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_move_left_1 = new Sprite(DEFAULT_SIZE, 3, 1, SpriteSheet.tiles, 14, 16);

    public static Sprite bomber_move_up_2 = new Sprite(DEFAULT_SIZE, 0, 2, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_move_right_2 = new Sprite(DEFAULT_SIZE, 1, 2, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_move_down_2 = new Sprite(DEFAULT_SIZE, 2, 2, SpriteSheet.tiles, 14, 16);
    public static Sprite bomber_move_left_2 = new Sprite(DEFAULT_SIZE, 3, 2, SpriteSheet.tiles, 14, 16);

    /*
	|--------------------------------------------------------------------------
	| Character
	|--------------------------------------------------------------------------
	 */
    //BALLOM


    //ONEAL


    private void load() {

    }
}
