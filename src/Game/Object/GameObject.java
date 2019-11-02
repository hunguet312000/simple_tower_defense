package Game.Object;

import java.awt.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {

    protected double PosX , PosY;
    private Image image;

    public GameObject(){
        this.PosX = PosX;
        this.PosY = PosY;
        this.image = image;
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


    public void setPosX ( double PosX) { this.PosX = PosX;}
    public  void setPosY ( double PosY ) {this.PosY = PosY;}
    public void setImage ( Image image ){this.image = image;}

}
