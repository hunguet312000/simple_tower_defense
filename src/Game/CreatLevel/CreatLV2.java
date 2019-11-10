package Game.CreatLevel;

import Game.EnemyLV2.PlaneLV2;
import Game.EnemyLV2.SolidersLV2;
import Game.EnemyLV2.TankLV2;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class CreatLV2 {
    private List<TankLV2> tanks = new ArrayList<>();
    private List<SolidersLV2> solidersLV2s = new ArrayList<>();
    private List <PlaneLV2> planeLV2s = new ArrayList<>();

    public CreatLV2 (){
    }

    public void draw (GraphicsContext gc ){
        for ( TankLV2 tank : tanks ) tank.draw(gc);
        for ( SolidersLV2 sl : solidersLV2s ) sl.draw(gc);
        for ( PlaneLV2 p : planeLV2s ) p.draw(gc);
    }

    public void update (){
        for ( int i = 0 ; i < tanks.size() ; i++ )
        {
            tanks.get(i).update();
            if ( tanks.get(i).getPos_y() > 11*64 ) {
                tanks.remove(i);
            }
        }
        for ( int i = 0 ; i < solidersLV2s.size() ; i++ )
        {
            solidersLV2s.get(i).update();
            if ( solidersLV2s.get(i).getPos_y() > 11*64 ) {
                solidersLV2s.remove(i);
            }
        }
        for ( int i = 0 ; i < planeLV2s.size() ; i++ )
        {
            planeLV2s.get(i).update();
            if ( planeLV2s.get(i).getPos_y() > 11*64 ) {
                planeLV2s.remove(i);
            }
        }
    }

    public void spawnTroop(){
        tanks.add(new TankLV2());
        planeLV2s.add( new PlaneLV2(4*64 + 32 , -64));
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1500), event ->{
            solidersLV2s.add( new SolidersLV2( 246 , 4*64 + 32 , -64));
        }));
        timeline.setCycleCount(10);
        timeline.play();
    }
}
