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

public class Plane extends BaseEnemy {
    protected Image im;
    protected int waypoint = 0;
    protected Direction direction;

    public Plane (){
        pos_x = 7 * 64 + 32;
        pos_y = -128;
        speed = 2;
        health = 100;
        direction = Direction.UP;
        image = new Image("file:Source/Enemy/Weapons/towerDefense_tile270.png");
        im = new Image("file:Source/Enemy/Weapons/towerDefense_tile293.png");
    }

    public final Point[] wayPoint1 = new Point[]{
            new Point( 7*64 + 32 , -128),
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

    public void draw (GraphicsContext gc){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(im);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);
        ImageView iv2 = new ImageView(image);
        iv2.setRotate(this.direction.getDegree());
        Image base2 = iv2.snapshot(params, null);
        gc.drawImage(base, pos_x, pos_y);
        gc.drawImage(base2, pos_x, pos_y);
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