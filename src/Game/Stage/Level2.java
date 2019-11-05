package Game.Stage;

import Game.Enemy.NomarlEnemy;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Level2 extends Application {
    public static final String[][] MAP_TILES2 = new String[][]{
            { "024" , "024" , "024" , "024" , "163" , "161" , "024" , "024" , "024" , "024" , "024" , "024" },
            { "024" , "024" , "024" , "024" , "163" , "184" , "185" , "185" , "185" , "185" , "142" , "024" },
            { "024" , "024" , "024" , "024" , "164" , "139" , "139" , "139" , "139" , "140" , "161" , "024" },
            { "024" , "141" , "185" , "185" , "185" , "185" , "142" , "024" , "024" , "163" , "161" , "024" },
            { "024" , "163" , "138" , "139" , "139" , "140" , "184" , "185" , "185" , "186" , "161" , "024" },
            { "024" , "163" , "184" , "142" , "024" , "164" , "139" , "139" , "139" , "139" , "165" , "024" },
            { "024" , "164" , "140" , "161" , "024" , "024" , "024" , "024" , "024" , "024" , "024" , "024" },
            { "024" , "024" , "163" , "184" , "185" , "185" , "142" , "024" , "024" , "024" , "024" , "024" },
            { "024" , "024" , "164" , "139" , "139" , "140" , "161" , "024" , "024" , "024" , "024" , "024" },
            { "024" , "024" , "024" , "024" , "024" , "163" , "161" , "024" , "024" , "024" , "024" , "024" },
            { "024" , "024" , "024" , "024" , "024" , "163" , "161" , "024" , "024" , "024" , "024" , "024" },
    };

    public Level2(){
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Game");
        Group root = new Group();
        Canvas canvas = new Canvas(64*15, 64*11);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc, MAP_TILES2);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void draw (GraphicsContext gc, String[][] map){
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                gc.drawImage(new Image("file:Source/Landcape/towerDefense_tile"+ map[i][j] + ".png"), j * 64, i * 64);
            }
        }
    }
}
