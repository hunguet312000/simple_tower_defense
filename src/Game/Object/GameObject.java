package Game.Object;

import java.awt.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {

    protected double PosX , PosY;
    private int height , width;
    private Image image;

    public GameObject ( double PosX , double PosY , Image image ){
        this.PosX = PosX;
        this.PosY = PosY;
        this.image = image;
        height = (int) image.getHeight();
        width = (int) image.getWidth();
    }

    public double getPosX() {
        return PosX;
    }

    public double getPosY() {
        return PosY;
    }

    public Image getImage (){
        return image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setPosX ( double PosX) { this.PosX = PosX;}
    public  void setPosY ( double PosY ) {this.PosY = PosY;}
    public void setImage ( Image image ){this.image = image;}

    public void draw ( GraphicsContext gc ){ gc.drawImage( getImage() , getPosX() , getPosY() );}
}

