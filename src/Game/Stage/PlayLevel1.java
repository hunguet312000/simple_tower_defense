package Game.Stage;

import Game.Enemy.Plane;
import Game.Enemy.Soliders;
import Game.Enemy.Tank;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class PlayLevel1 {
    private List<Tank> tanks = new ArrayList<>();
    private List<Soliders> soliders = new ArrayList<>();
    private List<Plane> planes = new ArrayList<>();

    public PlayLevel1 ( int k ){
        tanks.add(new Tank(7*64 + 32 , 0));
        soliders.add( new Soliders(245, 7*64 + 32 , -64));
        soliders.add(new Soliders(246 , 7*64 + 32 , -64 - 32));
        soliders.add(new Soliders(247 , 7*64 + 32 , -64 - 32*2));
        soliders.add(new Soliders(248 , 7*64 + 32 , -64 - 32*3));
        planes.add(new Plane(7*64 + 32 , -128));
    }

    public void draw (GraphicsContext gc ){
        for ( Tank tank : tanks ) tank.draw(gc);
        for (Soliders sl : soliders ) sl.draw(gc);
        for ( Plane p : planes ) p.draw(gc);
    }

    public void update (){
       for ( int i = 0 ; i < tanks.size() ; i++ )
       {
           tanks.get(i).update();
           if ( tanks.get(i).getPosY() > 11*64 ) {
               tanks.remove(i);
           }
       }
       for ( int i = 0 ; i < soliders.size() ; i++ )
       {
           soliders.get(i).update();
           if ( soliders.get(i).getPosY() > 11*64 ) {
               soliders.remove(i);
           }
       }
       for ( int i = 0 ; i < planes.size() ; i++ )
       {
           planes.get(i).update();
           if ( planes.get(i).getPosY() > 11*64) planes.remove(i);
       }
    }
}
