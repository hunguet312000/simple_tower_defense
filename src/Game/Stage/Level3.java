package Game.Stage;

import Game.CreatLevel.CreatLV3;
import Game.Tower.TowerControl;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Level3 extends GameStage {
    CreatLV3 playLevel3 = new CreatLV3();


    public static final String[][] MAP_TILES3 = new String[][]{
            { "241" , "220" , "264" , "264" , "264" , "264" , "221" , "241" , "241" , "241" , "242" , "240" },
            { "241" , "242" , "217" , "218" , "218" , "219" , "240" , "241" , "220" , "264" , "265" , "240" },
            { "241" , "242" , "240" , "241" , "241" , "242" , "240" , "241" , "242" , "217" , "218" , "244" },
            { "241" , "242" , "240" , "241" , "241" , "242" , "263" , "264" , "265" , "240" , "241" , "241" },
            { "241" , "242" , "240" , "241" , "241" , "243" , "218" , "218" , "218" , "244" , "241" , "241" },
            { "241" , "242" , "263" , "264" , "221" , "241" , "241" , "241" , "241" , "241" , "241" , "241" },
            { "241" , "243" , "218" , "219" , "263" , "264" , "264" , "264" , "264" , "264" , "264" , "221" },
            { "241" , "241" , "241" , "243" , "218" , "218" , "218" , "218" , "218" , "218" , "219" , "240" },
            { "241" , "241" , "241" , "241" , "241" , "241" , "241" , "241" , "241" , "241" , "242" , "240" },
            { "264" , "264" , "264" , "264" , "264" , "264" , "264" , "264" , "264" , "264" , "265" , "240" },
            { "218" , "218" , "218" , "218" , "218" , "218" , "218" , "218" , "218" , "218" , "218" , "244" },
    };

    public static final double[] POS_X_TOWER = new double[]{ 12.1*64 + 15, 12.1*64 + 15, 12.1*64 + 15, 14*64, 14*64, 14*64};
    public static final double[] POS_Y_TOWER = new double[]{ 0, 1*64 + 15, 2*64 + 40, 0, 1*64 + 25, 2*64 + 40};
    public static final double[] POS_Y_BEHIND = new double[]{ 0, 1*64 + 15, 2*64 + 30, 0, 1*64 + 15, 2*64 + 30};

    public static final String[] TOWER_FILE = new String[]{
            "file:Source/Towers/towerDefense_tile250.png",
            "file:Source/Towers/towerDefense_tile249.png",
            "file:Source/Towers/towerDefense_tile205.png",
            "file:Source/Towers/towerDefense_tile204.png",
            "file:Source/Towers/towerDefense_tile206.png",
            "file:Source/Towers/towerDefense_tile226.png",
    };

    public void draw (GraphicsContext gc){
        String[][] map = MAP_TILES3;
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                gc.drawImage(new Image("file:Source/Landcape/towerDefense_tile"+ map[i][j] + ".png"), j * 64, i * 64);
            }
        }

        playLevel3.draw(gc);

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TowerControl towerControl = new TowerControl();

        primaryStage.setTitle("Game");
        Group root = new Group();
        Canvas canvas = new Canvas(64*15 + 15, 64*11);
        root.getChildren().addAll(canvas);
        Scene scene = new Scene(root);
        scene.setFill(Color.rgb(192, 192, 192));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc);

        Button next_level_button = new Button();
        setButton(next_level_button, 12.8*64, 3.5*64 + 25, "Next Level");

        Button update_button = new Button();
        setButton(update_button, 12.05*64, 9*64, "Update");

        Button sell_button = new Button();
        setButton(sell_button, 13.55*64, 9*64, "Sell");

        ImageView[] tower = new ImageView[6];
        ImageView[] behind = new ImageView[6];

        for(int i = 0; i < 6; i++){
            tower[i] = new ImageView();
            behind[i] = new ImageView();
            setImageButton(behind[i], POS_X_TOWER[i], POS_Y_BEHIND[i] + 12, "file:Source/Towers/towerDefense_tile180.png");
            setImageButton(tower[i], POS_X_TOWER[i], POS_Y_TOWER[i], TOWER_FILE[i]);
        }

        Button rect_button = new Button();
        rect_button.setLayoutX(12*64);
        rect_button.setLayoutY(4*64);
        rect_button.setMinHeight(5*64);
        rect_button.setMaxHeight(5*64);
        rect_button.setMinWidth(3*64);
        rect_button.setMaxWidth(3*64);

        Text dame = new Text();
        setText(dame, 12.05 * 64, 4.5 * 64 + 85);
        Text range = new Text();
        setText(range, 12.05 * 64, 5.5 * 64 + 85);
        Text level = new Text();
        setText(level, 12.05 * 64, 6.5 * 64 + 85);

        for(int i = 0; i < 6; i++){
            double x = tower[i].getX();
            double y = tower[i].getY();
            String num = String.valueOf(i + 1);
            String file = TOWER_FILE[i];
            tower[i].setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    ImageView iv = new ImageView();
                    setImageButton(iv, x, y, file);

                    buttonClick(iv, root, dame, range, level, num);
                    root.getChildren().addAll(iv);
                    towerControl.dragObject(iv, root);
                }
            });
        }

        root.getChildren().addAll(next_level_button, update_button, sell_button);
        for(int j = 0; j < 6; j++) root.getChildren().addAll(behind[j]);
        for(int j = 0; j < 6; j++) root.getChildren().addAll(tower[j]);

        next_level_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try{
                    AnimationTimer timer = new AnimationTimer() {
                        @Override
                        public void handle(long l) {
                            playLevel3.update();
                            draw(gc);
                        }
                    };
                    timer.start();
                    playLevel3.spawnTroop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void setButton(Button button, double posX, double posY, String text) {
        super.setButton(button, posX, posY, text);
        button.setMinHeight(30);
        button.setMaxHeight(30);
        button.setMinWidth(100);
        button.setMaxWidth(100);
        button.setStyle("-fx-font: 14 broadway; -fx-base: #ee2211; -fx-base: rgb(0, 128, 128);");
        button.setTextFill(Color.rgb(0, 255, 255));
    }

    public void setImageButton(ImageView iv, double posX, double posY, String file){
        iv.setImage(new Image(file));
        iv.setX(posX);
        iv.setY(posY);
        //root.getChildren().addAll(iv);
    }

    public void setText(Text text, double posX, double posY){
        text.setLayoutX(posX);
        text.setLayoutY(posY);
        text.setFont(Font.font("arial", 20));
        text.setFill(Color.rgb(0, 128, 255));
    }

    public void buttonClick(ImageView iv, Group root, Text text1, Text text2, Text text3, String num){
        iv.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().removeAll(text1, text2, text3);
                text1.setText("Damage " + num + ": ");
                text2.setText("Range " + num + ": ");
                text3.setText("Level " + num + ": ");
                root.getChildren().addAll(text1, text2, text3);
                iv.setCursor(Cursor.HAND);
            }
        });
        iv.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().removeAll(text1, text2, text3);
            }
        });
    }
}
