package CSV;

import java.io.*;

public class CSV{
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    PrintWriter printWriter;
    String path;
    public CSV(String path) {
        this.path = path;
    }

    public void initiateCSVFile() throws FileNotFoundException{
        printWriter = new PrintWriter(path);
        printWriter.write("Size,Time,Operations,\n");

    }
    public void addRow(int size, long time, int operations)
    {
        String toADD = String.valueOf(size) + "," + String.valueOf(time) + "," + String.valueOf(operations) + "\n";
        printWriter.write(toADD);
    }
    public void closeCSV(){
       printWriter.close();
    }
}
