package ProcessScheduling;

public abstract class AbstractAlgorithm implements ProcessSchedulingInterface {
    protected double[] averageTime; //average waiting time
    protected double[] averageTat;//turn around time

    protected AbstractAlgorithm(){
        this.averageTat = new double[100];
        this.averageTime = new double[100];
    }//creates default object

    protected AbstractAlgorithm(int amount){
        this.averageTat = new double[amount];
        this.averageTime = new double[amount];
    }//creates special object with required amount

    @Override
    public double[] getAverageTat() {
        return averageTat;
    }

    @Override
    public double[] getAverageTime() {
        return averageTime;
    }

}
