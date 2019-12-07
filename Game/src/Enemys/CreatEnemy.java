package Enemys;

import java.util.Random;
import Object.*;
import MainGame.*;

public class CreatEnemy {
    private CreatEnemy(){};

    public interface enemy{
        void addenemy(CreatMap map);
    }

    public static class carene1 implements enemy{

        public  void addenemy(CreatMap map){
             int v = new Random().nextInt(7) + 1;
            TowerDefense.enemys.add(new Enemy(map.beginPoint.getKey(), map.beginPoint.getValue(), CreatMap.arrValueenmy[1], 1, 2,
                    0, 0, CreatMap.arrheal[TowerDefense.turn], "file:src/AssetsKit_1/sprites/DefineSprite_240/" + String.valueOf(v) + ".png", map));
        }
    }

    public static class carene2 implements enemy{
        public void addenemy(CreatMap map){
            TowerDefense.enemys.add(new Enemy(map.beginPoint.getKey(), map.beginPoint.getValue(), CreatMap.arrValueenmy[1], 1, 2,
                    1, 0, CreatMap.arrheal[TowerDefense.turn], "file:src/AssetsKit_1/sprites/DefineSprite_240/7.png", map));
        }
    }

    public static class carene3 implements enemy{
        public void addenemy(CreatMap map){
            TowerDefense.enemys.add(new Enemy(map.beginPoint.getKey(), map.beginPoint.getValue(), CreatMap.arrValueenmy[1], 1, 2,
                    2, 0, CreatMap.arrheal[TowerDefense.turn], "file:src/AssetsKit_1/sprites/DefineSprite_240/9.png", map));
        }
    }

    public static class fighterene implements enemy{
        public void addenemy(CreatMap map){
            TowerDefense.enemys.add(new Enemy(map.beginPoint.getKey(), map.beginPoint.getValue(), CreatMap.arrValueenmy[1], 2, 3,
                    3, 0, CreatMap.arrheal[TowerDefense.turn], "file:src/AssetsKit_1/sprites/DefineSprite_247/1.png", map));
        }
    }

    public static class tankene implements enemy{
        public void addenemy(CreatMap map){
            TowerDefense.enemys.add(new Enemy(map.beginPoint.getKey(), map.beginPoint.getValue(), CreatMap.arrValueenmy[1], 3, 1,
                    6, 0, CreatMap.arrheal[TowerDefense.turn], "file:src/AssetsKit_1/sprites/DefineSprite_250/1.png", map));
        }
    }

    public static final enemy getEnemy(int typeEnemy){
        switch (typeEnemy) {
            case 1 :
                return new carene1();
            case 2 :
                return new carene2();
            case 3 :
                return new carene3();
            case 4 :
                return new fighterene();
            case 5 :
                return new tankene();
        }
        return null;
    }
}
