package dataBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/*
  A reader class that read the csv file.
 */
public class FileReader {
    protected static final String  FILE_ADDRESS = "tcard\\UserInfo.txt";


    /**
     * Read the file in the provided address and return a list of what it read.
     * @return a list of string if the file is not empty
     */
    public ArrayList<String[]> reader() throws IOException {
        ArrayList<String[]> buildList = new ArrayList<String[]>();
        String line = "";
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new java.io.FileReader(FILE_ADDRESS));
        if ((line = br.readLine()) != null)
        {
            String[] user = line.split(splitBy);
            buildList.add(user);
            return buildList;
        }
        return buildList;
    }
}
