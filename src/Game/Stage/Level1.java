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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Game.Enemy.BaseEnemy;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level1 extends GameStage {

     PlayLevel1 playLevel1 = new PlayLevel1(1);


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

        playLevel1.draw(gc);

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
        Button next_level_button = new Button();
        setButton(next_level_button, 12.8*64, 3.5*64, "Next Level");
        Button update_button = new Button();
        setButton(update_button, 12.05*64, 9*64, "Update");
        Button sell_button = new Button();
        setButton(sell_button, 13.55*64, 9*64, "Sell");




        Button tower1 = new Button();
        Image tower1_image = new Image("file:Source/Menu/MainIcon.png", 45, 45, false, false);
        ImageView iv = new ImageView(tower1_image);
        tower1.setGraphic(iv);
        tower1.setLayoutX(12.1*64 + 15);
        tower1.setLayoutY(0);

        Button tower2 = new Button();
        Image tower2_image = new Image("file:Source/Menu/MainIcon.png", 45, 45, false, false);
        ImageView iv2 = new ImageView(tower2_image);
        tower2.setGraphic(iv2);
        tower2.setLayoutX(12.1*64 + 15);
        tower2.setLayoutY(1*64);

        Button tower3 = new Button();
        Image tower3_image = new Image("file:Source/Menu/MainIcon.png", 45, 45, false, false);
        ImageView iv3 = new ImageView(tower3_image);
        tower3.setGraphic(iv3);
        tower3.setLayoutX(12.1*64 + 15);
        tower3.setLayoutY(2*64);

        Button tower4 = new Button();
        Image tower4_image = new Image("file:Source/Menu/MainIcon.png", 45, 45, false, false);
        ImageView iv4 = new ImageView(tower4_image);
        tower4.setGraphic(iv4);
        tower4.setLayoutX(14*64 - 15);
        tower4.setLayoutY(0);

        Button tower5 = new Button();
        Image tower5_image = new Image("file:Source/Menu/MainIcon.png", 45, 45, false, false);
        ImageView iv5 = new ImageView(tower5_image);
        tower5.setGraphic(iv5);
        tower5.setLayoutX(14*64 - 15);
        tower5.setLayoutY(1*64);

        Button tower6 = new Button();
        Image tower6_image = new Image("file:Source/Menu/MainIcon.png", 45, 45, false, false);
        ImageView iv6 = new ImageView(tower6_image);
        tower6.setGraphic(iv6);
        tower6.setLayoutX(14*64 - 15);
        tower6.setLayoutY(2*64);

        Button rect_button = new Button();
        rect_button.setLayoutX(12*64);
        rect_button.setLayoutY(4*64);
        rect_button.setMinHeight(5*64);
        rect_button.setMaxHeight(5*64);
        rect_button.setMinWidth(3*64);
        rect_button.setMaxWidth(3*64);





        tower1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                Text prince = new Text();
                setText(prince, 12.05 * 64, 4.5 * 64, "Prince1");
                Text dame = new Text();
                setText(dame, 12.05 * 64, 5.5 * 64, "Dame1");
                Text range = new Text();
                setText(range, 12.05 * 64, 6.5 * 64, "Range1");
                root.getChildren().addAll(canvas, next_level_button, update_button, sell_button, tower1, tower2, tower3, tower4, tower5, tower6, rect_button);
                root.getChildren().addAll(prince, dame, range);
            }
        });


        tower2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                Text prince = new Text();
                setText(prince, 12.05 * 64, 4.5 * 64, "Prince2");
                Text dame = new Text();
                setText(dame, 12.05 * 64, 5.5 * 64, "Dame2");
                Text range = new Text();
                setText(range, 12.05 * 64, 6.5 * 64, "Range2");
                root.getChildren().addAll(canvas, next_level_button, update_button, sell_button, tower1, tower2, tower3, tower4, tower5, tower6, rect_button);
                root.getChildren().addAll(prince, dame, range);

            }
        });

        tower3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                Text prince = new Text();
                setText(prince, 12.05 * 64, 4.5 * 64, "Prince3");
                Text dame = new Text();
                setText(dame, 12.05 * 64, 5.5 * 64, "Dame3");
                Text range = new Text();
                setText(range, 12.05 * 64, 6.5 * 64, "Range3");
                root.getChildren().addAll(canvas, next_level_button, update_button, sell_button, tower1, tower2, tower3, tower4, tower5, tower6, rect_button);
                root.getChildren().addAll(prince, dame, range);
            }
        });

        tower4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                Text prince = new Text();
                setText(prince, 12.05 * 64, 4.5 * 64, "Prince4");
                Text dame = new Text();
                setText(dame, 12.05 * 64, 5.5 * 64, "Dame4");
                Text range = new Text();
                setText(range, 12.05 * 64, 6.5 * 64, "Range4");
                root.getChildren().addAll(canvas, next_level_button, update_button, sell_button, tower1, tower2, tower3, tower4, tower5, tower6, rect_button);
                root.getChildren().addAll(prince, dame, range);
            }
        });

        tower5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                Text prince = new Text();
                setText(prince, 12.05 * 64, 4.5 * 64, "Prince5");
                Text dame = new Text();
                setText(dame, 12.05 * 64, 5.5 * 64, "Dame5");
                Text range = new Text();
                setText(range, 12.05 * 64, 6.5 * 64, "Range5");
                root.getChildren().addAll(canvas, next_level_button, update_button, sell_button, tower1, tower2, tower3, tower4, tower5, tower6, rect_button);
                root.getChildren().addAll(prince, dame, range);
            }
        });

        tower6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().clear();
                Text prince = new Text();
                setText(prince, 12.05 * 64, 4.5 * 64, "Prince6");
                Text dame = new Text();
                setText(dame, 12.05 * 64, 5.5 * 64, "Dame6");
                Text range = new Text();
                setText(range, 12.05 * 64, 6.5 * 64, "Range6");
                root.getChildren().addAll(canvas, next_level_button, update_button, sell_button, tower1, tower2, tower3, tower4, tower5, tower6, rect_button);
                root.getChildren().addAll(prince, dame, range);
            }
        });




        root.getChildren().addAll(next_level_button, update_button, sell_button);
        root.getChildren().addAll(tower1, tower2, tower3, tower4, tower5, tower6);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                playLevel1.update();
                draw(gc);
            }
        };
        timer.start();
        primaryStage.show();
    }







    @Override
    public void setButton(Button button, double posX, double posY, String text) {
        super.setButton(button, posX, posY, text);
        button.setMinHeight(30);
        button.setMaxHeight(30);
        button.setMinWidth(90);
        button.setMaxWidth(90);
        button.setStyle("-fx-font: 14 broadway; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
        button.setTextFill(Color.rgb(0, 255, 255));
    }

    public void setText(Text text, double posX, double posY, String string){
        text.setFont(Font.font(20));
        text.setText(string);
        text.setLayoutX(posX);
        text.setLayoutY(posY);
    }

}
