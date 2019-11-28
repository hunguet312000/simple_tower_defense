package Game;

import java.awt.*;
import javafx.scene.image.Image;

public final class MainConfig {
    public static final int[] DAMAGE_OF_TOWERS = new int[] {20, 14, 20, 14, 18, 16};
    public static final int[] RANGE_OF_TOWERS = new int[] {80, 70, 120, 150, 100, 90};
    public static final int[] COST_OF_TOWERS = new int[] {70, 50, 80, 60, 70, 100};
    public static final double[] POS_X_TOWER = new double[]{ 12.1*64 + 15, 12.1*64 + 15, 12.1*64 + 15, 14*64, 14*64, 14*64};
    public static final double[] POS_Y_TOWER = new double[]{ 0, 1*64 + 15, 2*64 + 40, 0, 1*64 + 15, 2*64 + 40};
    public static final double[] POS_Y_BEHIND = new double[]{ 0, 1*64 + 15, 2*64 + 30, 0, 1*64 + 15, 2*64 + 30};
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

    public static final String[] TOWER_FILE = new String[]{
            "file:Source/Towers/towerDefense_tile250.png",
            "file:Source/Towers/towerDefense_tile249.png",
            "file:Source/Towers/towerDefense_tile205.png",
            "file:Source/Towers/towerDefense_tile204.png",
            "file:Source/Towers/towerDefense_tile206.png",
            "file:Source/Towers/towerDefense_tile226.png",
    };
    public static final Point[] wayPoint1 = new Point[]{
            new Point(4*64 + 32 , -64),
            new Point(4*64 + 32 , 0),
            new Point(4*64 + 32 , 1*64 + 32),
            new Point (9*64 + 32, 1*64 + 32),
            new Point(9*64 + 32 , 4*64 + 32),
            new Point( 0*64 + 32 ,4*64 + 32),
            new Point(0*64 + 32 , 9*64 + 32),
            new Point( 5*64 + 32 , 9*64 + 32),
            new Point( 5*64 + 32 , 7*64 + 32),
            new Point( 10*64 + 32 , 7*64 + 32),
            new Point( 10*64 + 32 , 10*64),
    };
}
