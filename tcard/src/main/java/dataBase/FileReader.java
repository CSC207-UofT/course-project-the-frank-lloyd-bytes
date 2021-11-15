package dataBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/*
  A reader class that read the csv file.
 */
public class FileReader {
    protected static final String  FILE_ADDRESS = "tcard\\FacilitiesInfo.csv";


    /**
     * Read the file in the provided address and return a list of what it read.
     * @return a list of string if the file is not empty
     */
    public ArrayList<ArrayList<String>> reader() throws IOException {
        ArrayList<ArrayList<String>> buildList = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new java.io.FileReader(FILE_ADDRESS));
        while ((line = br.readLine()) != null)
        {
            ArrayList<String> data = new ArrayList<>(Arrays.asList(line.split(splitBy)));
            buildList.add(data);
            return buildList;
        }
        return buildList;
    }
}
