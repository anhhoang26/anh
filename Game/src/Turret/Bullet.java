package Turret;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;

public class Bullet extends Turret {

    double step;

    Bullet(double x, double y, int type, double step, int dame, double angle, double range, String stringImage){
        super(x,y,0,type,dame,0.0, angle,range,stringImage);
        this.step = step;
    }

    public void move(){
        if (step > getRange()) step = getRange();
        setRange(getRange() - step);
            setX(getX() + step * Math.sin(Math.toRadians(getAngle())));
            setY(getY() - step * Math.cos(Math.toRadians(getAngle())));

    }

    public void drawObject(GraphicsContext gc){
        gc.save();
        Rotate r = new Rotate();
        switch (getType()) {
            case 1 :
                 r = new Rotate(getAngle(), getX() + 4.5, getY() +4.5);
                break;
            case 2 :
                r = new Rotate(getAngle(), getX() + 7.5, getY() + 15);
                break;
            case 3 :
                r = new Rotate(getAngle(), getX() - 35, getY() - 42);
                break;
            case 4 :
                r = new Rotate(getAngle(), getX() + 7, getY() + 40);
                break;
        }

        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(getImage(), getX(), getY());
        gc.restore();
    }
}
