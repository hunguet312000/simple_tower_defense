package Game.Enemy.EnemyLV2;

import Game.Object.EnemyObject;
import Game.Object.UpdatableObject;

import java.awt.*;

public class BaseEnemyLV2 extends EnemyObject implements UpdatableObject {

    public final Point[] wayPoint2 = new Point[]{
            new Point( 4*64 + 32 , -128),
            new Point(4 * 64 + 32, 0 * 64),
            new Point(4 * 64 + 32, 1 * 64 + 32),
            new Point(9 * 64 + 32, 1 * 64 + 32),
            new Point(9 * 64 + 32, 4 * 64 + 32),
            new Point(5 * 64 + 32, 4 * 64 + 32),
            new Point(5 * 64 + 32, 3 * 64 + 32),
            new Point(1 * 64 + 32, 3 * 64 + 32),
            new Point(1 * 64 + 32, 5 * 64 + 32),
            new Point(2 * 64 + 32, 5 * 64 + 32),
            new Point(2 * 64 + 32, 7 * 64 + 32),
            new Point(5 * 64 + 32, 7 * 64 + 32),
            new Point(5 * 64 + 32, 12 * 64),
    };


    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public Point getNextway(){
        if ( waypoint < wayPoint2.length - 1)
            return wayPoint2[++waypoint];
        return null;
    }


    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        if (waypoint >= wayPoint2.length) {
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = wayPoint2[waypoint];
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
