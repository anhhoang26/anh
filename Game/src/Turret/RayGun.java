package Turret;

import Enemys.Enemy;
import MainGame.TowerDefense;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public class RayGun extends Tower{
    public RayGun(int x, int y){
        super(x, y,6, 3, 10, 0.75, 0, 60, "file:src/AssetsKit_1/shapes/63.png","file:src/AssetsKit_1/shapes/64.png");
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event->{
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
                    TowerDefense.bullets.add(new Bullet(getX() + 20 - 53.5, getY()  - 40, getType(), finalStep, getDame(), 0, sqrt, finalS));
                    enemy.setHealth(enemy.getHealth() - getDame() + enemy.getArmor());
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
        gc.drawImage(getImageGun(), getX() , getY() );
    }

    @Override
    public String getstring() {
        return super.getstring();
    }
}