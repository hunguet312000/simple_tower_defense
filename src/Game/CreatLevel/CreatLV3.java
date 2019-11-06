package Game.CreatLevel;

import Game.EnemyLV2.PlaneLV2;
import Game.EnemyLV2.SolidersLV2;
import Game.EnemyLV2.TankLV2;
import Game.EnemyLV3.PlaneLV3;
import Game.EnemyLV3.SolidersLV3;
import Game.EnemyLV3.TankLV3;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class CreatLV3 {
    private List<TankLV3> tanks = new ArrayList<>();
    private List<SolidersLV3> solidersLV3s = new ArrayList<>();
    private List <PlaneLV3> planeLV3s = new ArrayList<>();

    public CreatLV3 (){
    }

    public void draw (GraphicsContext gc ){
        for ( TankLV3 tank : tanks ) tank.draw(gc);
        for ( SolidersLV3 sl : solidersLV3s ) sl.draw(gc);
        for ( PlaneLV3 p : planeLV3s ) p.draw(gc);
    }

    public void update (){
        for ( int i = 0 ; i < tanks.size() ; i++ )
        {
            tanks.get(i).update();
            if ( tanks.get(i).getPosY() > 11*64 ) {
                tanks.remove(i);
            }
        }
        for ( int i = 0 ; i < solidersLV3s.size() ; i++ )
        {
            solidersLV3s.get(i).update();
            if ( solidersLV3s.get(i).getPosY() > 11*64 ) {
                solidersLV3s.remove(i);
            }
        }
        for ( int i = 0 ; i < planeLV3s.size() ; i++ )
        {
            planeLV3s.get(i).update();
            if ( planeLV3s.get(i).getPosY() > 11*64 ) {
                planeLV3s.remove(i);
            }
        }
    }

    public void spawnTroop(){
        tanks.add(new TankLV3());
        planeLV3s.add( new PlaneLV3(10*64 + 32 , -64));
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1500), event ->{
            solidersLV3s.add( new SolidersLV3( 247 , 10*64 + 32 , -64));
        }));
        timeline.setCycleCount(10);
        timeline.play();
    }
}
