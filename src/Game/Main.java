package Game;

import Game.Enemy.BaseEnemy;
import Game.Stage.Gamestage;
import Game.Stage.Level1;
import Game.Stage.Level2;
import Game.Stage.Level3;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static Game.Stage.Level1.MAP_TILES1;
import static Game.Stage.Level2.MAP_TILES2;
import static Game.Stage.Level3.MAP_TILES3;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    Level1 lv1= new Level1();
    //Level2 lv2 = new Level2();
    //Level3 lv3 = new Level3();
    BaseEnemy Soliders1 = new BaseEnemy();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game");
        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);
        Canvas canvas = new Canvas(64*15 , 64*11 );
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
               Soliders1.update();
               draw(gc);
            }
        };
        timer.start();
        primaryStage.show();
    }

    public void draw ( GraphicsContext gc ){
        lv1.draw(gc , MAP_TILES1 );
        //lv2.draw(gc , MAP_TILES2 );
        //lv3.draw(gc , MAP_TILES3 );
        Soliders1.draw(gc);
    }

}