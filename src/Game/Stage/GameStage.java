package Game.Stage;

import Game.Button.Menu;
import Game.Object.Music;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class GameStage extends Application  {

    Menu menu;
    public static boolean isGameOver = false;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("TOWER DEFENSE");
        Group root = new Group();
        Canvas canvas = new Canvas(975, 650);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if(isGameOver == true){
            gc.drawImage(new Image("file:Source/Menu/game-over.png", 975, 650, false, false), 0, 0);
            menu = new Menu(root, primaryStage, canvas, true);
        }else {
            gc.drawImage(new Image("file:Source/Menu/main_menu.png"), 0, 0);
            menu = new Menu(root, primaryStage, canvas, false);

        }
        Scene scene = new Scene(root);
        primaryStage.getIcons().add( new Image("file:Source/Menu/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}