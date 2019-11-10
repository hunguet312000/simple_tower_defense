package Game.CreatLevel;

import Game.EnemyLV1.PlaneLV1;
import Game.EnemyLV1.SolidersLV1;
import Game.EnemyLV1.TankLV1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class CreatLV1 {
    private List<TankLV1> tanks = new ArrayList<>();
    private List<SolidersLV1> solidersLV1s = new ArrayList<>();
    private List <PlaneLV1> planeLV1s = new ArrayList<>();

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
            }
        }
        for ( int i = 0 ; i < solidersLV1s.size() ; i++ )
        {
            solidersLV1s.get(i).update();
            if ( solidersLV1s.get(i).getPos_y() > 11*64 ) {
                solidersLV1s.remove(i);
            }
        }
        for ( int i = 0 ; i < planeLV1s.size() ; i++ )
        {
            planeLV1s.get(i).update();
            if ( planeLV1s.get(i).getPos_y() > 11*64 ) {
                planeLV1s.remove(i);
            }
        }
    }

    public void spawnTroop(){
        tanks.add(new TankLV1());
        planeLV1s.add( new PlaneLV1(7*64 + 32 , -64));
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1500), event ->{
            solidersLV1s.add( new SolidersLV1( 245 , 7*64 + 32 , -64));
        }));
        timeline.setCycleCount(10);
        timeline.play();
    }
}
