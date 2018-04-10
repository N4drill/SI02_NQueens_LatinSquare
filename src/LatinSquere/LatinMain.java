package LatinSquere;

import CSV.CSV;

import java.io.FileNotFoundException;

public class LatinMain {
    public static final int SQUERE_SIZE = 12;
    public static final int MAX_SIZE = 15;


    public static void main(String [] args) throws FileNotFoundException {
//        LatinSquare latinSquare = new LatinSquare(SQUERE_SIZE);
//        latinSquare.initSquere();
//        latinSquare.run();
//        latinSquare.printResearches();
      //  CSV csv = new CSV("E:/Workspaces/InteliJWorkspace/SI02_QueensProblem/CSVDatas/LatinSquares.csv");
       // csv.initiateCSVFile();
        for (int i = 2; i<=MAX_SIZE ; i++){
            LatinSquare latinSquare = new LatinSquare(i);
            latinSquare.initSquere();
            latinSquare.run();
            latinSquare.printResearches();
        //    csv.addRow(i,latinSquare.researches.duration,latinSquare.researches.operations);
        }
       // csv.closeCSV();
    }

}
