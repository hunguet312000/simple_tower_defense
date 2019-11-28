package Game.Stage;

import Game.MainConfig;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Level extends GameStage {

    CreatLV playLevel = new CreatLV();
    public static Group root = new Group();

    public void draw (GraphicsContext gc){
        String[][] map = MainConfig.MAP_TILES1;
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                gc.drawImage(new Image("file:Source/Landcape/towerDefense_tile"+ map[i][j] + ".png"), j * 64, i * 64);
            }
        }
        playLevel.draw(gc);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Game");
        Canvas canvas = new Canvas(64*15 + 15, 64*11);
        root.getChildren().addAll(canvas);
        Scene scene = new Scene(root);
        scene.setFill(Color.rgb(192, 192, 192));
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Button Lives_button = new Button();

        Button update_button = new Button();
        setButton(update_button, 12.05*64, 9*64, "Update");

        Button sell_button = new Button();
        setButton(sell_button, 13.55*64, 9*64, "Sell");

        Button rect_button = new Button();
        rect_button.setLayoutX(12*64);
        rect_button.setLayoutY(4*64);
        rect_button.setMinHeight(5*64);
        rect_button.setMaxHeight(5*64);
        rect_button.setMinWidth(3*64);
        rect_button.setMaxWidth(3*64);

        root.getChildren().addAll(Lives_button , update_button, sell_button);

        playLevel.CreatTower(root , scene);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                draw(gc);
                playLevel.update();
                setButton(Lives_button, 12.8*64, 3.5*64 + 25, "Lives : " + playLevel.player.getLives());
                playLevel.lose(primaryStage);
            }
        };
        playLevel.CreatEnemy();
        timer.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
