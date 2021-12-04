package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a base for all facility classes. Stores basic facility information.
 *
 */
public class Facility {
    protected List<String> facilityInfo = new ArrayList<>();
    final int FACILITY_NAME = 0;
    final int FACILITY_ADDRESS = 1;
    final int FACILITY_DESCRIPTION = 2;
    final int FACILITY_HOURS = 3;
    final int FACILITY_CRITERIA = 4;

    /**
     * This is a constructor for the Facility class. This method writes facility information from a list of strings
     * to a Facility object.
     * @param facilityInfo a list of strings containing information for a facility. This parameter is assumed
     *                      to have the following ordering:
     *                      {facility name, facility address, description of facility, facility hours, facility
     *                      criteria}
     */
    public Facility(List<String> facilityInfo) {
        this.facilityInfo.add(facilityInfo.get(FACILITY_NAME));
        this.facilityInfo.add(facilityInfo.get(FACILITY_ADDRESS));
        this.facilityInfo.add(facilityInfo.get(FACILITY_DESCRIPTION));
        this.facilityInfo.add(facilityInfo.get(FACILITY_HOURS));
        this.facilityInfo.add(facilityInfo.get(FACILITY_CRITERIA));
    }

    /**
     * This method is for displaying a facility's information.
     * @return a string that displays the facility's information.
     */
    public String displayFacilityInfo() {
        return "Facility Name: " + this.facilityInfo.get(FACILITY_NAME)+ "\n" +  "Facility Address: " +
                this.facilityInfo.get(FACILITY_ADDRESS) + "\n"+ "Facility Description: " +
                this.facilityInfo.get(FACILITY_DESCRIPTION) + "\n" + "Facility Hours: " +
                this.facilityInfo.get(FACILITY_HOURS) + "\n" + "Facility Criteria: " +
                this.facilityInfo.get(FACILITY_CRITERIA);
    }

    public ArrayList<String> getFacilityInfo(){
        ArrayList<String> facilityInfo = new ArrayList<>();
        facilityInfo.add(this.facilityInfo.get(FACILITY_NAME));
        facilityInfo.add(this.facilityInfo.get(FACILITY_ADDRESS));
        facilityInfo.add(this.facilityInfo.get(FACILITY_DESCRIPTION));
        facilityInfo.add(this.facilityInfo.get(FACILITY_HOURS));
        facilityInfo.add(this.facilityInfo.get(FACILITY_CRITERIA));

        return facilityInfo;
    }

}
