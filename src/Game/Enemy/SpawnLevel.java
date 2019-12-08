package Game.Enemy;

import Game.Stage.Level;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.ArrayList;

public class SpawnLevel extends Pane {
    public static int level = 0;
    public static ArrayList<BaseEnemy> enemies = new ArrayList<>();
    public static Timeline timeline;

    public SpawnLevel(){};

    public void NumberSpawn ( int number , String type){
       timeline = new Timeline( new KeyFrame(Duration.seconds(1) , event -> {
           if( type.equals("tank1") ) enemies.add( new Tank(268));
           if( type.equals("tank2")) enemies.add( new Tank(269));
           if ( type.equals("soliders1")) enemies.add( new Soliders(245));
           if ( type.equals("soliders2")) enemies.add( new Soliders(246));
           if ( type.equals("soliders3")) enemies.add( new Soliders(247));
           if ( type.equals("soliders4")) enemies.add( new Soliders(248));
           if ( type.equals("plane1")) enemies.add( new Plane(270));
           if ( type.equals("plane2")) enemies.add( new Plane(271));
           for ( BaseEnemy enemy : enemies ){
               enemy.increaseHealth(SpawnLevel.level);
               enemy.increaseSpeed(SpawnLevel.level);
           }
           Level.root.getChildren().add(enemies.get(enemies.size() - 1));
       }));
       timeline.setCycleCount(number);
       timeline.play();
    }

    public void SpawnLV ( int level ){
        switch (level){
            case 0:
                NumberSpawn( 5 , "soliders1");
                break;
            case 1: break;
            case 2 : break;
            case 3:
                NumberSpawn( 6 , "soliders2");
                break;
            case 4 : break;
            case 5 : break;
            case 6:
                NumberSpawn(1 , "tank1");
                break;
            case 7 : break;
            case 8 : break;
            case 9:
                NumberSpawn( 1 , "tank2");
                break;
            case 10 : break;
            case 11 : break;
            case 12:
                NumberSpawn(5 , "plane1");
                break;
            case 13 : break;
            case 14 : break;
            case 15 :
                NumberSpawn( 8 , "soliders4");
                break;
            case 16 : break;
            case 17 : break;
            case 18:
                NumberSpawn( 5 , "soliders2");
                NumberSpawn( 5 , "plane2");
                break;
            case 19 : break;
            case 20 : break;
            case 21:
                NumberSpawn( 5 , "plane1");
                break;
            case 22 : break;
            case 23 : break;
            case 24:
                NumberSpawn(5 , "plane2");
                break;
            case 25 : break;
            case 26 : break;
            case 27:
                NumberSpawn( 10 , "soliders3");
                break;
            case 28 : break;
            case 29 : break;
            case 30:
                NumberSpawn(1 , "tank1");
                NumberSpawn( 4 , "plane2");
                break;
            case 31 : break;
            case 32 : break;
            case 33:
                NumberSpawn(5 , "plane1");
                break;
            case 34 : break;
            case 35 : break;
            case 36:
                NumberSpawn(10 , "soliders2");
                break;
            case 37 : break;
            case 38 : break;
            case 39:
                NumberSpawn(10 , "soliders3");
                break;
            case 40 : break;
            case 41 : break;
            case 42:
                NumberSpawn(11 , "soliders4");
                break;
            case 43 : break;
            case 44 : break;
            case 45:
                NumberSpawn(12 , "soliders1");
                break;
            case 46 : break;
            case 47 : break;
            case 48:
                NumberSpawn( 6 , "plane2");
                break;
            case 49 : break;
            case 50 : break;
            case 51:
                NumberSpawn( 6 , "plane1");
                break;
            case 52 : break;
            case 53 : break;
            case 54:
                NumberSpawn(1 , "tank2");
                break;
            case 55 : break;
            case 56 : break;
            case 57:
                NumberSpawn(6 , "plane2");
                break;
            case 58: break;
            case 59 :
                NumberSpawn(10 , "soliders1");
                break;
            case 60: break;
            case 61:
                NumberSpawn(10 , "soliders2");
                break;
            case 62 : break;
            case 63:
                NumberSpawn(10 , "soliders4");
                break;
            case 64 : break;
            case 65:
                NumberSpawn(10 , "soliders3");
                break;
            case 66 : break;
            case 67:
                NumberSpawn(1 , "tank1");
                NumberSpawn(5 , "plane2");
                break;
            case 68: break;
            case 69:
                NumberSpawn(1 , "tank2");
                NumberSpawn(5 , "plane1");
                break;
            case 70 : break;
            case 71:
                NumberSpawn(15 , "plane1");
                break;
            case 72: break;
            case 73 :
                NumberSpawn(15 , "plane2");
                break;
        }
    }
}
