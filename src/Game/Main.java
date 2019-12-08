package Game;

import Game.Stage.GameStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameStage gs = new GameStage();
        gs.start(new Stage());
    }
}
