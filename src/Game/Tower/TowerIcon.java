package Game.Tower;

import Game.Button.Game;
import Game.Button.TowerSetting;
import Game.MainConfig;
import Game.Object.GameObject;
import Game.Object.Music;
import Game.Object.Player;
import Game.Stage.Level;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class TowerIcon extends GameObject {

    private MainConfig.TOWERFORM towerForm;
    private ImageView imageTower;
    private int towerCost;
    private int towerDam;
    private int towerRange;
    private String type;
    Music click = new Music("Source/Audio/icon_click.wav");
    Music click1 = new Music("Source/Audio/icon_hover.wav");

    public TowerIcon(MainConfig.TOWERFORM towerForm){
        this.towerForm = towerForm;
        setImage(towerForm);
        showTowerInfo();
        Level.root.getChildren().add(getImageTower());
    }

    public void setImage(MainConfig.TOWERFORM towerForm){
        switch (towerForm){
            case TOWER_TYPE1:
                imageTower = new ImageView(new Image(MainConfig.TOWER_FILE[0]));
                imageTower.setLayoutX(12.5*64 + 15);
                imageTower.setLayoutY(20);
                towerCost = 100;
                towerDam = 20;
                towerRange = 150;
                type = "TANK\n\nPLANE\n\nSOLIDERS";
                break;
            case TOWER_TYPE2:
                imageTower = new ImageView(new Image(MainConfig.TOWER_FILE[1]));
                imageTower.setLayoutX(12.5*64 + 15);
                imageTower.setLayoutY(1*64 + 60);
                towerCost = 20;
                towerDam = 14;
                towerRange = 100;
                type = "TANK\n\nSOLIDERS";
                break;
            case TOWER_TYPE3:
                imageTower = new ImageView(new Image(MainConfig.TOWER_FILE[2]));
                imageTower.setLayoutX(14*64 + 15);
                imageTower.setLayoutY(20);
                towerCost = 40;
                towerDam = 16;
                towerRange = 115;
                type = "PLANE";
                break;
            case TOWER_TYPE4:
                imageTower = new ImageView(new Image(MainConfig.TOWER_FILE[3]));
                imageTower.setLayoutX(14*64 + 15);
                imageTower.setLayoutY(1*64 + 60);
                towerCost = 60;
                towerDam = 18;
                towerRange = 130;
                type = "TANK\n\nPLANE\n\nSOLIDERS";
                break;
        }
    }

    public void dragTower(){
        imageTower.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(Player.moneys >= getTowerCost() ) {
                    Player.moneys -= getTowerCost();
                    click.playclick();
                    BaseTower baseTower = new BaseTower(getTowerForm());
                    baseTower.getBase_tower().setViewOrder(-1);
                    baseTower.getBase_tower().setLayoutX(event.getSceneX() - 32);
                    baseTower.getBase_tower().setLayoutY(event.getSceneY() - 32);
                    baseTower.getShootRange().setCenterX(event.getSceneX());
                    baseTower.getShootRange().setCenterY(event.getSceneY());
                    Level.root.getChildren().addAll(baseTower.getShootRange(), baseTower.getBase_tower());
                    setPositionDragTower(baseTower);
                }
                else Game.notice.setVisible(true);
            }
        });
    }

    private void setPositionDragTower(BaseTower tower){
        Level.scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tower.getBase_tower().setLayoutX(event.getX() - 32);
                tower.getBase_tower().setLayoutY(event.getY() - 32);
                tower.getShootRange().setCenterX(tower.getBase_tower().getLayoutX() + 32);
                tower.getShootRange().setCenterY(tower.getBase_tower().getLayoutY() + 32);
                tower.getShootRange().setFill(Color.rgb(255, 0, 0, 0.3));
                for(int i = 0; i < 11; i++){
                    for(int j = 0; j < 12; j++){
                        if(MainConfig.TARGET_TOWER_DRAG[i][j].getBoundsInParent().contains(event.getSceneX(), event.getSceneY())
                                && (MainConfig.MAP_TILES1[i][j].equals("024") || MainConfig.MAP_TILES1[i][j].equals("241") || MainConfig.MAP_TILES1[i][j].equals("034"))) {
                            MainConfig.TARGET_TOWER_DRAG[i][j].setVisible(true);
                            tower.getShootRange().setFill(Color.rgb(0, 255, 0, 0.3));
                        }
                        else {
                            MainConfig.TARGET_TOWER_DRAG[i][j].setVisible(false);
                        }
                    }
                }
            }
        });

        Level.scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(int i = 0; i < 11; i++){
                    for(int j = 0; j < 12; j++){
                        if(MainConfig.TARGET_TOWER_DRAG[i][j].getBoundsInParent().contains(event.getSceneX(), event.getSceneY())
                                && (MainConfig.MAP_TILES1[i][j].equals("024") || MainConfig.MAP_TILES1[i][j].equals("241") || MainConfig.MAP_TILES1[i][j].equals("034"))){
                            MainConfig.TARGET_TOWER_DRAG[i][j].setVisible(false);
                            click1.playclick();
                            tower.getBase_tower().setLayoutX(j*64);
                            tower.getBase_tower().setLayoutY(i*64);
                            tower.getShootRange().setCenterX(j*64 + 32);
                            tower.getShootRange().setCenterY(i*64 + 32);
                            tower.towerSetting = new TowerSetting(tower);
                            if (i == 0) tower.towerSetting.setPosition(j*64,  i*64 + 90);
                            else tower.towerSetting.setPosition(j*64,  i*64);
                            tower.getShootRange().setVisible(false);
                            tower.bulletSpawn();
                            Level.scene.setOnMouseMoved(null);
                            Level.scene.setOnMouseClicked(null);
                        }
                    }
                }
            }
        });
    }

    public void showTowerInfo(){
        Text towerCost = new Text("Price: " + getTowerCost());
        Text towerDam = new Text("Damage: " + getTowerDam());
        Text towerRange = new Text("Range: " + getTowerRange());
        Text attack = new Text("Attack: \n\n" + type);
        MainConfig.setText(towerCost, 13*64, 4.5*64 + 90 , 120 , 0 , 98 );
        MainConfig.setText(towerDam, 13*64, 4.5*64 + 135 , 81 , 31 , 114);
        MainConfig.setText(towerRange, 13*64, 4.5*64 + 180, 255 , 51, 216);
        MainConfig.setText(attack, 13*64, 4.5*64 + 225 , 255 , 0 , 0);
        Level.root.getChildren().addAll(towerCost, towerDam, towerRange , attack);
        towerCost.setVisible(false);
        towerDam.setVisible(false);
        towerRange.setVisible(false);
        attack.setVisible(false);

        imageTower.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                towerCost.setVisible(true);
                towerDam.setVisible(true);
                towerRange.setVisible(true);
                attack.setVisible(true);
            }
        });
        imageTower.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                towerCost.setVisible(false);
                towerDam.setVisible(false);
                towerRange.setVisible(false);
                Game.notice.setVisible(false);
                attack.setVisible(false);
            }
        });
    }

    public MainConfig.TOWERFORM getTowerForm() {
        return towerForm;
    }

    public void setTowerForm(MainConfig.TOWERFORM towerForm) {
        this.towerForm = towerForm;
    }

    public ImageView getImageTower() {
        return imageTower;
    }

    public void setImageTower(ImageView imageTower) {
        this.imageTower = imageTower;
    }

    public int getTowerCost() {
        return towerCost;
    }

    public void setTowerCost(int towerCost) {
        this.towerCost = towerCost;
    }

    public int getTowerDam() {
        return towerDam;
    }

    public void setTowerDam(int towerDam) {
        this.towerDam = towerDam;
    }

    public int getTowerRange() {
        return towerRange;
    }

    public void setTowerRange(int towerRange) {
        this.towerRange = towerRange;
    }
}
