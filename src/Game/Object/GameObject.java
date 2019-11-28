package Game.Object;

import java.awt.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {

    protected int pos_x, pos_y;
    protected Image image;
    protected int height, width;
    protected Direction direction;

    public GameObject ( int pos_x , int pos_y ){
         this.pos_x = pos_x;
         this.pos_y = pos_y;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public Image getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public void setWidth(int width ) {
        width= (int) image.getWidth();
    }

    public void setHeight(int height) {
        height = (int) image.getHeight();
    }

    public enum Direction {
        LEFT(180), UP(270), RIGHT(0), DOWN(90) , RD ( 45);

        int degree;

        Direction(int i) {
            degree = i;
        }

        public int getDegree() {
            return degree;
        }
    }

}


