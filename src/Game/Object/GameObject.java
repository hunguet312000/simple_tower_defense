package Game.Object;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameObject extends Pane {

    protected double pos_x, pos_y;
    protected Bounds bounds;
    protected ImageView imageView;

    public GameObject(){}

    public double getPos_x() {
        return imageView.getTranslateX();
    }

    public double getPos_y() { return imageView.getTranslateY();}

    public ImageView getImageView() {
        return imageView;
    }

    public void eraseImage(){
        imageView.setDisable(true);
        imageView.setVisible(false);
        imageView = null;
    }
}


