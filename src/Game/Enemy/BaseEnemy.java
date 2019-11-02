package Game.Enemy;

import Game.Object.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import Game.Object.UpdatableObject;

public class BaseEnemy extends GameObject implements UpdatableObject {

    private Image Soliders ;
    private double X , Y , speed = 2;
    private int health , money;
    private long lastAniTime, lastMoveTime;


    public BaseEnemy (){
        super();
        setImage( new Image("file:Source/Enemy/Soliders/towerDefense_tile245.png"));
        setPosX(7.5*64);
        setPosY(0);
        X = getPosX();
        Y = getPosY();
        lastAniTime = lastMoveTime = System.currentTimeMillis();

    }

    private void move ( double x , double y) {
         X += x;
         Y += y;
         setPosX( (int)X);
         setPosY((int)Y);
    }

    public void update (){
        if (lastAniTime + 60 < System.currentTimeMillis()) {
            lastAniTime = System.currentTimeMillis();
        }
        if (lastMoveTime + 40 / speed < System.currentTimeMillis()) {
            //Chia ra các checkpoint để enemy di chuyển

            lastMoveTime = System.currentTimeMillis();
        }
    }
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(), getPosX(), getPosY());
    }

}
