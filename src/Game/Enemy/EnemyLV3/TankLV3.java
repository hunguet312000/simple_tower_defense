package Game.Enemy.EnemyLV3;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class TankLV3 extends  BaseEnemyLV3 {
    protected Image gunTank;

    public TankLV3 (){
        pos_x = 10*64 + 32;
        pos_y = -64;
        speed = 2;
        direction = Direction.UP;
        image = new Image("file:Source/Enemy/Weapons/towerDefense_tile269.png");
        gunTank = new Image("file:Source/Enemy/Weapons/towerDefense_tile292.png");
    }

    public void draw (GraphicsContext gc){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(image);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);
        ImageView iv2 = new ImageView(gunTank);
        iv2.setRotate(this.direction.getDegree());
        Image gun = iv2.snapshot(params, null);
        gc.drawImage(base, pos_x, pos_y);
        gc.drawImage(gun, pos_x, pos_y);
    }
}
