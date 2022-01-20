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

    public int[][] getCiag() {
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

}
