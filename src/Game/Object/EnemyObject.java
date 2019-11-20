package Game.Object;

import javafx.scene.canvas.GraphicsContext;

abstract public class EnemyObject extends GameObject {
    protected int waypoint = 0;
    protected Direction direction;
    protected double speed;
    protected double damage;
}
