package ProcessScheduling;
import java.util.Random;

public class NumbersProcess {
    private int[][][] ciag;


    public NumbersProcess() {
        this.ciag = new int[100][100][3];

    }

    public NumbersProcess(int amount) {
        this.ciag = new int[amount][100][3];
    }


    public int[][][] getTab() {
        return this.ciag;
    }
    public void setTab(int[][][] ciag){this.ciag = ciag;    }

    public void generate() {
        Random rand = new Random();
        for (int k = 0; k < ciag.length; k++) {
            for (int i = 0; i < ciag[k].length; i++) {
                for (int j = 0; j < ciag[k][i].length; j++) {
                    if (j == 0)
                        ciag[k][i][j] = rand.nextInt(19)+1; //Execution time
                    else if(j == 1)
                        ciag[k][i][j] = rand.nextInt(100) + 1; //Arrival time
                    else
                        ciag[k][i][j] = 0; //if 0 proces is not done if 1 proces is done

                }
            }
        }
    }

    public int[][][] sortByArrivals(int[][][] ciag) {
        for (int k = 0; k < ciag.length; k++) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100 - (i + 1); j++) {
                    if (ciag[k][j][1] > ciag[k][j + 1][1]) {
                        int[][][] p = new int[1][1][2];
                        p[0][0][0] = ciag[k][j][0];
                        p[0][0][1] = ciag[k][j][1];
                        ciag[k][j][0] = ciag[k][j + 1][0];
                        ciag[k][j][1] = ciag[k][j + 1][1];
                        ciag[k][j + 1][0] = p[0][0][0];
                        ciag[k][j + 1][1] = p[0][0][1];

                    }
                }
            }
        }
        return ciag;
    }


}

