package Game.Stage;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class TowerControl {
    public Circle createShootingRange(ImageView iv, double radius){
        Circle circle = new Circle();
        circle.setCenterX(iv.getLayoutX() - 30);
        circle.setCenterY(iv.getLayoutY() - 30);
        circle.setFill(Color.TRANSPARENT);
        circle.setRadius(radius);
        circle.setStrokeWidth(1);

        return circle;
    }

    public void dragObject(ImageView iv, Group root){
        Circle c = createShootingRange(iv, 150);
        root.getChildren().addAll(c);
        iv.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                iv.setCursor(Cursor.HAND);
                iv.setX(event.getSceneX() - 35);
                iv.setY(event.getSceneY() - 35);
                c.setCenterX(iv.getX() + 30);
                c.setCenterY(iv.getY() + 30);
                c.setStroke(Color.RED);

                iv.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        c.setStroke(Color.RED);
                    }
                });

                iv.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        c.setStroke(Color.TRANSPARENT);
                    }
                });

                iv.toFront();
            }
        });

    }
}
