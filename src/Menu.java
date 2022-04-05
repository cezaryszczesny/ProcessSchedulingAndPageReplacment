import PagesReplacment.PagesFifo;
import PagesReplacment.PagesLru;
import PagesReplacment.PagesNumbers;
import ProcessScheduling.AlgFcfs;
import ProcessScheduling.AlgSjf;
import ProcessScheduling.NumbersProcess;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public int mainMenu() {
        System.out.println("Program testujący algorytmy wymiany stron oraz algorytm przydziału czasu procesora");
        System.out.println("Wybierz opcje:");
        System.out.println("1. Algorytm wymiany stron");
        System.out.println("2. Algorytm przydziału procesów");
        System.out.println("0. Wyjdź z programu");


        System.out.print(">");
        int choice = 0;
        choice = input.nextInt();
        input.nextLine();
        return choice;
    }

    public void pageMenu() {
        int p = 1;
        PagesNumbers generate = new PagesNumbers();
        PagesFifo fifo1 = new PagesFifo();
        PagesFifo fifo2 = new PagesFifo();
        PagesFifo fifo3 = new PagesFifo();
        PagesLru lru1 = new PagesLru();
        PagesLru lru2 = new PagesLru();
        PagesLru lru3 = new PagesLru();

        generate.generate();







        int[][] pagesFaultsFifo = new int[3][100];
        fifo1.calculatePagesFaults(generate.getTab(), 3);
        pagesFaultsFifo[0] = fifo1.getPagesFaults();

        fifo2.calculatePagesFaults(generate.getTab(), 5);
        pagesFaultsFifo[1] = fifo2.getPagesFaults();

        fifo3.calculatePagesFaults(generate.getTab(), 7);
        pagesFaultsFifo[2] = fifo3.getPagesFaults();


        int[][] pagesFaultsLru = new int[3][100];
        lru1.calculatePagesFaults(generate.getTab(), 3);
        pagesFaultsLru[0] = lru1.getPagesFaults();

        lru2.calculatePagesFaults(generate.getTab(), 5);
        pagesFaultsLru[1] = lru2.getPagesFaults();

        lru3.calculatePagesFaults(generate.getTab(), 7);
        pagesFaultsLru[2] = lru3.getPagesFaults();

        double[] result = generate.finalResult(pagesFaultsFifo[0],pagesFaultsFifo[1], pagesFaultsFifo[2], pagesFaultsLru[0], pagesFaultsLru[1], pagesFaultsLru[2]);
        while (p != 0) {
            System.out.println("Algorytm wymiany stron");
            System.out.println("Wybierz opcje");
            System.out.println("1. Algorytm FIFO");
            System.out.println("2. Algorytm LRU");
            System.out.println("3. Porównaj algorytmy");
            System.out.println("0. Menu główne");
            System.out.print(">");
            int temp = 0;
            temp = input.nextInt();
            input.nextLine();
            int end = 1;
            switch (temp) {
                case 1:
                    do {
                        System.out.println("Algorytm wymiany stron - FIFO");
                        System.out.println("ID      3  5  7");
                        System.out.println("-----------------");
                        for (int i = 0; i < 100; i++) {
                            System.out.print("ID[" + (i + 1) + "]: ");

                            for(int j=0; j<3;j++){
                                System.out.print(pagesFaultsFifo[j][i] + " ");

                            }
                            System.out.println("");
                        }
                        System.out.println("_______________________________________");
                        System.out.println("Wpisz 0, aby zakonczyc przeglądanie");
                        end = input.nextInt();
                        input.nextLine();
                    }while(end != 0);
                    break;
                case 2:
                    do {
                        System.out.println("Algorytm wymiany stron - LRU");
                            System.out.println("ID      3  5  7");
                            System.out.println("-----------------");
                            for (int i = 0; i < 100; i++) {
                                System.out.print("ID[" + (i + 1) + "]: ");

                                for(int j=0; j<3;j++){
                                    System.out.print(pagesFaultsLru[j][i] + " ");

                                }
                                System.out.println("");
                            }
                            System.out.println("_______________________________________");
                            System.out.println("Wpisz 0, aby zakonczyc przeglądanie");
                        end = input.nextInt();
                        input.nextLine();
                    }while(end != 0);
                    break;
                case 3:
                    do {
                    System.out.println("Algorytmy wymiany stron - porównanie");
                        System.out.println("ilosc ramek | FIFO | LRU ");
                        System.out.println("3 ramki:      " + result[0] + "     " + result[3]);
                        System.out.println("5 ramek:      " + result[1] + "     " + result[4]);
                        System.out.println("7 ramek:      " + result[2] + "     " + result[5]);

                        System.out.println("_______________________________________");
                        System.out.println("Wpisz 0, aby zakonczyc przeglądanie");
                        end = input.nextInt();
                        input.nextLine();
                    }while(end != 0);
                    break;
                case 0:
                    p = 0;
                                    try {
                    Data saveFile = new Data();
                    saveFile.writePagesToFile(generate.getTab());
                    saveFile.writePagesResults(result);
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                } //write generate numbers to file
                System.out.println("Zapisano dane testowe w pliku \"pages.csv\" ");
                System.out.println("Zapisano dane testowe w pliku \"pagesResults.txt\" ");
                    break;
                default:
            }
        }
    }

    public void schedulingMenu() {
        int p = 1;

        NumbersProcess generator = new NumbersProcess();
        AlgFcfs fcfs = new AlgFcfs();
        AlgSjf sjf = new AlgSjf();

        double[] averageTatFCFS;
        double[] averageTimeFCFS;
        double[] averageTimeSJF;
        double[] averageTatSJF;

        generator.generate();
        generator.sortByArrivals(generator.getTab());
        fcfs.calculateParameters(generator.getTab());
        sjf.calculateParameters(generator.getTab());

        averageTatFCFS = fcfs.getAverageTat();
        averageTimeFCFS = fcfs.getAverageTime();
        averageTatSJF = sjf.getAverageTat();
        averageTimeSJF = sjf.getAverageTime();

        double[] result;
        result = generator.finalResult(averageTatFCFS,averageTimeFCFS, averageTimeSJF, averageTatSJF);
        while (p != 0) {
            System.out.println("Algorytm planowania przydziału procesora");
            System.out.println("Wybierz opcje");
            System.out.println("1. Algorytm FCFS");
            System.out.println("2. Algorytm SJF");
            System.out.println("3. Porównaj algorytmy");
            System.out.println("0. Menu główne");
            System.out.print(">");
            int temp = 0;
            temp = input.nextInt();
            input.nextLine();

            int end=1;
            switch (temp) {
                case 1:
                    do {
                        for (int i = 0; i < averageTimeFCFS.length; i++) {
                            System.out.println("Ciąg: " + i);
                            System.out.println("Średni czas oczekiwania: " + averageTimeFCFS[i]);
                            System.out.println("Średni czas cyklu: " + averageTatFCFS[i]);
                        }
                        System.out.println("_______________________________________");
                        System.out.println("Wpisz 0, aby zakonczyc przeglądanie");
                        end = input.nextInt();
                        input.nextLine();
                    }while(end != 0);
                    break;
                case 2:
                    do {
                        for (int i = 0; i < averageTimeSJF.length; i++) {
                            System.out.println("Ciąg: " + i);
                            System.out.println("Średni czas oczekiwania: " + averageTimeSJF[i]);
                            System.out.println("Średni czas cyklu: " + averageTatSJF[i]);
                        }
                        System.out.println("_______________________________________");
                        System.out.println("Wpisz 0, aby zakonczyc przeglądanie");
                        end = input.nextInt();
                        input.nextLine();
                    }while(end != 0);
                    break;
                case 3:
                    do {
                        System.out.println("FCFS");
                        System.out.println("Średni czas oczekiwania: " + result[0]);
                        System.out.println("Średni czas cyklu: " + result[1]);
                        System.out.println("____________________");
                        System.out.println("");
                        System.out.println("SJF");
                        System.out.println("Średni czas oczekiwania: " + result[2]);
                        System.out.println("Średni czas cyklu: " + result[3]);
                        System.out.println("_______________________________________");
                        System.out.println("Wpisz 0, aby zakonczyc przeglądanie");
                        end = input.nextInt();
                        input.nextLine();
                    }while(end != 0);
                    break;
                case 0:
                    p = 0;
                    try {
                        Data saveFile = new Data();
                        saveFile.writeNumbersToFile(generator.getTab());
                        saveFile.writeSchedulingResults(result);
                    }
                    catch (IOException ioException) {
                        ioException.printStackTrace();
                    } //write generate numbers to file
                    System.out.println("Zapisane dane testowe w pliku \"processes.csv\" ");
                    System.out.println("Zapisane dane testowe w pliku \"schedulingResults.txt\" ");
                    break;
                default:
            }
        }
    }
}

