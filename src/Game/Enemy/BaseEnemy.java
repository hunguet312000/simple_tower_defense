package Game.Enemy;

import Game.Interface.EnemyInterface;
import Game.Object.EnemyObject;
import Game.Stage.Level;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;

public abstract class BaseEnemy  extends EnemyObject implements EnemyInterface {

    public BaseEnemy (int tag , String path , double speed , int hp  , int score , int value){
        this.tag = tag;
        this.path = path;
        this.speed = speed;
        this.hp = hp;
        this.score = score;
        this.value = value;
        this.imageView = new ImageView(new Image("file:Source/Enemy/towerDefense_tile" + tag + ".png"));
        HealthBar();
        this.getChildren().add(imageView);
        move();
    }

    public void move(){
        Path path;
        path = new Path();
        path.getElements().add( new MoveTo(4*64 + 64 , -20));
        path.getElements().add( new VLineTo(1*64 + 64));
        path.getElements().add( new HLineTo(9*64 + 64));
        path.getElements().add( new VLineTo(4*64 + 64));
        path.getElements().add( new HLineTo(64));
        path.getElements().add( new VLineTo(9*64 + 64));
        path.getElements().add( new HLineTo(5*64 + 64));
        path.getElements().add( new VLineTo(7*64 + 64));
        path.getElements().add( new HLineTo(10*64 + 64));
        path.getElements().add( new VLineTo(10*64 + 64));

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

}
