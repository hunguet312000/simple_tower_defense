package Game.Enemy;

import Game.Object.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import Game.Object.UpdatableObject;


public abstract class BaseEnemy <Direction> extends GameObject implements UpdatableObject {
    protected Image image;
    protected int i , j , pos_x , pos_y;
      protected double speed;
      protected double dam , health;
}
