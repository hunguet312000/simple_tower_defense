package Game.Stage;

import Game.Enemy.SpawnLevel;
import Game.MainConfig;
import Game.Tower.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

public class CreatLV  {

    public List<TowerIcon> towers = new ArrayList<>();

    public void drawMap (GraphicsContext gc){
        String[][] map = MainConfig.MAP_TILES1;
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                gc.drawImage(new Image("file:Source/Landcape/towerDefense_tile"+ map[i][j] + ".png"), j * 64, i * 64);
            }
        }
    }

    public void drawLine(Pane root, Line[] lines){
        for(int i = 0; i < lines.length; i++){
            lines[i].setStrokeWidth(4);
            root.getChildren().addAll(lines[i]);
        }
    }

    public void CreatEnemy(){
        SpawnLevel spawnLevel = new SpawnLevel();
        Level.root.getChildren().add(spawnLevel);
        Timeline timeline = new Timeline( new KeyFrame(Duration.seconds(6) , event -> {
            spawnLevel.SpawnLV(SpawnLevel.level);
            SpawnLevel.level += 1;
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    public void CreatTower(){
        towers.add(new TowerIcon(MainConfig.TOWERFORM.TOWER_TYPE1));
        towers.add(new TowerIcon(MainConfig.TOWERFORM.TOWER_TYPE2));
        towers.add(new TowerIcon(MainConfig.TOWERFORM.TOWER_TYPE3));
        towers.add(new TowerIcon(MainConfig.TOWERFORM.TOWER_TYPE4));
        for(int i = 0; i < 4; i++) {
            towers.get(i).dragTower();
        }
    }
}