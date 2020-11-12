package graphic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Tất cả sprite (hình ảnh game) được lưu trữ vào một ảnh duy nhất
 * Class này giúp lấy ra các sprite riêng từ 1 ảnh chung duy nhất đó
 */
public class SpriteSheet {

    private String _path;

    public final int SIZE;
    public int[] _pixels;
    public BufferedImage image;

    public SpriteSheet(String path, int size) {
        _path = path;
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            URL url = SpriteSheet.class.getResource(_path);
            image = ImageIO.read(url);
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, _pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
