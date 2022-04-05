import java.io.*;

public class Data {
    private int[][][] ciag;

    public void writeNumbersToFile(int[][][] ciag) throws IOException {
        FileWriter fw = new FileWriter("processes.csv", false);
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
        BufferedWriter bw = new BufferedWriter(new FileWriter("pages.csv", false));
        PrintWriter out = new PrintWriter(bw);

        for(int i = 0;i< ciag.length;i++){
            for(int j = 0; j<ciag[i].length;j++){
                out.println(ciag[i][j]);
            }
        }
        out.flush();
        out.close();
    }
    public void writePagesResults(double[] result) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("pagesResults.txt", false));
        PrintWriter out = new PrintWriter(bw);

        out.println("Algorytmy wymiany stron - porównanie");
        out.println("ilosc ramek | FIFO | LRU ");
        out.println("3 ramki:      " + result[0] + "     " + result[3]);
        out.println("5 ramek:      " + result[1] + "     " + result[4]);
        out.println("7 ramek:      " + result[2] + "     " + result[5]);
        out.flush();
        out.close();
    }
    public void writeSchedulingResults(double[] result) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("schedulingResults.txt", false));
        PrintWriter out = new PrintWriter(bw);

        out.println("FCFS");
        out.println("Średni czas oczekiwania: " + result[0]);
        out.println("Średni czas cyklu: " + result[1]);
        out.println("____________________");
        out.println("SJF");
        out.println("Średni czas oczekiwania: " + result[2]);
        out.println("Średni czas cyklu: " + result[3]);

        out.flush();
        out.close();
    }
}
