package graphic;

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
        _sheet = sheet;
        _realHeight = rh;
        _realWidth = rw;
        load();
    }


    public Sprite(int size, int color) {
        SIZE = size;

    }

    private void setColor(int color) {

    }

    private void load() {

    }

    /*
	|--------------------------------------------------------------------------
	| Board sprites
	|--------------------------------------------------------------------------
	 */
    public static Sprite grass = new Sprite(DEFAULT_SIZE, )
}
