package Game.EnemyLV1;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class SolidersLV1 extends  BaseEnemyLV1 {
    public SolidersLV1 (int k , int pos_x , int pos_y ){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        int x = k;
        speed = 1.25;
        health = 100;
        direction = Direction.UP;
        for ( x = 245 ; x <= 248 ; x++) image = new Image("file:Source/Enemy/Soliders/towerDefense_tile" + k +".png");
    }

    public void draw (GraphicsContext gc){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(image);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);
        gc.drawImage(base, pos_x, pos_y);
    }
}
