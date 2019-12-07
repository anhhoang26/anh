package Enemys;

import MainGame.GameObject;
import MainGame.TowerDefense;
import Object.*;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class Enemy extends GameObject {

    private int step;
    private int armor;
    private int type;/* 1:
                        2:
                        */
    private int direction;
    private int health;
    private Queue<Pair<Integer, Integer>> arrmove = new LinkedList<>();
    private Queue<Integer> dirmove = new LinkedList<>();
    Enemy(double x, double y, int reward, int type, int step, int armor, int direction, int health, String stringImage, CreatMap map ){
        super(x,y,reward,stringImage);
        this.step = step;
        this.type = type;
        this.armor = armor;
        this.direction = direction;
        this.health = health;
        for (Pair<Integer, Integer> temp : map.point)
            arrmove.add(temp);
        for (int v : map.dir)
            dirmove.add(v);
    }

    Enemy(){ }

    public void setArmor(int armor){this.armor = armor; }

    public int getDirection(){return direction;}

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){return  health;}

    public int getType(){return type;}

    public int getArmor(){return armor;}

    public void setStep(int x){
        this.step = x;
    }

    public int getStep(){return step;}

    public void move(){
        int dx = 0;
        int dy = 0;
        int dxd = 0;
        int dyd = 0;
        switch (direction) {
            case 0 :
                setX(getX() - step);
                dx = (int) getX();
                dy = (int) getY() + 15;
                dxd = (int) getX() + 44;
                dyd = (int) getY() + 30;
                break;
            case 1 :
                setY(getY() - step);
                dx = (int) getX() + 15;
                dy = (int) getY();
                dxd = (int) getX() + 30;
                dyd = (int) getY() + 44;
                break;
            case 2 :
                setX(getX() + step);
                dx = (int) getX() + 44;
                dy = (int) getY() + 15;
                dxd = (int) getX() + 44;
                dyd = (int) getY() + 30;
                break;
            case 3 :
                setY(getY() + step);
                dx = (int) getX() + 15;
                dy = (int) getY() + 44;
                dxd = (int) getX() + 30;
                dyd = (int) getY() + 44;
                break;
        }
        Pair<Integer, Integer> diem = new Pair<Integer, Integer>(0, 0);
        diem = arrmove.peek();
        int dxc = (int) getX();
        int dyc = (int) getY();

        if (diem.getKey() <= dxd && diem.getKey() >= dxc && diem.getValue() <= dyd && diem.getValue() >= dyc) {

            dx = dx / 40;
            dy = dy / 40;
            direction = dirmove.peek();
            dirmove.poll();
            arrmove.poll();
            switch (direction) {
                case 0 :
                    setX(dx*40 - 9);
                    setY(dy*40 + 5);
                    break;
                case 1 :
                    setX(dx*40 + 5);
                    setY(dy*40 - 9);
                    break;
                case 2 :
                case 3 :
                    setX(dx*40 + 5);
                    setY(dy*40 + 5);
                    break;
            }
        }
    }
    public void drawObject(GraphicsContext gc){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(getImage());
        iv.setRotate(this.direction * 90);
        Image base = iv.snapshot(params, null);
        gc.drawImage(base, getX(), getY());
        double x1 = getX() + 10;
        double y1 = getY() - 6;
        if (this.direction == 1 || this.direction == 3) {
            x1 = x1 - 8;
        }
        gc.drawImage(new javafx.scene.image.Image("file:src/AssetsKit_1/shapes/241.png"), x1, y1);
        gc.drawImage(new javafx.scene.image.Image("file:src/AssetsKit_1/shapes/243.png"), x1, y1,(double)(health)/CreatMap.arrheal[TowerDefense.turn]*26, 6);
    }

}
