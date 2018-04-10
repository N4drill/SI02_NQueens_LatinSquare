package NQueen;

public class Main {
    public final static int N = 3;

    public static void main(String []args){
       NQueenProblem nQueenProblem = new NQueenProblem(N);
        int [][] board = nQueenProblem.getBoard();
        nQueenProblem.run(board, 0);
        nQueenProblem.printBoard();
        nQueenProblem.printResearches();
    }

}
