package entities;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * This is a base for all facility classes. Stores basic facility information.
 *
 */
public class Facility implements CheckCriteria{
    protected ArrayList<String> facilityInfo = new ArrayList<>();
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
    public Facility(ArrayList<String> facilityInfo) {
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

    /**
     * This is a helper method used to convert a string of conditions for a criteria field to a list of strings
     * containing the same conditions.
     * @param conditions a string of conditions for a criteria field (e.g. "program=(CS/MAT)").
     * @return a list of strings containing conditions for criteria (e.g. {"CS", "MAT"}).
     */
    private String[] getConditionsArray(String conditions) {
        // helper function that takes a string like "program=(CS/MAT)" and returns the array {"CS", "MAT"}
        return conditions.substring(conditions.indexOf("(")+1, conditions.
                indexOf(")")).split("/");
    }

    /**
     * This is a method for checking if a given user may access this facility. A given user may enter the facility if their
     * information agrees with the criteria of the facility.
     * @param user a User object
     * @return a boolean indicating if the given user has access to the facility.
     */
    @Override
    public boolean evaluate(User user) {
        String[] criteria = this.facilityInfo.get(FACILITY_CRITERIA).split(":");

        if (user.getProfile().get(user.STATUS).equals("student")) {
            criteria = criteria[0].split(",");

            String[] programConditions = getConditionsArray(criteria[0]);
            String[] yearConditions = getConditionsArray(criteria[1]);

            boolean programConditionsSatisfied = Arrays.asList(programConditions).contains(user.
                    getProfile().get(((Student) user).STUDENT_PROGRAM));
            if (Arrays.asList(programConditions).contains("any")) {
                programConditionsSatisfied = true;
            }

            boolean yearConditionsSatisfied = Arrays.asList(yearConditions).contains(user.getProfile().
                    get(((Student) user).STUDENT_YEAR));
            if (Arrays.asList(yearConditions).contains("any")) {
                yearConditionsSatisfied = true;
            }

            // Check if the student satisfies ANY of the required programs in the criteria AND ANY of the required
            // levels in the criteria
            return (programConditionsSatisfied & yearConditionsSatisfied);

        } else { // if the user is not a student, then the user is a faculty member
            criteria = criteria[1].split(",");

            String[] departmentConditions = getConditionsArray(criteria[0]);
            String[] yearConditions = getConditionsArray(criteria[1]);

            boolean departmentConditionsSatisfied = Arrays.asList(departmentConditions).contains(user.
                    getProfile().get(((Faculty) user).FACULTY_DEPARTMENT));
            if (Arrays.asList(departmentConditions).contains("any")) {
                departmentConditionsSatisfied = true;
            }

            boolean yearConditionsSatisfied = Arrays.asList(yearConditions).contains(user.
                    getProfile().get(((Faculty) user).FACULTY_YEAR));
            if (Arrays.asList(yearConditions).contains("any")) {
                yearConditionsSatisfied = true;
            }

            // Check if the faculty satisfies ANY of the required programs in the criteria AND ANY of the required
            // levels in the criteria
            return (departmentConditionsSatisfied & yearConditionsSatisfied);
        }
    }

}
