package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {

        int sum = 0;

        for (int y = 0; y < a.length; y++){
            for (int x = 0; x < a[y].length; x++){
                if (a[y][x] == 1) {
                    int sX = x;
                    int sY = y;
                    int eX = -1;
                    int eY = -1;
                    for (int tempX = sX; tempX < a[y].length; tempX++ ){
                        if (a[y].length == tempX +1 || a[y][tempX +1] == 0) {
                            eX = tempX;
                            break;
                        }
                    }
                    for (int tempY = sY; tempY < a.length; tempY++){
                        if (a.length == tempY +1 || a[tempY +1][eX] == 0) {
                            eY = tempY;
                            break;
                        }
                    }
                    if (eX != -1 && eY != -1) {
                        x = eX+1;

                        for (int tempY = sY; tempY <= eY; tempY++){
                            for (int tempX = sX; tempX <= eX; tempX++){
                                a[tempY][tempX] = 0;
                            }
                        }

                        sum++;

                    }
                }
            }
        }

        return sum;
    }
}
