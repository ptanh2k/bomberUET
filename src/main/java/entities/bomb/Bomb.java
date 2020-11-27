package entities.bomb;

 import entities.Entity;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity {

    private boolean explode = false;

    private List<Flame> fUp = new ArrayList<>();
    private List<Flame> fRight = new ArrayList<>();
    private List<Flame> fDown = new ArrayList<>();
    private List<Flame> fLeft = new ArrayList<>();
    private  List<Flame> flames = new ArrayList<>();

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {

    }


}
