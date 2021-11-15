package controllers;

import entities.User;
import usecases.FacilityMap;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import dataBase.FileReader;

public class FacilityManager implements Serializable {
    private final FacilityMap myFacilityMap;


    public ArrayList<ArrayList<String>> getFacilitiesInfoArray() throws IOException {
        FileReader myFileReader = new FileReader();
        return myFileReader.reader();
    }
    public FacilityManager() throws IOException {
        FileReader myFileReader = new FileReader();
        ArrayList<ArrayList<String>> facilitiesInfo = myFileReader.reader();
        myFacilityMap = new FacilityMap(facilitiesInfo);
    }

    public FacilityMap getFacilitiesInfo() {
        return myFacilityMap;
    }

    public String getFacilityName(String name){
        return myFacilityMap.getFacilityName(name);
    }

    public String getFacilityAddress(String name){
        return myFacilityMap.getFacilityAddress(name);
    }

    public String getFacilityHours(String name){
        return myFacilityMap.getFacilityHours(name);
    }


}
