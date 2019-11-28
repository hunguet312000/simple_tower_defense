package Game.Object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HealthBar extends GameObject implements UpdatableObject {
    private int health, temphealth;

    public HealthBar(int pos_x, int pos_y) {
        super(pos_x, pos_y);
        health = 30;
        temphealth = 30;
    }

    public void draw (GraphicsContext gc ){
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine( pos_x , pos_y , pos_x + temphealth , pos_y );

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine( pos_x + temphealth , pos_y , pos_x + temphealth , pos_y + 3.5 );

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(pos_x + temphealth , pos_y + 3.5 , pos_x , pos_y + 3.5 );

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(pos_x , pos_y + 3.5, pos_x , pos_y );

        gc.setFill(Color.RED);
        gc.fillRect(pos_x , pos_y , temphealth , 3.5);

        gc.setFill(Color.GREEN);
        gc.fillRect(pos_x , pos_y , temphealth , 3.5);


    }

    @Override
    public void update() {
    }

    public int getHealth() {
        return health;
    }

    public int getTemphealth() {
        return temphealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setTemphealth(int temphealth) {
        this.temphealth = temphealth;
    }
}
