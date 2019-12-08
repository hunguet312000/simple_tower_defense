package Game.Object;

import Game.Enemy.SpawnLevel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;

public class Music {
     Media bg_audio;
     MediaPlayer bg_player;
     String path;

     public Music( String path ){
           this.path = path;
           bg_audio = new Media( new File(path).toURI().toString());
           bg_player = new MediaPlayer(bg_audio);
     }

     public void playCycle (double cycleLength){
           bg_player.setAutoPlay(true);
           bg_player.setCycleCount(MediaPlayer.INDEFINITE);
           bg_player.setStartTime(Duration.seconds(0));
           bg_player.setStopTime(Duration.seconds(cycleLength));
     }

    public void playclick(){
        bg_player.seek(Duration.ZERO);
        play();
    }

    public void playbullet(){
         play();
        Timeline timeline = new Timeline( new KeyFrame(Duration.seconds(0.3) , event -> {
            stop();
        }));
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    public void play(){bg_player.play();}
    public void stop() {
        bg_player.stop();
    }

}
