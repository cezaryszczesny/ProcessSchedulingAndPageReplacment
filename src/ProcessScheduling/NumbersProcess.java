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

    public void setTab(int[][][] ciag) {
        this.ciag = ciag;
    }

    public void generate() {
        Random rand = new Random();
        for (int k = 0; k < ciag.length; k++) {
            for (int i = 0; i < ciag[k].length; i++) {
                for (int j = 0; j < ciag[k][i].length; j++) {
                    if (j == 0)
                        ciag[k][i][j] = rand.nextInt(19) + 1; //Execution time
                    else if (j == 1)
                        ciag[k][i][j] = rand.nextInt(100); //Arrival time
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

    public int[] compare(double[] tatFCFS, double[] timeFCFS, double[] timeSJF, double[] tatSJF) {
        int[] result = new int[2];
        for (int i = 0; i < tatFCFS.length; i++) {
            if (tatFCFS[i] > tatSJF[i] && timeFCFS[i] > timeSJF[i]) {
                result[0] = result[0] + 2;
            } else if (tatFCFS[i] > tatSJF[i] && timeFCFS[i] < timeSJF[i]) {
                result[0]++;
                result[1]++;
            } else if (tatFCFS[i] < tatSJF[i] && timeFCFS[i] > timeSJF[i]) {
                result[0]++;
                result[1]++;
            } else {
                result[1] = result[1] + 2;
            }
        }
        return result;
    } //proof that two middle option doesnt work

    public double[] finalResult(double[] tatFCFS, double[] timeFCFS, double[] timeSJF, double[] tatSJF) {

        double[] result = new double[4];
        double averageTimeFCFS = 0,averageTatFCFS = 0, averageTimeSJF = 0,averageTatSJF = 0;
        for(int i=0;i<100;i++){
            averageTimeFCFS += timeFCFS[i]/100;
            averageTatFCFS += tatFCFS[i]/100;
            averageTimeSJF += timeSJF[i]/100;
            averageTatSJF += tatSJF[i]/100;
        }
        result[0] = averageTimeFCFS;
        result[1] = averageTatFCFS;
        result[2] = averageTimeSJF;
        result[3] = averageTatSJF;
        return result;
    }


}

