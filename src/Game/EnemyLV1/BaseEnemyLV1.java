package Game.EnemyLV1;

import Game.Object.GameObject;
import Game.Object.UpdatableObject;
import javafx.scene.image.Image;

import java.awt.*;

public class BaseEnemyLV1 extends GameObject implements UpdatableObject {
    protected Image image;
    protected int i , j , pos_x , pos_y;
    protected double speed;
    protected double dam , health;
    protected int waypoint = 0;
    protected Direction direction;

    public final Point[] wayPoint1 = new Point[]{
            new Point(7*64 + 32 , -64),
            new Point(7*64 + 32 , 0*64),
            new Point (7*64 + 32, 3*64 + 32),
            new Point(2*64 + 32 , 3*64 + 32),
            new Point( 2*64 + 32 ,7*64 + 32),
            new Point(5*64 + 32 , 7*64 + 32),
            new Point( 5*64 + 32 , 12*64),
    };


    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public Point getNextway(){
        if ( waypoint < wayPoint1.length - 1)
            return wayPoint1[++waypoint];
        return null;
    }


    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        if (waypoint >= wayPoint1.length) {
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = wayPoint1[waypoint];
        if (distance((int) pos_x, (int) pos_y, currentWP.x, currentWP.y) <= speed) {
            pos_x = currentWP.x;
            pos_y = currentWP.y;
            Point nextWayPoint = getNextway();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.x - pos_x;
            double deltaY = nextWayPoint.y - pos_y;
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;
        }

    }

    @Override
    public void update() {
        calculateDirection();

        switch (direction) {
            case UP:
                pos_y -= speed;
                break;
            case DOWN:
                pos_y += speed;
                break;
            case LEFT:
                pos_x -= speed;
                break;
            case RIGHT:
                pos_x += speed;
                break;
        }
    }
}
