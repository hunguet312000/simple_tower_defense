package Game.Tower;

import Game.MainConfig;
import Game.Object.GameObject;
import Game.Stage.Level;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet extends GameObject {
    double damage;

    public Bullet(MainConfig.TOWERFORM towerform){
        setUpBulletInfo(towerform);
        Level.root.getChildren().add(getImageView());
        getImageView().setVisible(false);
    }

    public void setUpBulletInfo(MainConfig.TOWERFORM towerform) {
        switch (towerform) {
            case TOWER_TYPE1:
                this.imageView = new ImageView(new Image(MainConfig.BULLET_FILE[0]));
                damage = 20;
                break;
            case TOWER_TYPE2:
                this.imageView = new ImageView(new Image(MainConfig.BULLET_FILE[1]));
                damage = 14;
                break;
            case TOWER_TYPE3:
                this.imageView = new ImageView(new Image(MainConfig.BULLET_FILE[2]));
                damage = 16;
            case TOWER_TYPE4:
                this.imageView = new ImageView(new Image(MainConfig.BULLET_FILE[3]));
                damage = 18;
                break;
        }
    }

    public void eraseBullet(){
        super.eraseImage();
    }

}