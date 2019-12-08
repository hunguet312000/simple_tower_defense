package Game.Object;

import Game.Enemy.SpawnLevel;
import Game.Stage.Level;
import javafx.scene.control.ProgressBar;

abstract public class EnemyObject extends GameObject {
    protected int tag ;
    protected double speed;
    protected String path;
    protected Player player;
    public int hp , score , value ;
    public ProgressBar healthbar;

    public void Destroy(){
        Level.root.getChildren().remove(this);
        this.getChildren().remove(imageView);
        this.getChildren().remove(healthbar);
        SpawnLevel.enemies.remove(this);
    }

}
