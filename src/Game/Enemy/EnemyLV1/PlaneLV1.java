package Game.Enemy.EnemyLV1;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
public class PlaneLV1 extends BaseEnemyLV1 {
    private Image shadow;

    public PlaneLV1 ( int pos_x , int pos_y){
        super(-60);
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        speed = -2;
        direction = Direction.UP;
        image = new Image("file:Source/Enemy/Weapons/towerDefense_tile271.png");
        shadow = new Image("file:Source/Enemy/Weapons/towerDefense_tile294.png");
    }
    public void increaseHealthPL (int level) { setHp( -60 + level*30 );}

    public void draw (GraphicsContext gc){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(shadow);
        iv.setRotate(30);
        Image base = iv.snapshot(params, null);
        ImageView iv2 = new ImageView(image);
        iv2.setRotate(30);
        Image base2 = iv2.snapshot(params, null);
        gc.drawImage(base, pos_x + 10, pos_y + 10);
        gc.drawImage(base2, pos_x, pos_y);
        if (healthBar !=null)
            healthBar.draw(gc);
    }

    public void update(){
        pos_x += speed + 5;
        pos_y += speed + 5;
        healthBar.setPos_y(pos_y + 15);
        healthBar.setPos_x(pos_x + 15);
        setHealthBar(getHealthBar());
    }
}
