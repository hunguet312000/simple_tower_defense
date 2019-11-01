package Game.Stage;

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

import java.awt.*;

public class Level1 extends Application {
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

    public void draw (GraphicsContext gc, String[][] map){
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                gc.drawImage(new Image("file:Source/Landcape/towerDefense_tile"+ map[i][j] + ".png"), j * 64, i * 64);
            }
        }
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
        draw(gc, MAP_TILES1);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
