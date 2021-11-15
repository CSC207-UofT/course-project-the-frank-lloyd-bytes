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


    public FacilityManager() throws IOException {
        myFacilityMap = new FacilityMap(facilitiesInfo);
    }

    public FacilityMap getFacilitiesInfo() {
        return myFacilityMap;
    }



}
