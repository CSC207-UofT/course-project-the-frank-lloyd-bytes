package dataBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
  A reader class that read the csv file.
 */
public class FileReader {
    protected final String FILE_ADDRESS;

    public FileReader(String fileAddress) {
        FILE_ADDRESS = fileAddress;
    }

    /**
     * Read the file in the provided address and return a list of what it read.
     * @return a list of string if the file is not empty
     */
    public List<List<String>> reader() throws IOException {
        List<List<String>> buildList = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new java.io.FileReader(FILE_ADDRESS));
        while ((line = br.readLine()) != null)
        {
            ArrayList<String> data = new ArrayList<>(Arrays.asList(line.split(splitBy)));
            buildList.add(data);
        }
        return buildList;
    }


}
