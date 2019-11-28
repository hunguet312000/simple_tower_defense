package Game.Tower;

import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.util.Duration;


public class TowerDrag extends BaseTower {

    public ImageView base_tower = new ImageView((new Image("file:Source/Towers/towerDefense_tile180.png")));
    Circle shootRange;
    public TowerDrag(Group root, double posX, double posY, ImageView tower, int price, int damage, int range) {
        super(root, posX, posY, tower, price, damage, range);
        shootRange = new Circle(this.range);
        shootRange.setFill(Color.TRANSPARENT);
        shootRange.setStroke(Color.BLUE);
        shootRange.setStrokeWidth(1);
        showInfo(root);
    }


    public void putTower(Group root, Scene scene, Rectangle[][] rectangle, String[][] map) {
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tower.setLayoutX(event.getX() - 30);
                tower.setLayoutY(event.getY() - 30);
                for(int i = 0; i < 11; i++)
                    for(int j = 0; j < 12; j++){
                        if(rectangle[i][j].getBoundsInParent().contains(event.getSceneX(), event.getSceneY()))
                            rectangle[i][j].setStroke(Color.BLUE);
                        else rectangle[i][j].setStroke(Color.TRANSPARENT);
                    }
            }
        });

        tower.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(int i = 0; i < 11; i++)
                    for(int j = 0; j < 12; j++){
                        int x = i, y = j;
                        if(rectangle[x][y].getBoundsInParent().contains(event.getSceneX(), event.getSceneY()) && map[i][j].equals("024")){
                            tower.setLayoutX(rectangle[x][y].getX());
                            tower.setLayoutY(rectangle[x][y].getY() - 5);

                            base_tower.setLayoutX(y*64);
                            base_tower.setLayoutY(x*64);

                            shootRange.setCenterX(y*64 + tower.getImage().getWidth()/2);
                            shootRange.setCenterY(x*64 + tower.getImage().getHeight()/2);

                            root.getChildren().addAll(base_tower, shootRange);
                            tower.toFront();
                            rectangle[x][y].setStroke(Color.TRANSPARENT);
                            scene.setOnMouseMoved(null);
                            tower.setOnMouseClicked(null);
                        }
                    }
            }
        });
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

        tower.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                priceTower.setVisible(true);
                damageTower.setVisible(true);
                rangeTower.setVisible(true);
                shootRange.setVisible(true);
            }
        });
        tower.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                priceTower.setVisible(false);
                damageTower.setVisible(false);
                rangeTower.setVisible(false);
                shootRange.setVisible(false);
            }
        });
    }

}
