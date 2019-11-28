package Game.Stage;

import Game.Enemy.BaseEnemy;
import Game.Enemy.Plane;
import Game.Enemy.Soliders;
import Game.Enemy.Tank;
import Game.MainConfig;
import Game.Object.GameObject;
import Game.Object.Player;
import Game.Tower.MainTower;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

public class CreatLV  {
    private List<Tank> tanks = new ArrayList<>();
    private List<Soliders> soliders = new ArrayList<>();
    private List <Plane> planes = new ArrayList<>();
    public Player player = new Player();
    public static int level = 1;

    public void draw (GraphicsContext gc ){
        for ( Tank tank : tanks ) tank.draw(gc);
        for ( Soliders sl : soliders ) sl.draw(gc);
        for ( Plane plane : planes ) plane.draw(gc);
    }

    public void update (){
        for ( int i = 0 ; i < tanks.size() ; i++ )
        {
            tanks.get(i).update();
            if ( tanks.get(i).getPos_y() > 10*64 ) {
                tanks.remove(i);
                int k1 = player.getLives() - 1;
                player.setLives(k1);
            }
        }
        for ( int i = 0 ; i < soliders.size() ; i++ )
        {
            soliders.get(i).update();
            if ( soliders.get(i).getPos_y() > 10*64 ) {
                soliders.remove(i);
                int k2 = player.getLives() - 1;
                player.setLives(k2);
            }
        }
        for ( int i = 0 ; i < planes.size() ; i++ )
        {
            planes.get(i).update();
            if ( planes.get(i).getPos_y() > 10*64 ) {
                planes.remove(i);
                int k3 = player.getLives() - 1;
                player.setLives(k3);
            }
        }
    }

    public void lose ( Stage primaryStage ) {
        if ( player.getLives() == 0 ) primaryStage.close();
    }

    public void CreatEnemy (){
        Timeline test  = new Timeline(new KeyFrame(Duration.seconds(6), event-> {
            spawnLevel( level );
            level += 1;

            for ( Tank tank : tanks)
                tank.increaseHealthTank(level);

            for ( Soliders sl : soliders )
                sl.increaseHealthSL(level);

            for ( Plane pl : planes )
                pl.increaseHealthPL(level);


        }));
        test.setCycleCount(Animation.INDEFINITE);
        test.play();
    }

    private Timeline enemySpawning ;

    public void spawnLevel ( int level){
        if ( level % 10 == 0 ) spawnTank();
        if ( level % 7 == 0 ) spawPlane();
        if ( level % 2 != 0  && level != 9 && level != 11 && level != 19 && level != 21 && level != 29 && level != 31) spawnSoliders();
    }

    public void spawnTank (){
        enemySpawning = new Timeline(new KeyFrame(Duration.seconds(2.5), event ->{
            tanks.add( new Tank());
        }));
        enemySpawning.setCycleCount(1);
        enemySpawning.play();
    }

    public void spawnSoliders (){
        enemySpawning = new Timeline(new KeyFrame(Duration.seconds(2.5), event ->{
            soliders.add( new Soliders());
        }));
        enemySpawning.setCycleCount(5);
        enemySpawning.play();
    }

    public void spawPlane (){
        enemySpawning = new Timeline(new KeyFrame(Duration.seconds(2.5), event ->{
            planes.add( new Plane() );
        }));
        enemySpawning.setCycleCount(3);
        enemySpawning.play();
    }

    public void CreatTower( Group root , Scene scene ){
        MainTower[] baseTowers = new MainTower[6];
        for(int i = 0; i < 6; i++){
            baseTowers[i] = new MainTower(root, MainConfig.POS_X_TOWER[i], MainConfig.POS_Y_TOWER[i], new ImageView(new Image(MainConfig.TOWER_FILE[i])),
                    MainConfig.COST_OF_TOWERS[i], MainConfig.DAMAGE_OF_TOWERS[i], MainConfig.RANGE_OF_TOWERS[i]);
            baseTowers[i].showInfo(root);
            baseTowers[i].dragObject(root, scene, MainConfig.MAP_TILES1);
            root.getChildren().addAll(baseTowers[i].getTower());
        }
    }

}
