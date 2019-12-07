package Object;

import javafx.util.Pair;

import java.util.ArrayList;
import MainGame.*;

public class CreatMap {

    public ArrayList<Pair<Integer, Integer>> point = new ArrayList<Pair<Integer, Integer>>();
    public int dir[] = new int[9];
    public static Pair<Double, Double> beginPoint;
    public static Pair<Double, Double> endPoint;
    public static String stringImagemap = "";
    public static int arrValuetower[][] = new int[][] {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 6, 15, 15, 25, 30, 35},
            {0, 6, 15, 15, 25, 30, 35},
            {0, 6, 15, 15, 25, 30, 35},
            {0, 6, 15, 15, 25, 30, 35},
            {0, 6, 15, 15, 25, 30, 35},
    };
    public static int arrValueenmy[] = new int[] {0, 5, 7, 7, 9, 10, 11};
    public static int arrPricetower[][] = new int[][] {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 10, 25, 40, 50, 60, 100},
            {0, 10, 25, 40, 50, 60, 100},
            {0, 10, 25, 40, 50, 60, 100},
            {0, 10, 25, 40, 50, 60, 100},
            {0, 10, 25, 40, 50, 60, 100},
    };
    public static int arrheal[] = new int[] {25, 30, 35, 40, 45, 50, 55, 60, 70, 75, 85, 90, 100, 120, 130};
    public static Pair<Integer, Double> arrUpgrade[][] = new Pair[6][7];
    public static Double speedTurret[] = new Double[] {0.0, 0.5, 1.0, 0.75, 0.5, 1.0};
    public CreatMap(){}

    public static int[][] MAP_SPRITES = new int[15][20];



    public void Map(int level){
            arrUpgrade[1][1] = new Pair<Integer, Double>(10, 100.0);
            arrUpgrade[1][2] = new Pair<Integer, Double>(10, 100.0);
            arrUpgrade[1][3] = new Pair<Integer, Double>(10, 100.0);
            arrUpgrade[1][4] = new Pair<Integer, Double>(10, 100.0);
            arrUpgrade[1][5] = new Pair<Integer, Double>(10, 100.0);
            arrUpgrade[1][6] = new Pair<Integer, Double>(10, 100.0);

            arrUpgrade[2][1] = new Pair<Integer, Double>(15, 80.0);
            arrUpgrade[2][2] = new Pair<Integer, Double>(15, 80.0);
            arrUpgrade[2][3] = new Pair<Integer, Double>(15, 80.0);
            arrUpgrade[2][4] = new Pair<Integer, Double>(15, 80.0);
            arrUpgrade[2][5] = new Pair<Integer, Double>(15, 80.0);
            arrUpgrade[2][6] = new Pair<Integer, Double>(15, 80.0);

            arrUpgrade[3][1] = new Pair<Integer, Double>(25, 60.0);
            arrUpgrade[3][2] = new Pair<Integer, Double>(25, 60.0);
            arrUpgrade[3][3] = new Pair<Integer, Double>(25, 60.0);
            arrUpgrade[3][4] = new Pair<Integer, Double>(25, 60.0);
            arrUpgrade[3][5] = new Pair<Integer, Double>(25, 60.0);
            arrUpgrade[3][6] = new Pair<Integer, Double>(25, 60.0);

            arrUpgrade[4][1] = new Pair<Integer, Double>(30, 200.0);
            arrUpgrade[4][2] = new Pair<Integer, Double>(30, 200.0);
            arrUpgrade[4][3] = new Pair<Integer, Double>(30, 200.0);
            arrUpgrade[4][4] = new Pair<Integer, Double>(30, 200.0);
            arrUpgrade[4][5] = new Pair<Integer, Double>(30, 200.0);
            arrUpgrade[4][6] = new Pair<Integer, Double>(30, 200.0);

            arrUpgrade[5][1] = new Pair<Integer, Double>(5, 150.0);
            arrUpgrade[5][2] = new Pair<Integer, Double>(5, 150.0);
            arrUpgrade[5][3] = new Pair<Integer, Double>(5, 150.0);
            arrUpgrade[5][4] = new Pair<Integer, Double>(5, 150.0);
            arrUpgrade[5][5] = new Pair<Integer, Double>(5, 150.0);
            arrUpgrade[5][6] = new Pair<Integer, Double>(5, 150.0);

            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 20; j++)
                    TowerDefense.properties[i][j] = "";
            switch (level) {
                case 1 :
                    point.add(new Pair<Integer, Integer>(405,60));
                    point.add(new Pair<Integer, Integer>(420,195));
                    point.add(new Pair<Integer, Integer>(285,180));
                    point.add(new Pair<Integer, Integer>(300,45));
                    point.add(new Pair<Integer, Integer>(45,60));
                    point.add(new Pair<Integer, Integer>(60,317));
                    point.add(new Pair<Integer, Integer>(637,300));
                    point.add(new Pair<Integer, Integer>(620,557));
                    point.add(new Pair<Integer, Integer>(0, 0 ));

                    stringImagemap = "file:src/AssetsKit_1/shapes/53.png";
                    beginPoint = new Pair <Double, Double>(636.0,45.0);
                    endPoint = new Pair <Double, Double>(-44.0,525.0);
                    MAP_SPRITES = new int[][] {
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, 0, -1, -1, 0, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, 0, -1, -1, 0, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                    };
                    dir = new int[] {3, 0, 1, 0, 3, 2, 3, 0};
                    break;
                case 2 :
                    point.add(new Pair<Integer, Integer>(45,60));
                    point.add(new Pair<Integer, Integer>(60,357));
                    point.add(new Pair<Integer, Integer>(637,340));
                    point.add(new Pair<Integer, Integer>(620,557));
                    point.add(new Pair<Integer, Integer>(0, 0 ));
                    stringImagemap = "file:src/AssetsKit_1/shapes/54.png";
                    beginPoint = new Pair <Double, Double>(636.0,45.0);
                    endPoint = new Pair <Double, Double>(-44.0,525.0);
                    MAP_SPRITES = new int[][] {
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                    };
                    dir = new int[] {3, 2, 3, 0};
                    break;
                case 3 :
                    point.add(new Pair<Integer, Integer>(325,125));
                    point.add(new Pair<Integer, Integer>(325,435));
                    point.add(new Pair<Integer, Integer>(0, 0 ));
                    stringImagemap = "file:src/AssetsKit_1/shapes/57.png";
                    beginPoint = new Pair <Double, Double>(636.0,125.0);
                    endPoint = new Pair <Double, Double>(-44.0,405.0);
                    MAP_SPRITES = new int[][] {
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0},
                    };
                    dir = new int[] {3, 0, 0};
                    break;
            }
        }
}
