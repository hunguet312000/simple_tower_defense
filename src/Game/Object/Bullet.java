package Game.Object;

import Game.Enemy.BaseEnemy;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Bullet extends GameObject implements UpdatableObject {
      private BaseEnemy target;
      private int dam;
      private boolean destroyed;
      private String path;

      public Bullet ( int pos_x , int pos_y , BaseEnemy target , String path ){
          super(pos_x , pos_y);
          image = new Image( "file:Source/Towers/bullet" + path + ".png");
          this.target = target;
          this.path = path;
          destroyed = false;
          dam = 10;
      }

      public void update(){
          int targetX = target.getPos_x() + target.getWidth() / 2;
          int targetY = target.getPos_y() + target.getHeight() / 2 ;
          int distance = (int) Math.sqrt(Math.pow(targetX - pos_x, 2) + Math.pow(targetY - pos_y, 2));
          distance /= 8;

          if (distance != 0) {
              double moveX = 0, moveY = 0;
              moveX = (double) (targetX - pos_x) / distance;
              moveY = (double) (targetY - pos_y) / distance;

              setPos_x(pos_x + (int) moveX);
              setPos_y(pos_y + (int) moveY);

              ImageView iv = new ImageView(new Image("file:Source/Towers/bullet" + path + ".png"));
              double cc = 0;
              if (pos_x >= targetX) cc = 90;
              if (moveX != 0) iv.setRotate(Math.toDegrees(Math.atan(moveY / moveX)) + cc);
              else iv.setRotate(180 + cc);

              SnapshotParameters params = new SnapshotParameters();
              params.setFill(Color.TRANSPARENT);
              Image rotatedImage = iv.snapshot(params, null);
              setImage(rotatedImage);
          } else {
              destroyed = true;
              target.getHealthBar().setHealth(target.getHealthBar().getHealth() - dam*target.getHealthBar().getTemphealth()/target.getHp());
              target.setCurrentHp(target.getCurrentHp() - dam);
          }
      }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setPath(String path) {
        this.path = path;
    }

}