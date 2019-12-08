package Game.Enemy;

import javafx.animation.AnimationTimer;
import javafx.scene.control.ProgressBar;

public class Tank extends BaseEnemy {

    public Tank ( int k ){
            super( k , "tank" , 65 , 300 , 10 , 10);
    }

    @Override
    public void increaseHealth(int level) {
        hp += level*1.5;
    }

    public void increaseSpeed ( int level ) { speed -= level*0.1;}

    public void HealthBar(){
        healthbar = new ProgressBar(this.hp);
        healthbar.setPrefSize(50 , 12);
        healthbar.setViewOrder(-1);
        this.getChildren().add(healthbar);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if ( healthbar != null ){
                    healthbar.setTranslateX(imageView.getTranslateX() + 7);
                    healthbar.setStyle("-fx-accent: red;");
                    healthbar.setTranslateY(imageView.getTranslateY() - 10);
                }
            }
        };
        timer.start();
    }
}
