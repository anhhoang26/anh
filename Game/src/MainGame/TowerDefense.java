package MainGame;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import GameSetting.*;
import Object.*;
import Turret.*;
import Enemys.*;

public class TowerDefense extends Application {

    public static GraphicsContext gc;
    public static Group root;
    public static Boolean isPlaying = false;
    public static List<Enemy> enemys = new ArrayList<>();
    public static List<Tower> towers = new ArrayList<>();
    public static Scene scene;
    public static String properties[][] = new String[20][20];
    public static List<Bullet> bullets = new ArrayList<>();
    public static CreatMap map = new CreatMap();
    public static int turn = 0;
    public static int gold = 3000;
    public static int health = 1;
    public static String proper = "";
    public static boolean start = false;
    public VBox buttuonstart = new VBox(20);
    public HBox selectMap = new HBox(65);
    public int semap;
    public static Text[] texts = new Text[7];
    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800, 650);
        gc = canvas.getGraphicsContext2D();
        root = new Group();
        root.getChildren().add(canvas);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tower Defense");
        stage.show();

        buttuonstart.setTranslateX(280);
        buttuonstart.setTranslateY(250);
        Image image = new Image("file:src/AssetsKit_1/shapes/Tower Defense.png");
        ImageView imageBack = new ImageView(image);
        ImageView imageView;

        root.getChildren().add(imageBack);
        selectMap.setTranslateX(150);
        selectMap.setTranslateY(350);
        image = new Image("file:src/AssetsKit_1/shapes/21.png");
        imageView = new ImageView(image);
        Gamebutton.MenuButton map1 = new Gamebutton.MenuButton(imageView);
        map1.setOnMouseClicked(mouseEvent -> {
            CreatSound.playMedia("src/AssetsKit_1/sounds/7_click.mp3");
            map.Map(1);
            semap = 1;
            root.getChildren().remove(imageBack);
            playGame();
            root.getChildren().remove(selectMap);
        });

        image = new Image("file:src/AssetsKit_1/shapes/24.png");
        imageView = new ImageView(image);
        Gamebutton.MenuButton map2 = new Gamebutton.MenuButton(imageView);
        map2.setOnMouseClicked(mouseEvent -> {
            map.Map(2);
            CreatSound.playMedia("src/AssetsKit_1/sounds/7_click.mp3");
            semap = 2;
            root.getChildren().remove(imageBack);
            playGame();
            root.getChildren().remove(selectMap);
        });

        image = new Image("file:src/AssetsKit_1/shapes/27.png");
        imageView = new ImageView(image);
        Gamebutton.MenuButton map3 = new Gamebutton.MenuButton(imageView);
        map3.setOnMouseClicked(mouseEvent -> {
            map.Map(3);
            semap = 3;
            CreatSound.playMedia("src/AssetsKit_1/sounds/7_click.mp3");
            root.getChildren().remove(imageBack);
            playGame();
            root.getChildren().remove(selectMap);
        });
        selectMap.getChildren().addAll(map1, map2, map3);
        image = new Image("file:src/AssetsKit_1/buttons/DefineButton2_15/startButton.png");
        imageView = new ImageView(image);
        Gamebutton.MenuButton startButton = new Gamebutton.MenuButton(imageView);
        startButton.setOnMouseClicked(mouseEvent -> {
            root.getChildren().remove(buttuonstart);
            CreatSound.playMedia("src/AssetsKit_1/sounds/7_click.mp3");
            root.getChildren().add(selectMap);
                });
        image = new Image("file:src/AssetsKit_1/buttons/DefineButton2_15/exitButton.png");
        imageView = new ImageView(image);
        Gamebutton.MenuButton exitButton = new Gamebutton.MenuButton(imageView);
        exitButton.setOnMouseClicked(mouseEvent -> {
            CreatSound.playMedia("src/AssetsKit_1/sounds/7_click.mp3");
            System.exit(0);
        });
        image = new Image("file:src/AssetsKit_1/buttons/DefineButton2_15/resumeButton.png");
        imageView = new ImageView(image);
        Gamebutton.MenuButton resumeButton = new Gamebutton.MenuButton(imageView);
        resumeButton.setOnMouseClicked(mouseEvent -> {
            CreatSound.playMedia("src/AssetsKit_1/sounds/7_click.mp3");
            System.exit(0);
        });
        buttuonstart.getChildren().addAll(startButton, resumeButton, exitButton);
        Gamebutton.Mainmenubutton.setOnMouseClicked(mouseEvent -> {

        });
        root.getChildren().add(buttuonstart);
    }

    private void playGame(){
        Gamebutton gamebutton = new Gamebutton();
        createText();
        root.getChildren().add(gamebutton);
            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    Timeline test = new Timeline();
                    if (isPlaying) {
                        test = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
                            int v = new Random().nextInt(5) + 1;
                            CreatEnemy.enemy enemy = CreatEnemy.getEnemy(v);
                            enemy.addenemy(map);
                        }));
                        try {
                            ghi();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        test.setCycleCount(10);
                        isPlaying = false;
                    }
                    test.play();
                    render();
                    remove();
                    renderText();
                    move();
                    if (health <= 0) {
                        stop();
                        root.getChildren().add(Gamebutton.Playagainbutton);
                        Gamebutton.Playagainbutton.setOnMouseClicked(mouseEvent -> {
                            health = 100;
                            turn = 0;
                            gold = 30;
                            enemys.clear();
                            towers.clear();
                            map.Map(semap);
                            start();
                            Gamebutton.Playagainbutton.setOnMouseClicked(null);
                            root.getChildren().remove(Gamebutton.Playagainbutton);
                        });
                    }
                }
                ;
            };
            timer.start();
    }

    public void ghi() throws IOException{
        File file = new File ("data.txt");
        FileWriter writer = new FileWriter(file);
        PrintWriter out = new PrintWriter(writer);
        out.println(semap);
        out.println(turn);
        out.println(gold);
        out.println(health);
        out.println(towers.size());
        for (int i = 0; i < towers.size(); i++){
            out.println(towers.get(i).getstring());
        }
        out.close();
    }

    private void drawMap(GraphicsContext gc) {

        gc.drawImage(new Image(CreatMap.stringImagemap), 0, 0);
        gc.drawImage(new Image("file:src/AssetsKit_1/buttons/DefineButton2_61/1.png"), 0, 600);
        gc.drawImage(new Image("file:src/AssetsKit_1/buttons/DefineButton2_61/2.png"), 680, 0);
    }

    void render(){
        drawMap(gc);
        enemys.forEach(enemy -> enemy.drawObject(gc));
        towers.forEach(tower -> tower.drawObject(gc));
        bullets.forEach(bullet -> bullet.drawObject(gc));
    }

    void renderText(){
        texts[1].setText("\t\t      " + String.valueOf(health) + "\t\t\t\t\t   " + String.valueOf(gold) + "\t\t\t\t     " + String.valueOf(turn));
        if (proper.compareTo("") != 0){
            gc.drawImage(new Image("file:src/AssetsKit_1/sprites/DefineSprite_230/6.png"), 685, 335);
            String arr[] = proper.split(" ");
            int le = Integer.parseInt(arr[2]);
            int ty = Integer.parseInt(arr[3]);
            texts[2].setText(arr[2]);
            addText(texts[2]);
            texts[3].setText(String.valueOf(CreatMap.arrUpgrade[ty][le].getKey()));
            addText(texts[3]);
            if (le < 6) {
                texts[4].setText(String.valueOf(CreatMap.arrPricetower[ty][le + 1]));
                addText(texts[4]);
                texts[5].setText(String.valueOf(CreatMap.arrUpgrade[ty][le+1].getKey()));
                addText(texts[5]);
            }
            else{
                texts[4].setText("Max");
                addText(texts[4]);
                texts[5].setText("Max");
                addText(texts[5]);
            }

            texts[6].setText(String.valueOf(CreatMap.arrValuetower[ty][le]));
            addText(texts[6]);

        }
        else{
            removeText(texts[2]);
            removeText(texts[3]);
            removeText(texts[4]);
            removeText(texts[5]);
            removeText(texts[6]);

        }
    }

    void removeText(Text text){
        if (text.getParent() != null) root.getChildren().remove(text);
    }
    void addText(Text text){
        if (text.getParent() == null) root.getChildren().add(text);
    }
    void createText(){
        texts[1] = new Text(" ");
        texts[2] = new Text(" ");
        texts[3] = new Text(" ");
        texts[4] = new Text(" ");
        texts[5] = new Text(" ");
        texts[6] = new Text(" ");
        texts[0] = new Text("\tHealth  :\t\t\t\tGold  :\t\t\t\tLevel   :\t/50");
        texts[0].setX(0);
        texts[0].setY(635);
        texts[0].setFill(Color.rgb(0, 0, 0));
        texts[0].setFont(Font.font(Font.getFontNames().get(20), FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        root.getChildren().add(texts[0]);
        texts[1].setFill(Color.rgb(0, 0 ,0));
        texts[1].setFont(Font.font(Font.getFontNames().get(20), FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        texts[1].setX(0);
        texts[1].setY(635);
        root.getChildren().add(texts[1]);
        texts[2].setFill(Color.rgb(0, 0 ,0));
        texts[2].setFont(Font.font(Font.getFontNames().get(20), FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        texts[2].setX(750);
        texts[2].setY(380);

        texts[3].setFill(Color.rgb(0, 0 ,150));
        texts[3].setFont(Font.font(Font.getFontNames().get(20), FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        texts[3].setX(750);
        texts[3].setY(405);

        texts[4].setFill(Color.rgb(0, 150 ,0));
        texts[4].setFont(Font.font(Font.getFontNames().get(20), FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        texts[4].setX(750);
        texts[4].setY(450);

        texts[5].setFill(Color.rgb(150, 0 ,0));
        texts[5].setFont(Font.font(Font.getFontNames().get(20), FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        texts[5].setX(750);
        texts[5].setY(480);

        texts[6].setFill(Color.rgb(0, 0 ,0));
        texts[6].setFont(Font.font(Font.getFontNames().get(20), FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        texts[6].setX(750);
        texts[6].setY(520);
    }

    void move(){
        enemys.forEach(enemy -> enemy.move());
        bullets.forEach(bullet -> bullet.move());
    }

    void remove(){
        for (int i = 0; i < enemys.size(); i++)
            if ((enemys.get(i).getX() <= map.endPoint.getKey() && enemys.get(i).getY() == map.endPoint.getValue()) || enemys.get(i).getHealth() <= 0){
                if (enemys.get(i).getHealth() > 0) health--;
                else gold += enemys.get(i).getReward();
                enemys.remove(i);
            }
        for (int i = 0; i< bullets.size(); i++)
            if (bullets.get(i).getRange() < 0.034) bullets.remove(i);
    }

    public static void main(String[]args){
        launch(args);
    }
}