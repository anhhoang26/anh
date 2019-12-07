package Turret;

import Enemys.Enemy;
import MainGame.TowerDefense;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class IceTower extends Tower{
    public IceTower(int x, int y){
        super(x, y,6, 2, 10, 1, 0, 80, "file:src/AssetsKit_1/shapes/68.png", "file:src/AssetsKit_1/shapes/69.png");
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), event->{
            setAngle(getAngle() - 1);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        String finalS = "file:src/AssetsKit_1/sprites/DefineSprite_" + String.valueOf(getType()) + "/" + String.valueOf(getLevel()) + ".png";
        double finalStep = 30;
        Timeline test = new Timeline(new KeyFrame(Duration.seconds(getSpeedShot()), event ->{
            timeline.pause();

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
                tx = tx - getX() - 20;
                ty = -(ty - getY() - 20);
                double sqrt = Math.sqrt(tx * tx + ty * ty);
                if (tx * tx + ty * ty <= getRange()*getRange()) {
                    timeline.play();
                    if (getType() != 3)
                        setAngle(Math.toDegrees(Math.acos(ty/sqrt)));
                    if (tx < 0) setAngle(360 - getAngle());
                    TowerDefense.bullets.add(new Bullet(getX() + 20 - 7.5, getY() + 20 - 15, getType(), finalStep, getDame(), getAngle(), sqrt, finalS));
                    enemy.setHealth(enemy.getHealth() - getDame() + enemy.getArmor());
                    enemy.setStep(1);
                    Timeline delay = new Timeline(new KeyFrame(Duration.seconds(1.5), actionEvent ->{
                        switch (enemy.getType()){
                            case 1 :
                                enemy.setStep(2);
                                break;
                            case 2 :
                                enemy.setStep(3);
                                break;
                            case 3 :
                                enemy.setStep(1);
                                break;
                        }
                    }));
                    delay.play();
                    break;
                }
            }
        }));
        test.setCycleCount(Timeline.INDEFINITE);
        test.play();
    }

    @Override
    public void drawObject(GraphicsContext gc) {
        super.drawObject(gc);
        gc.save();
        Rotate r = new Rotate(getAngle(), getX() + 20, getY() + 20);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(getImageGun(), getX() + 20 - getImageGun().getWidth() /2, getY() - 9);
        gc.restore();
    }

    @Override
    public String getstring() {
        return super.getstring();
    }
}
