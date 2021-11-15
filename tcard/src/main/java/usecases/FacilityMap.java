package usecases;

import entities.Facility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FacilityMap {
    private final HashMap<String, Facility> facilityMap = new HashMap<>();

    public FacilityMap(ArrayList<ArrayList<String>> facilityList){
        for (ArrayList<String> strings : facilityList) {
            Facility facility = new Facility(strings);
            facilityMap.put(facility.getFacilityInfo().get(0), facility);
        }
    }

    public Facility getFacility(String name){
        return facilityMap.get(name);
    }

    public String getFacilityName(String name){
        return Objects.requireNonNull(facilityMap.get(name)).getFacilityInfo().get(0);
    }

    public String getFacilityAddress(String name){
        return Objects.requireNonNull(facilityMap.get(name)).getFacilityInfo().get(1);
    }

    public String getFacilityHours(String name){
        return Objects.requireNonNull(facilityMap.get(name)).getFacilityInfo().get(3);
    }

}
