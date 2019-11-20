package Game.Enemy.EnemyLV3;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class PlaneLV3 extends BaseEnemyLV3 {
    private Image shadow;

    public PlaneLV3 ( int pos_x , int pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        speed = 3;
        direction = Direction.UP;
        image = new Image("file:Source/Enemy/Weapons/towerDefense_tile271.png");
        shadow = new Image("file:Source/Enemy/Weapons/towerDefense_tile294.png");
    }

    public void draw (GraphicsContext gc){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(shadow);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);
        ImageView iv2 = new ImageView(image);
        iv2.setRotate(this.direction.getDegree());
        Image base2 = iv2.snapshot(params, null);
        gc.drawImage(base, pos_x, pos_y + 10);
        gc.drawImage(base2, pos_x, pos_y);
    }
}
