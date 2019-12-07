package GameSetting;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import Turret.*;
import Object.*;
import MainGame.*;
public class Gamebutton extends Parent {
    public static MenuButton buttonSell;
    public static MenuButton buttonUp;
    public static MenuButton Playagainbutton;
    public static MenuButton Mainmenubutton;
    public  Gamebutton(){

        VBox menu0 = new VBox(10);
        menu0.setTranslateX(710);
        menu0.setTranslateY(10);
        Image image = new Image("file:src/AssetsKit_1/buttons/" + "DefineButton2_80" + "/1.png");
        ImageView imageView = new ImageView(image);
        TowerButton towerButton1 = new TowerButton(imageView, 1);

        image = new Image("file:src/AssetsKit_1/buttons/DefineButton2_282/1.png");
        imageView = new ImageView(image);
        Playagainbutton = new MenuButton(imageView);
        Playagainbutton.setTranslateX(168);
        Playagainbutton.setTranslateY(245);

        image = new Image("file:src/AssetsKit_1/buttons/DefineButton2_83/1.png");
        imageView = new ImageView(image);
        Mainmenubutton = new MenuButton(imageView);
        Mainmenubutton.setTranslateX(682);
        Mainmenubutton.setTranslateY(600);

        image = new Image("file:src/AssetsKit_1/buttons/" + "DefineButton2_71" + "/1.png");
        imageView = new ImageView(image);
        TowerButton towerButton2 = new TowerButton(imageView, 2);

        image = new Image("file:src/AssetsKit_1/buttons/" + "DefineButton2_66" + "/1.png");
        imageView = new ImageView(image);
        TowerButton towerButton3 = new TowerButton(imageView, 3);

        image = new Image("file:src/AssetsKit_1/buttons/" + "DefineButton2_77" + "/1.png");
        imageView = new ImageView(image);
        TowerButton towerButton4 = new TowerButton(imageView, 4);

        image = new Image("file:src/AssetsKit_1/buttons/" + "DefineButton2_96" + "/1.png");
        imageView = new ImageView(image);
        TowerButton towerButton5 = new TowerButton(imageView, 5);

        image = new Image("file:src/AssetsKit_1/buttons/" + "DefineButton2_87" + "/1.png");
        imageView = new ImageView(image);
        MenuButton button1 = new MenuButton(imageView);
        button1.setTranslateX(685);
        button1.setTranslateY(285);
        button1.setOnMouseClicked(event ->{
            TowerDefense.turn ++;
            TowerDefense.isPlaying = true;
        });

        image = new Image("file:src/AssetsKit_1/buttons/" + "DefineButton2_221" + "/1.png");
        imageView = new ImageView(image);
        buttonUp = new MenuButton(imageView);
        buttonUp.setTranslateX(683);
        buttonUp.setTranslateY(560);

        image = new Image("file:src/AssetsKit_1/buttons/" + "DefineButton2_217" + "/1.png");
        imageView = new ImageView(image);
        buttonSell = new MenuButton(imageView);
        buttonSell.setTranslateX(743);
        buttonSell.setTranslateY(560);

        menu0.getChildren().addAll(towerButton1,towerButton2,towerButton3,towerButton4,towerButton5);
        getChildren().addAll(menu0, button1, buttonUp, buttonSell, Mainmenubutton);
    }
    public static class TowerButton extends Button {

