package PagesReplacment;

import java.util.Random;

public class PagesNumbers {

    private int[][] ciag;

    public PagesNumbers(){
        ciag = new int[100][100];
    }

    public PagesNumbers(int amount){
        ciag = new int[amount][100];
    }

    public int[][] getTab() {
        return ciag;
    }

    public void generate(){
        Random rand = new Random();
        for(int i=0; i < ciag.length;i++){
            for(int j=0; j < ciag[i].length; j++){
                ciag[i][j] = rand.nextInt(20);
            }
        }
    }

    public double[] finalResult(int[] Fifo1, int[] Fifo2, int[] Fifo3, int[] Lru1, int[] Lru2, int[] Lru3){
        double[] result = new double[6];
        double temp;
            for(int i = 0; i<100;i++){
                temp = Fifo1[i];
                result[0] += temp/100;
                temp = Fifo2[i];
                result[1] += temp/100;
                temp = Fifo3[i];
                result[2] += temp/100;
                temp = Lru1[i];
                result[3] += temp/100;
                temp = Lru2[i];
                result[4] += temp/100;
                temp = Lru3[i];
                result[5] += temp/100;
            }
        return result;
    }
}
