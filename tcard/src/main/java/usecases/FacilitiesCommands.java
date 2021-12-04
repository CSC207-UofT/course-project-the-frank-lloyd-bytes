package usecases;

import entities.Facility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class FacilitiesCommands implements Serializable {
    private final ArrayList<Facility> FACILITIES;
    private final HashMap<String, Facility> facilityMap = new HashMap<>();

    public FacilitiesCommands(ArrayList<ArrayList<String>> facilitiesInfo){
        this.FACILITIES = this.createFacilities(facilitiesInfo);
    }

    private ArrayList<Facility> createFacilities(ArrayList<ArrayList<String>> facilitiesInfo) {
        ArrayList<Facility> facilities = new ArrayList<>();
        for (ArrayList<String> facility : facilitiesInfo){
            Facility facilityInstance = new Facility(facility);
            facilities.add(facilityInstance);
            facilityMap.put(facility.get(0), facilityInstance);
        }
        return facilities;
    }

    public Facility getFacility(String name){
        return facilityMap.get(name);
    }



    public ArrayList<ArrayList<String>> getInfo() {
        ArrayList<ArrayList<String>> facilitiesArray = new ArrayList<>();
        for (Facility facility : FACILITIES){
            facilitiesArray.add(facility.getFacilityInfo());
        }
        return facilitiesArray;
    }
}
