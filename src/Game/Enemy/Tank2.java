package Game.Enemy;
import Game.Stage.Level1;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.Point;
public class Tank2 extends BaseEnemy {
    protected Image gunTank;
    protected int waypoint = 0;
    protected Direction direction;

    public Tank2() {
        i = 10;
        j = 0;
        pos_x = i * 64 + 32;
        pos_y = j * 64;
        speed = 2;
        health = 100;
        direction = Direction.UP;
        image = new Image("file:Source/Enemy/Weapons/towerDefense_tile269.png");
        gunTank = new Image("file:Source/Enemy/Weapons/towerDefense_tile292.png");
    }

    public final Point[] wayPoint3 = new Point[]{
            new Point(10 * 64 + 32, 0* 64 ),
            new Point(10*64 + 32 , 1*64 + 32),
            new Point(8 * 64 + 32, 1 * 64 + 32),
            new Point(8 * 64 + 32, 3 * 64 + 32),
            new Point(5 * 64 + 32, 3 * 64 + 32),
            new Point(5 * 64 + 32, 0 * 64 + 32),
            new Point(1 * 64 + 32, 0 * 64 + 32),
            new Point(1 * 64 + 32, 5 * 64 + 32),
            new Point(3 * 64 + 32, 5 * 64 + 32),
            new Point(3 * 64 + 32, 6 * 64 + 32),
            new Point(10* 64 + 32, 6 * 64 + 32),
            new Point(10* 64 + 32, 9 * 64 + 32),
            new Point(-64, 9 * 64 + 32),
    };


    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public Point getNextway() {
        if (waypoint < wayPoint3.length - 1)
            return wayPoint3[++waypoint];
        return null;
    }

    public void draw(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(image);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);
        ImageView iv2 = new ImageView(gunTank);
        iv2.setRotate(this.direction.getDegree());
        Image gun = iv2.snapshot(params, null);
        gc.drawImage(base, pos_x, pos_y);
        gc.drawImage(gun, pos_x, pos_y);
    }

    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        if (waypoint >= wayPoint3.length) {
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = wayPoint3[waypoint];
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
