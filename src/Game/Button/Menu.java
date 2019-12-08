package Game.Button;

import Game.Object.Music;
import Game.Object.Player;
import Game.Stage.Level;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Menu extends BaseButton{

    Music bgAudio = new Music("Source/Audio/Track.wav");
    Music click = new Music("Source/Audio/icon_click.wav");

    public Menu (Group root , Stage primaryStage , Canvas canvas, boolean GameOver ) {
        if (GameOver == false) {

            Text start = new Text();
            setText(start,"START", 443, 400, Color.WHITE);
            start.setStyle("-fx-font: 25 broadway; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
            start.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Level level = new Level();
                    try {
                        level.start(new Stage());
                        primaryStage.close();
                        bgAudio.stop();
                        click.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            start.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    start.setFill(Color.GREENYELLOW);
                }
            });
            start.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    start.setFill(Color.WHITE);
                }
            });

            Text exit = new Text();
            setText(exit, "EXIT", 282, 538, Color.WHITE);
            exit.setStyle("-fx-font: 25 broadway; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
            exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    primaryStage.close();
                    bgAudio.stop();
                    click.play();
                }
            });
            exit.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    exit.setFill(Color.GREENYELLOW);
                }
            });
            exit.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    exit.setFill(Color.WHITE);
                }
            });

            root.getChildren().addAll(canvas, start, exit);

            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    bgAudio.playCycle(49);
                }
            };

            timer.start();

        }else{
            Text score = new Text();
            setText(score, "SCORE: " + Player.score,400, 450, Color.WHITE);
            score.setStyle("-fx-font-family: monospace ; -fx-font-size: 50px ;font-style : italic ;-fx-font-weight : bold; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");

            Text exit = new Text();
            setText(exit, "EXIT",400,550, Color.WHITE);
            exit.setStyle("-fx-font-family: monospace ; -fx-font-size: 50px ;font-style : italic ;-fx-font-weight : bold; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
            exit.setCursor(Cursor.HAND);

            exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    primaryStage.close();
                }
            });
            exit.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    exit.setFill(Color.RED);
                }
            });
            exit.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    exit.setFill(Color.WHITE);
                }
            });

            root.getChildren().addAll(canvas, score, exit);
        }
    }
}
