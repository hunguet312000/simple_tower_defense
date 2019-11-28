package Game.Enemy;

import javafx.scene.image.Image;

public class Soliders extends  BaseEnemy {
    private int random = (int) (Math.random()*12);

    public Soliders (){
        super(4*64 + 32 , -64 ,15 , 1.5 , Direction.UP);
       if ( random % 4 == 0) image = new Image("file:Source/Enemy/Soliders/towerDefense_tile245.png");
       else if ( random % 4 == 1 ) image = new Image("file:Source/Enemy/Soliders/towerDefense_tile246.png");
       else if ( random % 4 == 2 ) image = new Image("file:Source/Enemy/Soliders/towerDefense_tile247.png");
       else if ( random % 4 == 3 ) image = new Image("file:Source/Enemy/Soliders/towerDefense_tile248.png");
    }

    public void increaseHealthSL (int level) { setHp( 15 + level*15 );}
}
