package Game.Stage;

import Game.Button.Game;
import Game.MainConfig;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Level extends GameStage {

    CreatLV creatLV = new CreatLV();
    Game game;

    public static Pane root = new Pane();
    public static Scene scene = new Scene(root);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start( Stage primaryStage ) throws Exception {
        primaryStage.setTitle("TOWER DEFENSE");
        Canvas canvas = new Canvas(64*15 + 15, 64*11);
        root.getChildren().addAll(canvas);

        scene.setFill(Color.rgb(192, 192, 192));
        GraphicsContext gc = canvas.getGraphicsContext2D();

        game = new Game(root , primaryStage);
        creatLV.drawMap(gc);
        creatLV.drawLine(root , MainConfig.lines);
        creatLV.CreatEnemy();
        creatLV.CreatTower();
        MainConfig.DrawTargetTowerDrag(root);

        primaryStage.getIcons().add( new Image("file:Source/Menu/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
