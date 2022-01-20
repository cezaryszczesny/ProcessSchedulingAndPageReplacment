package PagesReplacment;

public class PagesLru {
    private int[] pagesFaults3;
    private int[] pagesFaults4;

    public PagesLru() {
        pagesFaults3 = new int[100];
        pagesFaults4 = new int[100];
    }

    public PagesLru(int amount) {
        pagesFaults3 = new int[amount];
        pagesFaults4 = new int[amount];
    }

    public int[] getPagesFaults3() {
        return pagesFaults3;
    }

    public int[] getPagesFaults4() {
        return pagesFaults4;
    }
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
                        frameCounter++;
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
