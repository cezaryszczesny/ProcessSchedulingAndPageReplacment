package PagesReplacment;

public class PagesFifo {
    private int[] pagesFaults3;
    private int[] pagesFaults4;

    public PagesFifo() {
        pagesFaults3 = new int[100];
        pagesFaults4 = new int[100];
    }

    public PagesFifo(int amount) {
        pagesFaults3 = new int[amount];
        pagesFaults4 = new int[amount];
    }

    public int[] getPagesFaults3() {
        return pagesFaults3;
    }

    public int[] getPagesFaults4() {
        return pagesFaults4;
    }

    /*public void threeFrames(int[][] ciag) {
        int[] frame = new int[3];
        int[] frameCounter = new int[3];
        for (int i = 0; i < ciag.length; i++) {
            for (int j = 0; j < ciag[i].length; j++) {

                if ((frame[0] != ciag[i][j]) && (frame[1] != ciag[i][j]) && (frame[2] != ciag[i][j])) {
                    if ((frameCounter[0] <= frameCounter[1]) && (frameCounter[0] <= frameCounter[2])) {
                        frame[0] = ciag[i][j];
                        pagesFaults3[i] += 1;
                        frameCounter[0]++;
                    } else if (((frameCounter[1] < frameCounter[0]) && (frameCounter[1] <= frameCounter[2]))) {
                        frame[1] = ciag[i][j];
                        pagesFaults3[i] += 1;
                        frameCounter[1]++;
                    } else if (((frameCounter[2] < frameCounter[0]) && (frameCounter[2] < frameCounter[1]))) {
                        frame[2] = ciag[i][j];
                        pagesFaults3[i] += 1;
                        frameCounter[2]++;
                    }
                }
            }
        }
    }*/ // long version of three frames, to check if calculate method works correctly (I was sure this one worked correctly)

    public void calculatePagesFaults(int[][] ciag, int amountOfFrames) {
        int[] frame = new int[amountOfFrames];

        int frameCounter = 0;
        int p;
        for (int i = 0; i < ciag.length; i++) {
            for (int k = 0; k < frame.length; k++) {
                frame[k] = -1;
            }
            for (int j = 0; j < ciag[i].length; j++) {
                p = -1;
                for (int k = 0; k < frame.length; k++) {
                    if (frame[k] == ciag[i][j]) {
                        p = k;
                        break;
                    }
                }
                if (p == -1) {
                    frame[frameCounter] = ciag[i][j];
                    pagesFaults4[i]++;
                    frameCounter++;
                    if (frameCounter == frame.length) {
                        frameCounter = 0;
                    }
                }
            }
        }
    }
}
