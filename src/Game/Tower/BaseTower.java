package Game.Tower;

import Game.Button.Game;
import Game.Button.TowerSetting;
import Game.Enemy.*;
import Game.MainConfig;
import Game.Object.Music;
import Game.Object.Player;
import Game.Tower.Bullet;
import Game.Object.GameObject;
import Game.Stage.Level;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class BaseTower extends GameObject  {
    private ImageView base_tower;
    private int priceTower;
    private int range;
    private Circle shootRange;
    private double towerDamage;
    private String type;
    protected Player player;
    protected Bullet bullet;

    private double preAngle = 0;
    private MainConfig.TOWERFORM towerForm;

    public int upgradeCost = 40;
    public TowerSetting towerSetting;

    public BaseTower(MainConfig.TOWERFORM towerForm){
        this.towerForm = towerForm;
        setTowerInfo(towerForm);
        setShootingRange();
        showTowerInfo();
    }

    public ImageView getBase_tower() {
        return base_tower;
    }

    public Circle getShootRange() {
        return shootRange;
    }

    public void setShootRange(Circle shootRange) {
        this.shootRange = shootRange;
    }

    public void setTowerInfo(MainConfig.TOWERFORM towerForm){
        switch (towerForm){
            case TOWER_TYPE1:
                base_tower = new ImageView(new Image(MainConfig.TOWER_FILE[0]));
                priceTower = 100;
                towerDamage = 20;
                range = 150;
                type = "TANK\n\nPLANE\n\nSOLIDERS";
                break;
            case TOWER_TYPE2:
                base_tower = new ImageView(new Image(MainConfig.TOWER_FILE[1]));
                priceTower = 20;
                towerDamage = 14;
                range = 100;
                type = "TANK\n\nSOLIDERS";
                break;
            case TOWER_TYPE3:
                base_tower = new ImageView(new Image(MainConfig.TOWER_FILE[2]));
                priceTower = 40;
                towerDamage = 16;
                range = 115;
                type = "PLANE";
                break;
            case TOWER_TYPE4:
                base_tower = new ImageView(new Image(MainConfig.TOWER_FILE[3]));
                priceTower = 60;
                towerDamage = 18;
                range = 130;
                type = "TANK\n\nPLANE\n\nSOLIDERS";
                break;
        }
    }

    private double findAngle(Point2D a, Point2D b){
        return 180 - Math.toDegrees(Math.atan2(a.getX() - b.getX(), a.getY() - b.getY()));
    }
    public void bulletSpawn(){
        bullet = new Bullet(this.towerForm);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.4), event -> {
            try {
                bullet.getImageView().setVisible(false);
                BaseEnemy temp = null;
                for(int i = 0; i < SpawnLevel.enemies.size(); i++){
                    if(this.getShootRange().getBoundsInParent().contains(SpawnLevel.enemies.get(i).getPos_x() + 32, SpawnLevel.enemies.get(i).getPos_y() + 32)){
                        if(towerForm.equals(MainConfig.TOWERFORM.TOWER_TYPE1) || towerForm.equals(MainConfig.TOWERFORM.TOWER_TYPE2) &&
                                (SpawnLevel.enemies.get(i) instanceof  Soliders || SpawnLevel.enemies.get(i) instanceof Tank)){
                            temp = SpawnLevel.enemies.get(i);
                            bullet.getImageView().setVisible(true);
                            break;
                        }
                        else if(towerForm.equals(MainConfig.TOWERFORM.TOWER_TYPE3) && SpawnLevel.enemies.get(i) instanceof Plane){
                            temp = SpawnLevel.enemies.get(i);
                            bullet.getImageView().setVisible(true);
                            break;
                        }
                        else if(towerForm.equals(MainConfig.TOWERFORM.TOWER_TYPE4)){
                            temp = SpawnLevel.enemies.get(i);
                            bullet.getImageView().setVisible(true);
                            break;
                        }
                        else return;
                    }
                }
                if(temp != null) {
                    bulletShooting(bullet, temp);
                    rotateTower(temp);
                }

            }catch (Exception e){}
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void rotateTower(BaseEnemy baseEnemy){
        Point2D a = new Point2D(baseEnemy.getPos_x() + 38, baseEnemy.getPos_y() + 38);
        Point2D b = new Point2D(this.getShootRange().getCenterX(), this.getShootRange().getCenterY());
        double angle = findAngle(a, b);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.4), this.getBase_tower());
        rotateTransition.setFromAngle(preAngle);
        rotateTransition.setToAngle(angle);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        preAngle = angle;
    }

    public void bulletShooting(Bullet bullet, BaseEnemy baseEnemy){
        Line line = new Line(this.getShootRange().getCenterX(), this.getShootRange().getCenterY(), baseEnemy.getImageView().getTranslateX() + 32, baseEnemy.getImageView().getTranslateY() + 32);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(bullet.getImageView());
        pathTransition.setPath(line);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setDuration(Duration.seconds(0.4));
        pathTransition.setOnFinished(actionEvent -> {
            baseEnemy.hp -= towerDamage;
            if ( baseEnemy.hp <= 0 ){
                baseEnemy.Destroy();
                player.moneys += baseEnemy.value;
                player.score += baseEnemy.score;
            }else{
                if ( baseEnemy.healthbar != null ){
                    baseEnemy.healthbar.setProgress(1 - towerDamage/baseEnemy.hp);
                }
            }
        });

        pathTransition.play();
    }

    public void setShootingRange(){
        this.shootRange = new Circle();
        this.shootRange.setRadius(this.range);
        this.shootRange.setFill(Color.rgb(255, 0, 0, 0.3));
        this.shootRange.setEffect(new Glow(0.9));
        this.shootRange.setVisible(true);
    }

    public void showTowerInfo(){
        Text towerCost = new Text("Price: " + priceTower);
        Text towerDam = new Text("Damage: " + towerDamage);
        Text towerRange = new Text("Range: " + range);
        Text attack = new Text("Attack: \n\n" + type);
        MainConfig.setText(towerCost, 13*64, 4.5*64 + 90 , 120 , 0 , 98 );
        MainConfig.setText(towerDam, 13*64, 4.5*64 + 135 , 81 , 31 , 114);
        MainConfig.setText(towerRange, 13*64, 4.5*64 + 180, 255 , 51, 216);
        MainConfig.setText(attack, 13*64, 4.5*64 + 225 , 255 , 0 , 0);
        Level.root.getChildren().addAll(towerCost, towerDam, towerRange, attack);
        towerCost.setVisible(false);
        towerDam.setVisible(false);
        towerRange.setVisible(false);
        attack.setVisible(false);

        base_tower.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                towerCost.setVisible(true);
                towerDam.setVisible(true);
                towerRange.setVisible(true);
                shootRange.setVisible(true);
                attack.setVisible(true);
            }
        });
        base_tower.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                towerCost.setVisible(false);
                towerDam.setVisible(false);
                towerRange.setVisible(false);
                shootRange.setVisible(false);
                attack.setVisible(false);
            }
        });
    }

    public void eraseTower(){
        bullet.eraseBullet();
        Level.root.getChildren().removeAll(base_tower, shootRange, bullet.getImageView());
    }

    public int getPriceTower() {
        return priceTower;
    }

    public void setPriceTower(int priceTower) {
        this.priceTower = priceTower;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getTowerDamage() {
        return towerDamage;
    }

    public void setTowerDamage(double towerDamage) {
        this.towerDamage = towerDamage;
    }

}