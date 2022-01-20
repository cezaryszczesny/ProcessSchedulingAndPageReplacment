package ProcessScheduling;

public class AlgSjf extends AbstractAlgorithm { // Non-Preemptive

    public AlgSjf() {
        super();

    }

    public AlgSjf(int amount) {
      super(amount);
    }


    public void calculateParameters(int[][][] ciag) {
        for (int k = 0; k < ciag.length; k++) {
            averageTat[k] = ciag[k][0][0];
            int complete = 0;
            int systemTime = 0;
            while (complete != 100) {
               int c=100;
               double min = Double.MAX_VALUE;
                for (int i = 0; i < ciag[k].length; i++) {
                    if ((ciag[k][i][1] <= systemTime) && (ciag[k][i][2] == 0) && (ciag[k][i][0] < min)) {
                        min = ciag[k][i][0];
                        c = i;
                    }
                }
                if (c == ciag[k].length)
                    systemTime++;
                else {
                    systemTime = systemTime + ciag[k][c][0];
                    averageTat[k] = averageTat[k] + (systemTime + ciag[k][c][0] - ciag[k][c][1]) / 100;
                    averageTime[k] = averageTime[k] + (systemTime - ciag[k][c][1]) / 100;
                    ciag[k][c][2] = 1;
                    complete++;
                }
            }
        }
    }
}