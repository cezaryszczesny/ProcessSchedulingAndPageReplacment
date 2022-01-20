public class Test {
    public void testGenerate(int[][][] tab){
        for(int k=0; k<tab.length;k++) {
            System.out.println("ciag " + (k + 1) + ":");
            for (int i = 0; i < tab[k].length; i++) {
                System.out.println("Proces " + (i + 1) + ":");
                for (int j = 0; j < tab[k][i].length; j++) {
                    if (j == 0)
                        System.out.println("E: " + tab[k][i][j]); //Execution time
                    else if (j == 1)
                        System.out.println("A: " + tab[k][i][j]); //Arrival time
                    else
                        System.out.println("F: " + tab[k][i][j]); //Flag

                }
            }
        }
    }//test generate numbers
    public void testParameters(double[] averageTime, double[] averageExecute){
        for(int i=0;i<100;i++){
            System.out.println("(Execution)Ciag " + i +": " + averageTime[i]);
            System.out.println("(Arrival)Ciag " + i +": " + averageExecute[i]);
        }
    }// test calculations

    public void testSjf(int[][][] ciag){
        for(int k = 0; k< ciag.length; k++){
            if(k!=0)
                System.out.println("Nowy" + ";" + "ciag");
            for( int i = 0; i<ciag[k].length; i++){
                System.out.println(i + ";" + ciag[k][i][0] + ";" + ciag[k][i][1] + ";" + ciag[k][i][2]);
            }
        }
    }

    public void testGeneratePages(int[][] ciag){
        for(int i=0; i < ciag.length;i++){
            System.out.println("Ciag" + (i+1));
            for(int j=0; j < ciag[i].length; j++){
                System.out.println("Strona: " + (j+1));
                System.out.println(ciag[i][j]);
            }
        }
    }

    public void testPagesFaults(int[] ciag){
        for(int i=0; i< ciag.length; i++){
            System.out.println("ID[" + (i+1) + "]: " + ciag[i]);
        }
    }
}
