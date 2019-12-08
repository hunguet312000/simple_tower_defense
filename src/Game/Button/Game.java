package Game.Button;

import Game.Object.Music;
import Game.Object.Player;
import Game.Stage.GameStage;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends BaseButton {

    Player player;
    Music bgAudio = new Music("Source/Audio/Track.wav");
    public boolean isClose = false;
    public static Text notice = new Text("You Have No Money!");

    public Game (Pane root , Stage primaryStage){
        Text lives = new Text();
        lives.setStyle("-fx-font-family: monospace ; -fx-font-size: 19px ;font-style : italic ;-fx-font-weight : bold; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");

        Text scores = new Text();
        scores.setStyle("-fx-font-family: monospace ; -fx-font-size: 19px ;font-style : italic ;-fx-font-weight : bold ;-fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");

        Text moneys = new Text();
        moneys.setStyle("-fx-font-family: monospace ; -fx-font-size: 19px ;font-style : italic ;-fx-font-weight : bold; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
        notice.setFill(Color.rgb(255, 0, 0));
        notice.setStyle("-fx-font-family: monospace ; -fx-font-size: 23px ;font-style : italic ;-fx-font-weight : bold; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
        notice.setLayoutX(12.3*64);
        notice.setLayoutY(4.5*64 + 60);
        notice.setVisible(false);
        root.getChildren().addAll(lives, scores, moneys, notice);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                setText(lives, " Lives: " + player.lives, 13.3*64, 4.5*64, Color.BLACK);
                setText(scores, "Scores:"+player.score,12.1*64, 5*64, Color.BLACK);
                setText(moneys, "Moneys:"+player.moneys, 14.2*64, 5*64, Color.BLACK);
                bgAudio.playCycle(49);
                if(player.lives == 0 && isClose == false){
                    isClose = true;
                    GameStage gs = new GameStage();
                    gs.isGameOver = true;
                    try {
                        gs.start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if(isClose == true) primaryStage.close();
            }
        };

        timer.start();
    }
}
