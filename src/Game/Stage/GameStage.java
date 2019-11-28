package Game.Stage;

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
    public static void main(String[] args) {
        launch(args);
    }
        public void setButton(Button button, double posX, double posY, String text){
        button.setLayoutX(posX);
        button.setLayoutY(posY);
        button.setMinHeight(45);
        button.setMaxHeight(45);
        button.setMinWidth(160);
        button.setMaxWidth(160);
        button.setStyle("-fx-font: 17 broadway; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
        button.setText(text);
        button.setTextFill(Color.rgb(0, 255, 255));
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game");
        Group root = new Group();
        Canvas canvas = new Canvas(444, 560);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(new Image("file:Source/Menu/GameStart.png"),0, 0);
        gc.drawImage(new Image("file:Source/Menu/MainIcon.png"), 70, 60);

        Button start_button = new Button();
        setButton(start_button, 150, 270, "Start");
        Button exit_button = new Button();
        setButton(exit_button, 150, 430, "Exit");
        Button instruction_button = new Button();
        setButton(instruction_button, 150, 350, "Instruction");

        Button level1 = new Button();
        setButton(level1, 150, 270, "Level 1");
        Button level2 = new Button();
        setButton(level2, 150, 350, "Level 2");
        Button level3 = new Button();
        setButton(level3, 150, 430, "Level 3");
        Button back_button = new Button();
        setButton(back_button, 150, 500, "Back");

        root.getChildren().addAll(canvas, start_button, exit_button, instruction_button);

        // if start button is clicked
        start_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Level level = new Level();
                try {
                    level.start(new Stage());
                    primaryStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //if exit button is clicked
        exit_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.close();
            }
        });

        //if back button is clicked
        back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().clear();
                root.getChildren().addAll(canvas, start_button, exit_button, instruction_button);
            }
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}