package Game.Stage;

import Game.Enemy.NomarlEnemy;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Scanner;

public class Level3 extends Application {
    public static final String[][] MAP_TILES3 = new String[][]{
            { "241" , "220" , "264" , "264" , "264" , "264" , "221" , "241" , "241" , "241" , "242" , "240" },
            { "241" , "242" , "217" , "218" , "218" , "219" , "240" , "241" , "220" , "264" , "265" , "240" },
            { "241" , "242" , "240" , "241" , "241" , "242" , "240" , "241" , "242" , "217" , "218" , "244" },
            { "241" , "242" , "240" , "241" , "241" , "242" , "263" , "264" , "265" , "240" , "241" , "241" },
            { "241" , "242" , "240" , "241" , "241" , "243" , "218" , "218" , "218" , "244" , "241" , "241" },
            { "241" , "242" , "263" , "264" , "221" , "241" , "241" , "241" , "241" , "241" , "241" , "241" },
            { "241" , "243" , "218" , "219" , "263" , "264" , "264" , "264" , "264" , "264" , "264" , "221" },
            { "241" , "241" , "241" , "243" , "218" , "218" , "218" , "218" , "218" , "218" , "219" , "240" },
            { "241" , "241" , "241" , "241" , "241" , "241" , "241" , "241" , "241" , "241" , "242" , "240" },
            { "264" , "264" , "264" , "264" , "264" , "264" , "264" , "264" , "264" , "264" , "265" , "240" },
            { "218" , "218" , "218" , "218" , "218" , "218" , "218" , "218" , "218" , "218" , "218" , "244" },
    };

    public Level3(){
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Game");
        Group root = new Group();
        Canvas canvas = new Canvas(64*15, 64*11);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc, MAP_TILES3);
       // Scanner sc = new Scanner(System.in)


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
