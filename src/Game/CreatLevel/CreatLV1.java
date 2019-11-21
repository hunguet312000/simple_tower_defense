package Game.CreatLevel;

import Game.Enemy.EnemyLV1.PlaneLV1;
import Game.Enemy.EnemyLV1.SolidersLV1;
import Game.Enemy.EnemyLV1.TankLV1;
import Game.Object.Player;
import Game.Stage.Level1;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class CreatLV1  {
    private List<TankLV1> tanks = new ArrayList<>();
    private List<SolidersLV1> solidersLV1s = new ArrayList<>();
    private List <PlaneLV1> planeLV1s = new ArrayList<>();
    public Player player = new Player();
    public static int level = 1;

    public CreatLV1 (){
    }

    public void draw (GraphicsContext gc ){
        for ( TankLV1 tank : tanks ) tank.draw(gc);
        for ( SolidersLV1 sl : solidersLV1s ) sl.draw(gc);
        for ( PlaneLV1 p : planeLV1s ) p.draw(gc);
    }

    public void update (){
        for ( int i = 0 ; i < tanks.size() ; i++ )
        {
            tanks.get(i).update();
            if ( tanks.get(i).getPos_y() > 11*64 ) {
                tanks.remove(i);
                int k1 = player.getLives() - 1;
                player.setLives(k1);
            }
        }
        for ( int i = 0 ; i < solidersLV1s.size() ; i++ )
        {
            solidersLV1s.get(i).update();
            if ( solidersLV1s.get(i).getPos_y() > 11*64 ) {
                solidersLV1s.remove(i);
                int k2 = player.getLives() - 1;
                player.setLives(k2);
            }
        }
        for ( int i = 0 ; i < planeLV1s.size() ; i++ )
        {
            planeLV1s.get(i).update();
            if ( planeLV1s.get(i).getPos_y() > 11*64 ) {
                planeLV1s.remove(i);
                int k3 = player.getLives() - 1;
                player.setLives(k3);
            }
        }
    }

    public void lose ( Stage primaryStage ) {
       if ( player.getLives() == 0 ) primaryStage.close();
    }

    private Timeline enemySpawning ;

    public void CreatEnemy (){
        Timeline test  = new Timeline(new KeyFrame(Duration.seconds(7), event-> {
            spawnLevel( level );
            level += 1;

            for ( TankLV1 tank : tanks)
                tank.increaseHealthTank(level);

            for ( SolidersLV1 sl : solidersLV1s )
                sl.increaseHealthSL(level);

            for ( PlaneLV1 pl : planeLV1s )
                pl.increaseHealthPL(level);


        }));
        test.setCycleCount(Animation.INDEFINITE);
        test.play();
    }

    public void spawnLevel ( int level){
        if (level == 10 || level == 25 ) spawnTank();
        if ( level == 5 || level == 10 || level == 15 || level == 25 ) spawPlane();
        if ( level % 5 != 0) spawnSoliders();
    }

    public void spawnTank (){
        enemySpawning = new Timeline(new KeyFrame(Duration.seconds(2.5), event ->{
            tanks.add( new TankLV1());
        }));
        enemySpawning.setCycleCount(1);
        enemySpawning.play();
    }


    public void spawnSoliders (){
        enemySpawning = new Timeline(new KeyFrame(Duration.seconds(2.5), event ->{
            solidersLV1s.add( new SolidersLV1( 245 , 7*64 + 32 , -64));
        }));
        enemySpawning.setCycleCount(2);
        enemySpawning.play();
    }

    public void spawPlane (){
        enemySpawning = new Timeline(new KeyFrame(Duration.seconds(2.5), event ->{
            planeLV1s.add( new PlaneLV1(0 , 0) );
        }));
        enemySpawning.setCycleCount(3);
        enemySpawning.play();
    }

}
