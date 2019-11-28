package Game.Enemy;

import javafx.scene.image.Image;

public class Tank extends BaseEnemy {
    private int random = (int) (Math.random()*2);

    public Tank (){
        super(4*64 + 32 , -64 , -100 , 1 , Direction.UP);
        if ( random % 2 == 0 ) {
            image = new Image("file:Source/Enemy/Weapons/towerDefense_tile268.png");
        }else image = new Image("file:Source/Enemy/Weapons/towerDefense_tile269.png");
    }

    public void increaseHealthTank ( int level ) { setHp( -100 + level*100);}
}
