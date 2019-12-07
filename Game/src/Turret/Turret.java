package Turret;

import javafx.scene.canvas.GraphicsContext;
import MainGame.*;
import Object.*;

abstract public class Turret extends GameObject{
    private int dame;
    private double angle;
    private double range;
    private double speedShot;
    private int level;
    private int type;/* 1 :
                        2 :
                        3 :
                        4 :
                        5 :
                        */
    Turret(){}

    Turret(double x, double y, int reward, int type, int dame, double speedShot, double angle, double range, String stringImage){
        super(x,y,reward,stringImage);
        this.angle = angle;
        this.dame = dame;
        this.speedShot = speedShot;
        this.range = range;
        this.type = type;
        this.level = 1;
    }

    public void upgrade(){
        this.level ++;
        this.dame = CreatMap.arrUpgrade[type][level].getKey();
        this.range = CreatMap.arrUpgrade[type][level].getValue();
        setReward(CreatMap.arrValuetower[type][level]);
    }

    public int getLevel(){return level;}

    public void setDame(int dame){
        this.dame =dame;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public void setSpeedShot(double speedShot){this.speedShot = speedShot;}

    public double getSpeedShot(){return speedShot;}

    public void setRange(double range){
        this.range = range;
    }

    public int getDame(){return dame;}

    public double getAngle(){return angle;}

    public double getRange(){return range;}

    public int getType(){return type;}

    public void drawObject(GraphicsContext gc){}
}