        public TowerButton(ImageView imageView, int v) {
            super("",imageView);

            DropShadow dropShadow = new DropShadow();
            Image image1 = new Image("file:src/AssetsKit_1/sprites/DefineSprite_230/" + String.valueOf(v) + ".png");
            ImageView imageView3 = new ImageView(image1);
            imageView3.setX(685);
            imageView3.setY(335);

            addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) { setEffect(dropShadow);
                    if (imageView3.getParent() == null) TowerDefense.root.getChildren().add(imageView3);

                }
            });

            addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    if (imageView3.getParent() != null) TowerDefense.root.getChildren().remove(imageView3);

                    setEffect(null);
                }
            });
            Image image =  new Image("file:src/AssetsKit_1/sprites/DefineSprite_114" + "/" + String.valueOf(v) + ".png");
            ImageView imageView1 = new ImageView(image);
            setOnMouseClicked(mouseEvent -> {
                //TowerDefense.proper =
                if (TowerDefense.gold >= CreatMap.arrPricetower[v][1]){
                    imageView1.setX(730 - CreatMap.arrUpgrade[v][1].getValue());
                    imageView1.setY(30 + 57 * (v-1) - CreatMap.arrUpgrade[v][1].getValue());
                    TowerDefense.root.getChildren().add(imageView1);
                    TowerDefense.scene.setOnMouseMoved(event ->{
                        imageView1.setX(event.getX() - CreatMap.arrUpgrade[v][1].getValue());
                        imageView1.setY(event.getY() - CreatMap.arrUpgrade[v][1].getValue());
                        TowerDefense.scene.setOnMouseClicked(event1 ->{
                            int d = (int) event1.getX() / 40;
                            int c = (int) event1.getY() / 40;
                            if (CreatMap.MAP_SPRITES[c][d] == -1){
                                CreatTower.tower tower1 = CreatTower.getTower(v);
                                tower1.addtower(d*40, c*40);
                                CreatMap.MAP_SPRITES[c][d] = v;
                                CreatSound.playMedia("src/AssetsKit_1/sounds/3_turretbuild.mp3");
                                TowerDefense.properties[c][d] = TowerDefense.towers.get(TowerDefense.towers.size() - 1).getstring();
                                TowerDefense.gold -= CreatMap.arrPricetower[v][1];
                            }
                            TowerDefense.scene.setOnMouseClicked(null);
                            TowerDefense.scene.setOnMouseMoved(null);
                            TowerDefense.root.getChildren().remove(imageView1);

                            TowerDefense.scene.setOnMouseClicked(event2 ->{
                                TowerDefense.proper ="";
                                int d1 = (int) event2.getX() / 40;
                                int c1 = (int) event2.getY() / 40;
                                if (CreatMap.MAP_SPRITES[c1][d1] != 0 && CreatMap.MAP_SPRITES[c1][d1] != -1) {
                                    TowerDefense.proper = TowerDefense.properties[c1][d1];
                                    buttonSell.setOnMouseClicked(event3 -> {
                                        CreatMap.MAP_SPRITES[c1][d1] = -1;
                                        TowerDefense.gold += 8;
                                        for(Tower tower : TowerDefense.towers){
                                            if (tower.getX() == (double) d1 * 40 && tower.getY() == (double) c1 *40){
                                                TowerDefense.towers.remove(tower);
                                                //CreatSound.playMedia("src/AssetsKit_1/sounds/7_click.mp3");
                                                break;
                                            }
                                        }
                                    });

                                    buttonUp.setOnMouseClicked(event3 -> {
                                        for (Tower tower : TowerDefense.towers){
                                            if (tower.getX() == (double) d1 * 40 && tower.getY() == (double) c1 *40){
                                                if (TowerDefense.gold >= CreatMap.arrPricetower[tower.getType()][tower.getLevel() + 1]){
                                                    tower.upgrade();
                                                    TowerDefense.gold -= CreatMap.arrPricetower[tower.getType()][tower.getLevel()];
                                                    TowerDefense.properties[c1][d1] = tower.getstring();
                                                    //CreatSound.playMedia("src/AssetsKit_1/sounds/7_click.mp3");
                                                }
                                                break;
                                            }
                                        }
                                    });
                                }
                                });

                            ImageView imageView2 = new ImageView(new Image("file:src/AssetsKit_1/sprites/DefineSprite_44/" + String.valueOf(v) + ".png"));
                            TowerDefense.scene.setOnMouseMoved(event2 -> {
                                int d1 = (int) event2.getX() / 40;
                                int c1 = (int) event2.getY() / 40;
                                if (imageView2.getParent() != null) TowerDefense.root.getChildren().remove(imageView2);
                                if (CreatMap.MAP_SPRITES[c1][d1] != 0 && CreatMap.MAP_SPRITES[c1][d1] != -1){
                                    imageView2.setImage(new Image("file:src/AssetsKit_1/sprites/DefineSprite_44/" + String.valueOf(CreatMap.MAP_SPRITES[c1][d1]) + ".png"));
                                    imageView2.setX(d1*40 + 20 - CreatMap.arrUpgrade[CreatMap.MAP_SPRITES[c1][d1]][1].getValue());
                                    imageView2.setY(c1*40 + 20 - CreatMap.arrUpgrade[CreatMap.MAP_SPRITES[c1][d1]][1].getValue());
                                    TowerDefense.root.getChildren().add(imageView2);
                                }

                            });
                        });
                    });
                }
            });
        }
    }

    public static class MenuButton extends Button{
        public MenuButton(ImageView imageView){
            super("", imageView);
            DropShadow dropShadow = new DropShadow();

            addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) { setEffect(dropShadow);
                }
            });

            addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    setEffect(null);
                }
            });
        }
    }
}
