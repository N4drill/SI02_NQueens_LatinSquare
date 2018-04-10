package NQueen;

public class NQueenProblem {
    int board[][];
    int notSafePositions[][];
    int board_size;
    Researches research = new Researches(0,0);

    public NQueenProblem(int size) {
        board_size = size;
        board = new int[size][size];
        emptyBoard();
    }

    private void emptyBoard() {
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                board[i][j] = 0 ;
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
               System.out.print("["+board [j][i]+"]");
            }
            System.out.println();
        }
    }

    private boolean isQueenSafe(int [][] board, int pot_y , int pot_x){
        boolean SAFE = true;
           //if(pot_y>=1) {
               for(int i= 0 ; i <board_size; i++){
                   for(int j= 0 ; j<board_size; j++){
                       if(board[i][j] == 1){
                           if(pot_x == j) SAFE = false; // ten sam rzad
                           if(pot_y == i) SAFE = false; // ta sama kolumna
                           if(Math.abs(j-i) == Math.abs(pot_x-pot_y)) SAFE = false; // na przecieciu
                       }
                   }
               }
           //}
        return SAFE;
    }

    public void placeQueen(int x, int y){
        if(x>=board_size || y>=board_size || x<0 || y<0) System.out.println("Nie dodano: "+"["+x+","+y+"] -wyszedles poza szachownice");
        else{
            board[x][y] = 1;
        }
    }

    public void placeQueenOnlyIfSafe(int x, int y){
        if(x>=board_size || y>=board_size || x<0 || y<0) System.out.println("Nie dodano: "+"["+x+","+y+"] -wyszedles poza szachownice");
        else{
            if(isQueenSafe(board,x,y)) board[x][y] = 1;
            else{
                System.out.println("Nie dodano: ["+x+","+y+"] - bo zagrozona");
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean backtracking(int [][] board, int col){
        if(col >=board_size) return true;

        for(int i = 0 ; i< board_size; i++){
            research.operations++;
            if(isQueenSafe(board,i,col)) {
                board[i][col] = 1;

                if (backtracking(board, col + 1)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    public void run(int [][] board, int board_size){
        long start_time = System.currentTimeMillis();
        backtracking(board,board_size);
        long end_time = System.currentTimeMillis();
        research.duration = end_time-start_time;
    }

    public void printResearches(){
        System.out.println("For size: "+board_size);
        System.out.println("Time is: "+research.duration + "ms");
        System.out.println("Operations: "+ research.operations+"\n");
    }



}
