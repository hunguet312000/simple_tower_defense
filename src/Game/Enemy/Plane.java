package Game.Enemy;

import javafx.scene.image.Image;

public class Plane extends BaseEnemy{
    private int random = (int) (Math.random()*2);

    public Plane (){
        super(0 , 0 ,-60 , -2 , Direction.RD);
        if ( random % 2 == 0 ) image = new Image("file:Source/Enemy/Weapons/towerDefense_tile271.png");
        else if ( random % 2 != 0 ) image = new Image("file:Source/Enemy/Weapons/towerDefense_tile270.png");
    }
    public void increaseHealthPL (int level) { setHp( -60 + level*30 );}

    public void update(){
        pos_x += speed + 5;
        pos_y += speed + 5;
        healthBar.setPos_y(pos_y + 15);
        healthBar.setPos_x(pos_x + 15);
        setHealthBar(getHealthBar());
    }
}
