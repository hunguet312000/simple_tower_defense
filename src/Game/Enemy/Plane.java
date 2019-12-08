package Game.Enemy;

import javafx.animation.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Plane extends BaseEnemy{

    public Plane ( int k){
        super(k , "plane" , 28 , 6*15 , 5 ,5 );
    }

    public void move(){
        Path path;
        path = new Path();
        path.getElements().add( new MoveTo(-25, 300f));
        path.getElements().add( new QuadCurveTo( 300f , -300f , 600f , 11*64));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(speed));
        pathTransition.setNode(imageView);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(0);
        pathTransition.setAutoReverse(false);

        pathTransition.setOnFinished(actionEvent -> {
            Destroy();
            if ( this.hp > 0)
                player.lives--;
        });
        pathTransition.play();
    }

    @Override
    public void increaseHealth(int level) {
        hp += level*1;
    }

    public void increaseSpeed ( int level ) { speed -= level*0.05;}

    public void HealthBar(){
        healthbar = new ProgressBar(this.hp);
        healthbar.setPrefSize(40 , 12);
        healthbar.setViewOrder(-1);
        this.getChildren().add(healthbar);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if ( healthbar != null ){
                    healthbar.setTranslateX(imageView.getTranslateX() + 50);
                    healthbar.setStyle("-fx-accent: yellow;");
                    healthbar.setTranslateY(imageView.getTranslateY() + 10);
                }
            }
        };
        timer.start();
    }
}
