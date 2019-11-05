package Game.Stage;

import Game.Enemy.*;
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

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Level2  extends  Application {
    Tank1 tank = new Tank1();
    Soliders1 sl1 = new Soliders1(245, 4*64 + 32 , -32);
    Soliders1 sl2 = new Soliders1(246 , 4*64 + 32 , -32*2);
    Soliders1 sl3 = new Soliders1(247 , 4*64 + 32 , -32*3);
    Soliders1 sl4 = new Soliders1(248 , 4*64 + 32 , -32*4);
    Plane1 pl = new Plane1();

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

    public void draw (GraphicsContext gc){
        String[][] map = MAP_TILES2;
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
