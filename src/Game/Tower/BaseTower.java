package Game.Tower;

import Game.Object.GameObject;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
public abstract class BaseTower  {
    double posX;
    double posY;
    ImageView tower;

    int price;
    int damage;
    int range;

    public BaseTower(Group root, double posX, double posY, ImageView tower, int price, int damage, int range) {
        this.posX = posX;
        this.posY = posY;
        this.tower = tower;
        this.tower.setCursor(Cursor.HAND);
        this.price = price;
        this.damage = damage;
        this.range = range;

        this.tower.setLayoutX(this.posX);
        this.tower.setLayoutY(this.posY - 5);
    }

    public ImageView getTower() {
        return tower;
    }

    public int getPrice() {
        return price;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    protected void setText(Text text, double posX, double posY){
        text.setLayoutX(posX);
        text.setLayoutY(posY);
        text.setFont(Font.font("arial", 20));
        text.setFill(Color.rgb(0, 128, 255));
    }

    abstract public void showInfo(Group root);
}
