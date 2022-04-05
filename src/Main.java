import PagesReplacment.PagesFifo;
import PagesReplacment.PagesNumbers;
import ProcessScheduling.AlgFcfs;
import ProcessScheduling.AlgSjf;
import ProcessScheduling.NumbersProcess;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        Menu menu = new Menu();


        int x;
        do{
            x=menu.mainMenu();
            if(x == 1){
                menu.pageMenu();

            }
            else if(x == 2){
                menu.schedulingMenu();
            }
        }while(x != 0);

         /*
        Scanner input = new Scanner(System.in); //For inputs
        NumbersProcess generator = new NumbersProcess();//For new numbers
        Test test = new Test(); //For tests
        AlgFcfs fcfs = new AlgFcfs(); //For FCFS alhorithm
        AlgSjf sjf = new AlgSjf();
        PagesNumbers generate = new PagesNumbers();
        PagesFifo fifo = new PagesFifo()/ //used for testing
        */
       // generate.generate(); //generatePages
       //generator.generate(); //generate numbers





        //Pages replacment Algorithm tests
        //test.testGeneratePages(generate.getTab()); //test PagesReplacment.PagesNumbers generator
        // test.testPagesFaults(fifo.getPagesFaults3());
        // System.out.println("Drugi Algorytm");
        // fifo.calculatePagesFaults(generate.getCiag(),3);
        // test.testPagesFaults(fifo.getPagesFaults4());



        //Process schedulinng algorithm tests
        //test.testGenerate(generator.getTab());//test ProcessNumbers generator
        //test.testSjf(sjf.calculateParameters((generator.getTab()))); //test sjf algorithm
        //test.testGenerate(generator.sortByArrivals(generator.getTab())); //test sort by Time of arrival
       // fcfs.calculateParameters(generator.sortByArrivals(generator.getTab())); //calculate average time and average execution time
        //test.testParameters(fcfs.getAverageTime(), fcfs.getAverageExecute()); //test calculation
     }
    }
