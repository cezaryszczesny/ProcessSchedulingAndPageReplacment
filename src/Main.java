import PagesReplacment.PagesFifo;
import PagesReplacment.PagesNumbers;
import ProcessScheduling.AlgFcfs;
import ProcessScheduling.AlgSjf;
import ProcessScheduling.NumbersProcess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //For inputs
        NumbersProcess generator = new NumbersProcess();//For new numbers
        Test test = new Test(); //For tests
        AlgFcfs fcfs = new AlgFcfs(); //For FCFS alhorithm
        AlgSjf sjf = new AlgSjf();
        PagesNumbers generate = new PagesNumbers();
        PagesFifo fifo = new PagesFifo();

        generate.generate(); //generatePages
       //generator.generate(); //generate numbers

           /*try {
            Data saveFile = new Data();
            saveFile.printToFile(generator.getTab());
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        } //write generate numbers to file
    */


        //Pages replacment Algorithm tests
        //test.debugGeneratePages(generate.getCiag()); //debug PagesReplacment.PagesNumbers generator
        // test.testPagesFaults(fifo.getPagesFaults3());
        // System.out.println("Drugi Algorytm");
        // fifo.calculatePagesFaults(generate.getCiag(),3);
        // test.testPagesFaults(fifo.getPagesFaults4());



        //Process schedulinng algorithm tests
        //test.debugGenerate(generator.getTab());//debug ProcessNumbers generator
        //test.debugSjf(sjf.calculateParameters((generator.getTab()))); //debug sjf algorithm
        //test.debugGenerate(generator.sortByArrivals(generator.getTab())); //Debug sort by Time of arrival
        //fcfs.calculateParameters(generator.sortByArrivals(generator.getTab())); //calculate average time and average execution time
        //test.debugParameters(fcfs.getAverageTime(), fcfs.getAverageExecute()); //debug calculation
     }
    }
