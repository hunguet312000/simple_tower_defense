package Game;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public final class MainConfig {

    public static final String[][] MAP_TILES1 = new String[][]{
            { "034" , "034" , "034" , "086" , "035" , "033" , "034" , "034" , "313" , "034" , "034" , "085" },
            { "034" , "313" , "034" , "034" , "035" , "056" , "057" , "057" , "057" , "057" , "014" , "034" },
            { "034" , "034" , "311" , "034" , "036" , "011" , "011" , "011" , "011" , "012" , "033" , "034" },
            { "024" , "024" , "043" , "024" , "024" , "024" , "326" , "024" , "024" , "163" , "161" , "024" },
            { "141" , "185" , "185" , "185" , "185" , "185" , "185" , "185" , "185" , "186" , "161" , "024" },
            { "163" , "138" , "139" , "139" , "139" , "139" , "139" , "139" , "139" , "139" , "165" , "024" },
            { "163" , "161" , "024" , "306" , "024" , "024" , "024" , "341" , "024" , "024" , "024" , "318" },
            { "242" , "240" , "241" , "241" , "314" , "220" , "264" , "264" , "264" , "264" , "264" , "221" },
            { "242" , "240" , "334" , "241" , "241" , "242" , "217" , "218" , "218" , "218" , "219" , "240" },
            { "242" , "263" , "264" , "264" , "264" , "265" , "240" , "303" , "241" , "114" , "242" , "240" },
            { "243" , "218" , "218" , "218" , "218" , "218" , "244" , "241" , "241" , "241" , "242" , "240" },
    };

    public static final Rectangle[][] TARGET_TOWER_DRAG = new Rectangle[MAP_TILES1.length][MAP_TILES1[0].length];

    public static final void DrawTargetTowerDrag(Pane root){
        for(int i = 0; i < MAP_TILES1.length; i++){
            for(int j = 0; j < MAP_TILES1[i].length; j++){
                TARGET_TOWER_DRAG[i][j] = new Rectangle(j*64, i*64, 64, 64);
                TARGET_TOWER_DRAG[i][j].setFill(Color.GRAY);
                TARGET_TOWER_DRAG[i][j].setVisible(false);
                if(MAP_TILES1[i][j].equals("024") || MAP_TILES1[i][j].equals("241") || MAP_TILES1[i][j].equals("034"))
                    root.getChildren().add(TARGET_TOWER_DRAG[i][j]);
            }
        }
    }

    public static final void setText(Text text, double posX, double posY , int r , int g , int b){
        text.setLayoutX(posX);
        text.setLayoutY(posY);
        text.setFont(Font.font("monospace", FontWeight.findByName("bold"), 23 ));
        text.setFill(Color.rgb(r, g, b));
    }

    public static final String[] TOWER_FILE = new String[]{
            "file:Source/Towers/towerDefense_tile1.png",
            "file:Source/Towers/towerDefense_tile2.png",
            "file:Source/Towers/towerDefense_tile4.png",
            "file:Source/Towers/towerDefense_tile5.png",
    };

    public static final String[] BULLET_FILE = new String[]{
            "file:Source/Towers/bullet1.png",
            "file:Source/Towers/bullet2.png",
            "file:Source/Towers/bullet3.png",
            "file:Source/Towers/bullet4.png",
            "file:Source/Towers/bullet5.png",
            "file:Source/Towers/bullet6.png",
    };

    public enum TOWERFORM{
        TOWER_TYPE1,
        TOWER_TYPE2,
        TOWER_TYPE3,
        TOWER_TYPE4,
    }

    public static final Line[] lines = {
            new Line(12*64, 2, 16*64+15, 2),
            new Line(12*64, 0, 12*64, 11*64),
            new Line(12*64, 11*64, 16*64+15, 11*64),
            new Line(16*64+15, 11*64, 16*64+15, 0),
            new Line(12*64, 4*64,16*64+15, 4*64),
    };

}
