package Game.Object;

import Game.Enemy.EnemyLV1.BaseEnemyLV1;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Bullet extends GameObject implements UpdatableObject {
    private boolean destroy;
    private BaseEnemyLV1 baseEnemyLV1s;
    private String path;
    private int damage;

    public Bullet ( int pos_x , int pos_y , BaseEnemyLV1 baseEnemyLV1s , String path ){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.baseEnemyLV1s = baseEnemyLV1s;
        image = new Image( "file:Source/Towers" + path + ".png" );
        destroy = false;
        damage = 10;
    }

    @Override
    public void update() {
        int targetX = baseEnemyLV1s.getPos_x() + 32;
        int targetY = baseEnemyLV1s.getPos_y() + 32;

        int distance = (int) Math.sqrt( Math.pow( targetX - pos_x , 2 ) + Math.pow( targetY - pos_y , 2));
        distance /= 8;

        if ( distance != 0 ){
            double moveX = 0 , moveY = 0;
            moveX = ( targetX - pos_x)/distance;
            moveY = ( targetY - pos_y )/distance;
            setPos_x(pos_x + (int)moveX);
            setPos_y(pos_y + (int)moveY);

            ImageView iv = new ImageView("file:Source/Towers" + path + ".png" );
            double cc = 0;
            if ( pos_y >= targetY ) cc = 90;
            if ( moveX != 0 ) iv.setRotate(Math.toDegrees(Math.atan(moveX / moveY) + cc ));
            else iv.setRotate( 180 + cc);

            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            Image rotatedImage = iv.snapshot(params, null);
            setImage(rotatedImage);
        }else {
            destroy = true;
            baseEnemyLV1s.getHealthBar().setHealth(baseEnemyLV1s.getHealthBar().getHealth() - damage*baseEnemyLV1s.getHealthBar().getTemphealth()/baseEnemyLV1s.getHp());
            baseEnemyLV1s.setCurrentHp(baseEnemyLV1s.getCurrentHp() - damage);
        }
    }

    public boolean isDestroy() {
        return destroy;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
