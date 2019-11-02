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

public class Level3 extends Application {
    Tank2 tank = new Tank2();
    Soliders2 sl1 = new Soliders2(245, 10*64 + 32 , -32);
    Soliders2 sl2 = new Soliders2(246 , 10*64 +32, -32*2);
    Soliders2 sl3 = new Soliders2(247 , 10*64 + 32 , -32*3);
    Soliders2 sl4 = new Soliders2(248 , 10*64  + 32, -32*4);
    Plane2 pl = new Plane2();

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
    public void draw (GraphicsContext gc){
        String[][] map = MAP_TILES3;
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
