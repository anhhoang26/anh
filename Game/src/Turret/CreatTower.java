package Turret;

import MainGame.TowerDefense;

public class CreatTower {
    private CreatTower(){};

    public interface tower {
        void addtower(int x, int y);
    }

    public static class cannonTower implements tower{
        public void addtower(int x, int y){
            TowerDefense.towers.add((Tower) new Cannon(x, y));
        }
    }

    public static class Icetower implements tower{
        public void addtower(int x, int y){
            TowerDefense.towers.add((Tower) new IceTower(x, y));
        }
    }

    public static class Raygun implements tower{
        public void addtower(int x, int y){
            TowerDefense.towers.add((Tower) new RayGun(x, y));
        }
    }

    public static class Missle implements tower{
        public void addtower(int x, int y){
            TowerDefense.towers.add((Tower) new MissleLauncher(x, y));
        }
    }

    public static class Machinegun implements  tower{
        public void addtower(int x, int y){
            TowerDefense.towers.add((Tower) new MissleLauncher(x, y));
        }
    }

    public static final tower getTower(int typeEnemy){
        switch (typeEnemy) {
            case 1 :
                return new cannonTower();
            case 2 :
                return new Icetower();
            case 3 :
                return new Raygun ();
            case 4 :
                return new Missle();
            case 5 :
                return new Machinegun();
        }
        return null;
    }
}
