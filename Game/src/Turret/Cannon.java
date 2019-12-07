package Turret;

import Enemys.Enemy;
import MainGame.TowerDefense;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Cannon extends Tower {
    public Cannon(int x, int y){
        super(x,y,6, 1, 10, 0.5, 0, 100, "file:src/AssetsKit_1/shapes/78.png", "file:src/AssetsKit_1/shapes/79.png");
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event->{
            setAngle(getAngle() - 1);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        String finalS = "file:src/AssetsKit_1/sprites/DefineSprite_" + String.valueOf(getType()) + "/" + String.valueOf(getLevel()) + ".png";
        double finalStep = 30;
        Timeline test = new Timeline(new KeyFrame(Duration.seconds(getSpeedShot()), event ->{
            timeline.pause();
            for (Enemy enemy : TowerDefense.enemys){
                if (enemy.getType() == 2) continue;
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
                    TowerDefense.bullets.add(new Bullet(getX() + 20 - 4.5, getY() + 20 - 4.5, getType(), finalStep, getDame(), getAngle(), sqrt, finalS));
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
        gc.save();
        Rotate r = new Rotate(getAngle(), getX() + 20, getY() + 20);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(getImageGun(), getX() + 10, getY() - 10);
        gc.restore();
    }

    @Override
    public String getstring() {
        return super.getstring();
    }
}
