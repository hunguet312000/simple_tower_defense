package Game.Enemy.EnemyLV1;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class TankLV1 extends BaseEnemyLV1 {
    protected Image gunTank;


    public TankLV1 (){
        super(-100);
        pos_x = 7*64 + 32;
        pos_y = -64;
        speed = 1.3;
        direction = Direction.UP;
        image = new Image("file:Source/Enemy/Weapons/towerDefense_tile268.png");
        gunTank = new Image("file:Source/Enemy/Weapons/towerDefense_tile291.png");
    }

    public void increaseHealthTank ( int level ) { setHp( -100 + level*100);}

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
        if (healthBar !=null)
            healthBar.draw(gc);

    }

}
