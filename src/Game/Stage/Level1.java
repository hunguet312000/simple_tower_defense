package Game.Stage;

import Game.Enemy.Plane;
import Game.Enemy.Soliders;
import Game.Enemy.Tank;
import Game.Object.GameObject;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Game.Enemy.BaseEnemy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level1 extends Application {

    Tank tank = new Tank();
    Soliders sl1 = new Soliders(245, 7*64 + 32 , -32);
    Soliders sl2 = new Soliders(246 , 7*64 + 32 , -32*2);
    Soliders sl3 = new Soliders(247 , 7*64 + 32 , -32*3);
    Soliders sl4 = new Soliders(248 , 7*64 + 32 , -32*4);
    Plane pl = new Plane();

    public static final String[][] MAP_TILES1 = new String[][]{
            { "024" , "024" , "024" , "024" , "024" , "024" , "024" , "025" , "023" , "024" , "024" , "024"},
            { "024" , "024" , "024" , "024" , "024" , "024" , "024" , "025" , "023" , "024" , "024" , "024"},
            { "024" , "024" , "024" , "024" , "024" , "024" , "024" , "025" , "023" , "024" , "024" , "024"},
            { "024" , "024" , "003" , "047" , "047" , "047" , "047" , "048" , "023" , "024" , "024" , "024"},
            { "024" , "024" , "025" , "299" , "001" , "001" , "001" , "001" , "027" , "024" , "024" , "024"},
            { "024" , "024" , "025" , "023" , "024" , "024" , "024" , "024" , "024" , "024" , "024" , "024"},
            { "024" , "024" , "025" , "023" , "024" , "024" , "024" , "024" , "024" , "024" , "024" , "024"},
            { "024" , "024" , "025" , "046" , "047" , "047" , "004" , "024" , "024" , "024" , "024" , "024"},
            { "024" , "024" , "026" , "001" , "001" , "002" , "023" , "024" , "024" , "024" , "024" , "024"},
            { "024" , "024" , "024" , "024" , "024" , "025" , "023" , "024" , "024" , "024" , "024" , "024"},
            { "024" , "024" , "024" , "024" , "024" , "025" , "023" , "024" , "024" , "024" , "024" , "024"}
    };

    public void draw (GraphicsContext gc){
        String[][] map = MAP_TILES1;
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                gc.drawImage(new Image("file:Source/Landcape/towerDefense_tile"+ map[i][j] + ".png"), j * 64, i * 64);
            }
        }
        tank.draw(gc);
        sl1.draw(gc);
        sl2.draw(gc);
        sl3.draw(gc);
        sl4.draw(gc);
        pl.draw(gc);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Game");
        Group root = new Group();
        Canvas canvas = new Canvas(64*15, 64*11);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                tank.update();
                sl1.update();
                sl2.update();
                sl3.update();
                sl4.update();
                pl.update();
                draw(gc);
            }
        };
        timer.start();
        primaryStage.show();
    }

}
