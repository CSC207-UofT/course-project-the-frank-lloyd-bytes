package dataBase;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/*
  A reader class that read the csv file.
 */
public class DataBaseSetter {
    protected static final String  FILE_ADDRESS = "tcard\\UserInfo.txt";

    /**
     * Read the file in the provided address and return a list of what it read.
     * @param fileaddress The address of the file we want to read
     * @return a list of string if the file is not empty
     */
    public ArrayList<String[]> reader(String fileaddress) throws IOException {
        ArrayList<String[]> buildList = new ArrayList<String[]>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileaddress));
            while ((line = br.readLine()) != null)
            {
                String[] user = line.split(splitBy);
                buildList.add(user);
                return buildList;
            }
        } catch (IOException e) {
            throw e;
        }
        return buildList;
    }

    public void setter() throws IOException {
        ArrayList<String[]> buildList = this.reader(FILE_ADDRESS);


    }
}