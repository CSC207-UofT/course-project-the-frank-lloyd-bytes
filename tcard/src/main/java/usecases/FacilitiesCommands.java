package usecases;

import entities.Facility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * a class to create the facilties when the app is run, or when the facility button is clicked.
 */
public class FacilitiesCommands implements Serializable {
    private final ArrayList<Facility> FACILITIES;
    private final HashMap<String, Facility> FACILITY_Map = new HashMap<>();

    /**
     * when an instance of this class is made, an array list of all the facilities that are available will be passed in
     * the constructor then calls the create facilities function with all the info to create each facility instance
     * in the program so that they are entities and not just array list or from a database.
     * @param facilitiesInfo this is the info of all the facilities
     */
    public FacilitiesCommands(ArrayList<ArrayList<String>> facilitiesInfo){
        this.FACILITIES = this.createFacilities(facilitiesInfo);
    }

    /**
     * create each facility in the parameter passed in and create a hashmap of all the names of the facility
     * and the actual facility instance
     * @param facilitiesInfo the information of all the facilities in an arraylist of an arraylist of strings
     * @return an array list of facilities since there are multiple facilities' info passed in
     */
    private ArrayList<Facility> createFacilities(ArrayList<ArrayList<String>> facilitiesInfo) {
        ArrayList<Facility> facilities = new ArrayList<>();
        for (ArrayList<String> facility : facilitiesInfo){
            Facility facilityInstance = new Facility(facility);
            facilities.add(facilityInstance);
            FACILITY_Map.put(facility.get(0), facilityInstance);
        }
        return facilities;
    }

    /**
     * get the facility using the hashmap created when an instance of this class was made.
     * @param name the name of the facility
     * @return a facility object that has the name
     */
    public Facility getFacility(String name){
        return FACILITY_Map.get(name);
    }

    public ArrayList<ArrayList<String>> getInfo() {
        ArrayList<ArrayList<String>> facilitiesArray = new ArrayList<>();
        for (Facility facility : FACILITIES){
            facilitiesArray.add(facility.getFacilityInfo());
        }
        return facilitiesArray;
    }
}
