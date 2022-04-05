package PagesReplacment;

public class PagesLru {
    private int[] pagesFaults;


    public PagesLru() {
        pagesFaults = new int[100];

    }

    public PagesLru(int amount) {
        pagesFaults = new int[amount];

    }

    public int[] getPagesFaults() {
        return pagesFaults;
    }


    public void calculatePagesFaults(int[][] ciag, int amountOfFrames) {
        int[] frame = new int[amountOfFrames];
        if(pagesFaults[0] != 0) {
            for (int i = 0; i < pagesFaults.length; i++) {
                pagesFaults[i] = 0;
            }
        }
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
                        if(frameCounter >= amountOfFrames){
                            frameCounter = 0;
                        }
                        else{
                            frameCounter++;
                        }
                        break;
                    }
                }
                if (p == -1) {
                    if(frameCounter >= amountOfFrames){
                        frameCounter = 0;
                    }
                    frame[frameCounter] = ciag[i][j];
                    pagesFaults[i]++;
                    frameCounter++;
                    if (frameCounter == frame.length) {
                        frameCounter = 0;
                    }
                }
            }
        }
    }
}
