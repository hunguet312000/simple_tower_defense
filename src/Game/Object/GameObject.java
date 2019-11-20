package Game.Object;

import java.awt.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {

    protected int pos_x, pos_y;
    protected Image image;

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public Image getImage() {
        return image;
    }


    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public enum Direction {
        LEFT(180), UP(270), RIGHT(0), DOWN(90);

        int degree;

        Direction(int i) {
            degree = i;
        }

        public int getDegree() {
            return degree;
        }
    }


}


