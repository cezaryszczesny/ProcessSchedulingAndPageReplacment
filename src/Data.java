import java.io.*;

public class Data {
    private int[][][] ciag;

    public void writeNumbersToFile(int[][][] ciag) throws IOException {
        FileWriter fw = new FileWriter("dane.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);

        for (int k = 0; k < ciag.length; k++) {
            for (int i = 0; i < ciag[k].length; i++) {
                out.println(ciag[k][i][0] + ";" + ciag[k][i][1] + ";" + ciag[k][i][2]);
            }
        }
        out.flush();
        out.close();
    }
    public void writePagesToFile(int[][] ciag) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("pages.csv", true));
        PrintWriter out = new PrintWriter(bw);

        for(int i = 0;i< ciag.length;i++){
            for(int j = 0; j<ciag[i].length;j++){
                out.println(ciag[i][j]);
            }
        }
    }
}
