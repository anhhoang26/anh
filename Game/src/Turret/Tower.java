package Turret;

import Enemys.Enemy;
import MainGame.TowerDefense;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import Object.*;

public class Tower extends Turret {
    private Image imageGun;

    public Tower(){}

    public Tower(int x, int y, int reward, int type, int dame, double speedShot, double angle, double range, String stringImage, String stringGun){
        super(x,y,reward,type,dame,speedShot,angle,range,stringImage);
        this.imageGun = new Image(stringGun);
        /*double step = 0;
        switch (getType()) {
            case 1 :
            case 2 :
                step = 30;
                break;
            case 3:
            case 4:
                step = 50;
                break;
            case 5:
                step = 40;
                break;
        }
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event->{
            setAngle(getAngle() - 1);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        String finalS = "file:src/AssetsKit_1/sprites/DefineSprite_" + String.valueOf(getType()) + "/" + String.valueOf(getLevel()) + ".png";
        double finalStep = step;
        Timeline test = new Timeline(new KeyFrame(Duration.seconds(getSpeedShot()), event ->{

            for (Enemy enemy : TowerDefense.enemys){
                double tx = 0;
                double ty = 0;
                switch (enemy.getDirection()) {
                    case 1 :
                    case 3 :
                        tx = enemy.getX() + 15;
                        ty = enemy.getY() + 22;
                        break;
                    case 2 :
                    case 0 :
                        tx = enemy.getX() + 22;
                        ty = enemy.getY() + 15;
                        break;
                }
                timeline.pause();
                tx = tx - getX() - 20;
                ty = -(ty - getY() - 20);
                double sqrt = Math.sqrt(tx * tx + ty * ty);
                if (getType() == 4 && enemy.getType() == 1) continue;
                if (enemy.getType() == 2 && getType() != 4) continue;
                if (tx * tx + ty * ty <= getRange()*getRange()) {
                    timeline.play();
                    if (getType() != 3)
                        setAngle(Math.toDegrees(Math.acos(ty/sqrt)));
                    if (tx < 0) setAngle(360 - getAngle());
                    switch (getType()) {
                        case 1 :
                            TowerDefense.bullets.add(new Bullet(getX() + 20 - 4.5, getY() + 20 - 4.5, getType(), finalStep, getDame(), getAngle(), sqrt, finalS));
                            break;
                        case 2 :
                            TowerDefense.bullets.add(new Bullet(getX() + 20 - 7.5, getY() + 20 - 15, getType(), finalStep, getDame(), getAngle(), sqrt, finalS));
                            break;
                        case 3 :
                            TowerDefense.bullets.add(new Bullet(getX() + 20 - 53.5, getY()  - 40, getType(), finalStep, getDame(), 0, sqrt, finalS));
                            break;
                        case 4 :
                            TowerDefense.bullets.add(new Bullet(getX() + 20 - 7, getY() + 20 - 40, getType(), finalStep, getDame(), getAngle(), sqrt, finalS));
                            break;
                    }
                    enemy.setHealth(enemy.getHealth() - getDame() + enemy.getArmor());
                    break;
                }
            }
        }));
        test.setCycleCount(Timeline.INDEFINITE);
        test.play();*/
    }

    public void setImageGun(Image imageGun) {
        this.imageGun = imageGun;
    }
    public Image getImageGun(){return imageGun;}
    public void upgrade(){
        super.upgrade();
        imageGun = new Image("file:src/AssetsKit_1/sprites/DefineSprite_1" + String.valueOf(getType()) + "/" + String.valueOf(getLevel()) + ".png");
    }

    public void drawObject(GraphicsContext gc){
        gc.drawImage(getImage(),getX(),getY());
        /*gc.save();
        Rotate r = new Rotate(getAngle(), getX() + 20, getY() + 20);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        switch (getType()) {
            case 1 :
                gc.drawImage(imageGun, getX() + 10, getY() - 10);
                break;
            case 2 :
                gc.drawImage(imageGun, getX() + 20 - imageGun.getWidth() /2, getY() - 9);
                break;
            case 3 :
                gc.drawImage(imageGun, getX() , getY());
                break;
            case 4 :
                gc.drawImage(imageGun, getX() - 1, getY() + 6);
                break;
            case 5 :
                gc.drawImage(imageGun, getX() + 10, getY() - 9);
                break;
        }
        gc.restore();*/
    }

    public String getstring(){
        return String.valueOf(getX()) + " " + String.valueOf(getY()) + " " + String.valueOf(getLevel()) + " " + String.valueOf(getType());
    }
}
