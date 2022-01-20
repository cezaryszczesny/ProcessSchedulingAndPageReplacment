package ProcessScheduling;

public class AlgFcfs extends AbstractAlgorithm {
    //First come first served

    public AlgFcfs() {
        super();

    }
    public AlgFcfs(int amount) {
        super(amount);

    }
    public  void calculateParameters(int[][][] ciag){

        for(int k=0;k<ciag.length;k++){
            int[] completionTime = new int[100];
            double p=0,temp=0;
            averageTat[k]=ciag[k][0][0];
            completionTime[0]=ciag[k][0][0];
            for(int i=1;i<ciag[k].length;i++){
                temp=p+ciag[k][i-1][0];
                averageTime[k] = averageTime[k] + temp/ciag[k].length;
                 p = ciag[k][i][1]+ciag[k][i-1][1];
                 if(ciag[k][i][1] > completionTime[i-1]){
                     completionTime[i] = ciag[k][i][1] + ciag[k][i][0];
                 }
                 else{
                     completionTime[i] = completionTime[i-1] + ciag[k][i][0];
                 }
                averageTat[k] = averageTat[k] + (completionTime[i]-ciag[k][i][1])/100;
            }
        }
    }
}
