package Game.Tower;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MainTower extends BaseTower{
    public MainTower(Group root, double posX, double posY, ImageView tower, int price, int damage, int range) {
        super(root, posX, posY, tower, price, damage, range);
        this.tower.setLayoutX(this.posX);
        this.tower.setLayoutY(this.posY - 5);
        ImageView base_tower = new ImageView(new Image("file:Source/Towers/towerDefense_tile180.png"));
        base_tower.setLayoutX(this.posX);
        base_tower.setLayoutY(this.posY);
        //root.getChildren().addAll(base_tower, this.getTower());
    }

    @Override
    public void showInfo(Group root) {
        Text priceTower = new Text("Price: " + this.getPrice());
        setText(priceTower, 12.05 * 64, 4.5 * 64 + 85);
        Text damageTower = new Text("Damage: " + this.getDamage());
        setText(damageTower, 12.05 * 64, 5.5 * 64 + 85);
        Text rangeTower = new Text("Range: " + this.getRange());
        setText(rangeTower, 12.05 * 64, 6.5 * 64 + 85);
        root.getChildren().addAll(priceTower, damageTower, rangeTower);
        priceTower.setVisible(false);
        damageTower.setVisible(false);
        rangeTower.setVisible(false);
        this.getTower().setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                priceTower.setVisible(true);
                damageTower.setVisible(true);
                rangeTower.setVisible(true);
            }
        });
        this.getTower().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                priceTower.setVisible(false);
                damageTower.setVisible(false);
                rangeTower.setVisible(false);
            }
        });
    }

    public void dragObject(Group root, Scene scene, String[][] map){
        Rectangle[][] targetPos = new Rectangle[11][12];
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 12; j++){
                targetPos[i][j] = new Rectangle(j*64, i*64, 64, 64);
                targetPos[i][j].setFill(Color.TRANSPARENT);
                if(map[i][j].equals("024") || map[i][j].equals("241")) root.getChildren().add(targetPos[i][j]);
            }
        }
        tower.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ImageView mainTower = new ImageView(tower.getImage());
                mainTower.setLayoutX(posX);
                mainTower.setLayoutY(posY);

                TowerDrag towerDrag = new TowerDrag(root, posX, posY, mainTower, getPrice(), getDamage(), getRange());


                root.getChildren().add(towerDrag.tower);
                towerDrag.putTower(root, scene, targetPos, map);
            }
        });
    }
}
