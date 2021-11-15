package controllers;

import entities.User;
import usecases.FacilityMap;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import dataBase.FileReader;

public class FacilityManager implements Serializable {
    private final FacilityMap myFacilityMap;
    FileReader myFileReader = new FileReader();
    ArrayList<ArrayList<String>> facilitiesInfo = myFileReader.reader();

    /**
     * get the facilities info in an array format rather than a FacilityMap
     * @return an array list of the facilities in the database
     */
    public ArrayList<ArrayList<String>> getFacilitiesInfoArray(){
        return facilitiesInfo;
    }

    /**
     * create a new facility manager that sets up a facility map with the read file from the database
     * @throws IOException if construction doesn't work
     */
    public FacilityManager() throws IOException {
        myFacilityMap = new FacilityMap(facilitiesInfo);
    }

    /**
     * get the facilities info in map format, or as a FacilityMap
     * @return a FacilityMap from the database read by the reader
     */
    public FacilityMap getFacilitiesInfo() {
        return myFacilityMap;
    }


}
