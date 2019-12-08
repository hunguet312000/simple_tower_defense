package Game.Enemy;

import javafx.animation.AnimationTimer;
import javafx.scene.control.ProgressBar;

public class Soliders  extends  BaseEnemy {

    public Soliders ( int k){
        super(k , "soliders" , 58 , 4*15 , 1 , 1);
    }

    @Override
    public void increaseHealth(int level) {
        hp += level*0.5;
    }

    public void increaseSpeed ( int level ) { speed -= level*0.2;}

    public void HealthBar() {
        healthbar = new ProgressBar(this.hp);
        healthbar.setPrefSize(30, 10);
        healthbar.setViewOrder(-1);
        this.getChildren().add(healthbar);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (healthbar != null) {
                    healthbar.setTranslateX(imageView.getTranslateX() + 17);
                    healthbar.setStyle("-fx-accent: green;");
                    healthbar.setTranslateY(imageView.getTranslateY() + 43);
                }
            }
        };
        timer.start();
    }
}
