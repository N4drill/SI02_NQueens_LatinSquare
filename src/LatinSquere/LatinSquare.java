package LatinSquere;

public class LatinSquare {
    int [][] latinSquere;
    int size;
    Researches researches = new Researches(0,0);

    public LatinSquare(int size){
        this.size= size;
        latinSquere = new int [size][size];
    }

    public void initSquere(){
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                latinSquere[i][j] = 0;
            }
        }
    }

    public void printSquere(){
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                System.out.print("["+latinSquere[row][col] + "]");
            }
            System.out.println();
        }
    }

    private boolean checkROW(int valToAdd, int y_pos){
        boolean isValid = true;
        for(int col= 0; col<size; col++){
            if(latinSquere[col][y_pos] == valToAdd) isValid = false;
        }
        return isValid;
    }

    private boolean checkCOL(int valToAdd, int x_pos){
        boolean isValid = true;
        for(int row= 0; row<size; row++){
            if(latinSquere[x_pos][row] == valToAdd) isValid = false;
        }
        return isValid;
    }

    private boolean checkSAFE(int valToAdd, int x_pos, int y_pos){
        boolean isSafe = true;
        if(checkCOL(valToAdd,x_pos) == false || checkROW(valToAdd,y_pos) == false){
            isSafe=false;
        }
        return isSafe;
    }

    private void squereFinished(){
       System.out.println("Found this solution");
       printSquere();
    }

    private Position findNextEmpty() {
        for(int y= 0 ; y < size ; y++){
            for (int x = 0 ; x < size; x++){
                if(latinSquere[x][y] == 0 ) return new Position(x,y);
            }
        }
        return null;
    }

    public boolean backtracking(){
        Position nextEmpty = findNextEmpty();
        if(nextEmpty == null){
            squereFinished();
            return true;
        }
        for(int value = 1; value < size+1 ; value++ ){
            researches.operations++;
            if(checkSAFE(value,nextEmpty.getX(),nextEmpty.getY())){
                latinSquere[nextEmpty.getX()][nextEmpty.getY()] = value;
                if(backtracking()) return true;
                latinSquere[nextEmpty.getX()][nextEmpty.getY()] = 0;
            }
        }
        return false;
    }

    public void run(){
        long start_time = System.currentTimeMillis();
        backtracking();
        long end_time = System.currentTimeMillis();
        researches.duration = end_time-start_time;
    }

    public void printResearches(){
        System.out.println("For size: "+size);
        System.out.println("Time is: "+researches.duration + "ms");
        System.out.println("Operations: "+ researches.operations+"\n");
    }

}
