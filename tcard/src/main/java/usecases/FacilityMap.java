package usecases;

import entities.Facility;

import java.util.ArrayList;
import java.util.HashMap;

public class FacilityMap {
    private HashMap<String, Facility> facilityMap = new HashMap<>();

    public FacilityMap(ArrayList<ArrayList<String>> facilityList){
        for (ArrayList<String> strings : facilityList) {
            Facility facility = new Facility(strings);
            facilityMap.put(facility.getFacilityInfo().get(0), facility);
        }
    }

    public Facility getFacility(String name){
        return facilityMap.get(name);
    }

}
