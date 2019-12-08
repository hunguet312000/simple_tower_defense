package Game.Button;

import Game.Object.Player;
import Game.Stage.Level;
import Game.Tower.BaseTower;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TowerSetting {
    public Rectangle[] towerButton = new Rectangle[2];
    public Label[] text = new Label[2];
    public TowerSetting(BaseTower baseTower){
        setTowerButton();
        refundOrUpgradeTower(baseTower);
    }
    public void setTowerButton(){
        towerButton[0] = new Rectangle(100, 35, Color.rgb(0, 128, 128, 0.2));
        towerButton[1] = new Rectangle(108, 35, Color.rgb(0, 128, 128, 0.2));
        text[0] = new Label("Refund");
        text[1] = new Label("Upgrade");

        for(int i = 0; i < 2; i++){
            towerButton[i].setStrokeWidth(2);
            towerButton[i].setStroke(Color.rgb(0, 128, 128));
            towerButton[i].setArcHeight(30);
            towerButton[i].setArcWidth(30);
            text[i].setTextFill(Color.rgb(0, 128, 128));
            text[i].setStyle("-fx-font-family: monospace; -fx-font-size: 20px; font-style: italic; -fx-font-weight: bold;");
            towerButton[i].setVisible(false);
            text[i].setVisible(false);
        }
        Level.root.getChildren().addAll(text[0], text[1], towerButton[0], towerButton[1]);
    }

    public void eraseTowerButton(){
        for(int i = 0; i < 2; i++){
            text[i].setVisible(false);
            towerButton[i].setVisible(false);
        }
    }

    public void setPosition(double x, double y){
        towerButton[1].setLayoutX(x - 64);
        towerButton[1].setLayoutY(y - 30);
        towerButton[0].setLayoutX(x + 45);
        towerButton[0].setLayoutY(y - 30);
        text[1].setLayoutX(towerButton[1].getLayoutX() + 12);
        text[1].setLayoutY(towerButton[1].getLayoutY() + 4);
        text[0].setLayoutX(towerButton[0].getLayoutX() + 12);
        text[0].setLayoutY(towerButton[0].getLayoutY() + 4);
    }

    public void setEffectTowerButton(){
        for(int i = 0; i < 2; i++){
            int x = i;
            text[x].setVisible(true);
            towerButton[x].setVisible(true);
            towerButton[i].setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    text[x].setTextFill(Color.WHITE);
                    towerButton[x].setFill(Color.rgb(0, 128, 128, 0.5));
                }
            });
            towerButton[i].setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    text[x].setTextFill(Color.rgb(0, 128, 128));
                    towerButton[x].setFill(Color.rgb(0, 128, 128, 0.2));
                    Game.notice.setVisible(false);
                }
            });
        }
    }
    public void refundOrUpgradeTower(BaseTower baseTower) {
        baseTower.getBase_tower().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    baseTower.getBase_tower().setEffect(new Glow());
                    setEffectTowerButton();
                    towerButton[0].setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Player.moneys += baseTower.getPriceTower() / 2;
                            baseTower.eraseTower();
                            eraseTowerButton();
                            towerButton[0].setOnMousePressed(null);
                            towerButton[1].setOnMousePressed(null);
                        }
                    });

                    towerButton[1].setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            baseTower.getShootRange().setVisible(true);
                            if (Player.moneys >= baseTower.upgradeCost) {
                                Player.moneys -= baseTower.upgradeCost;
                                baseTower.setTowerDamage(baseTower.getTowerDamage() + 20);
                                baseTower.setTowerDamage(baseTower.getTowerDamage() + 20);
                                baseTower.setRange(baseTower.getRange() + 20);
                                baseTower.getShootRange().setRadius(baseTower.getRange());
                                baseTower.upgradeCost += (baseTower.upgradeCost / 2);
                            } else {
                                Game.notice.setVisible(true);
                            }
                        }
                    });
                } else if (event.getClickCount() == 1) {
                    for (int i = 0; i < 2; i++) {
                        text[i].setVisible(false);
                        towerButton[i].setVisible(false);
                    }
                }
            }
        });
    }
}
