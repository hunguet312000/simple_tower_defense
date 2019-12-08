package Game.Button;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class BaseButton {

    public void setButton(Button button, double posX, double posY, String text, int w, int h){
        button.setLayoutX(posX);
        button.setLayoutY(posY);
        button.setMinHeight(h);
        button.setMaxHeight(h);
        button.setMinWidth(w);
        button.setMaxWidth(w);
        button.setStyle("-fx-font-family: monospace ; -fx-font-size: 19px ;font-style : italic ;-fx-font-weight : bolder; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
        button.setText(text);
        button.setTextFill(Color.rgb(0, 255, 255));
    }

    public void setText(Text text, String value, double loX, double loY, Paint color){
        text.setText(value);
        text.setLayoutX(loX);
        text.setLayoutY(loY);
        text.setFill(color);
    }

}
