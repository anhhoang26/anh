package MainGame;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import javafx.scene.control.Button;

public abstract class GameObject extends Button {
    private double x;
    private double y;
    private int reward;
    private Image image;
    public GameObject(){}
    public GameObject(double x, double y, int reward, String stringImage){
        this.x = x;
        this.y = y;
        this.reward = reward;
        this.image = new Image(stringImage);
    }

    public int getReward(){return reward;}

    public void setReward(int reward) { this.reward = reward;}

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public Image getImage(){return image; }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public abstract void drawObject(GraphicsContext gc);
}

