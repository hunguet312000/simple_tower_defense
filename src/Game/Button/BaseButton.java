package Game.Button;

import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class BaseButton {

    public void setText(Text text, String value, double loX, double loY, Paint color){
        text.setText(value);
        text.setLayoutX(loX);
        text.setLayoutY(loY);
        text.setFill(color);
    }
}
