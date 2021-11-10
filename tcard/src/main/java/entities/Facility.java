package entities;

import java.util.Arrays;
import java.util.ArrayList;

public class Facility implements CheckCriteria{
    protected ArrayList<String> facilityInfo = new ArrayList<>();
    final int FACILITY_NAME = 0;
    final int FACILITY_ADDRESS = 1;
    final int FACILITY_DESCRIPTION = 2;
    final int FACILITY_HOURS = 3;
    final int FACILITY_CRITERIA = 4;


    public Facility(ArrayList<String> facilityInfo) {
        // assuming facilityInfo has the following ordering of elements:
        // {name, address, description, hours, criteria}
        this.facilityInfo.add(facilityInfo.get(FACILITY_NAME));
        this.facilityInfo.add(facilityInfo.get(FACILITY_ADDRESS));
        this.facilityInfo.add(facilityInfo.get(FACILITY_DESCRIPTION));
        this.facilityInfo.add(facilityInfo.get(FACILITY_HOURS));
        this.facilityInfo.add(facilityInfo.get(FACILITY_CRITERIA));
    }

    public String displayFacilityInfo() {
        return "Facility Name: " + this.facilityInfo.get(FACILITY_NAME)+ "\n" +  "Facility Address: " +
                this.facilityInfo.get(FACILITY_ADDRESS) + "\n"+ "Facility Description: " +
                this.facilityInfo.get(FACILITY_DESCRIPTION) + "\n" + "Facility Hours: " +
                this.facilityInfo.get(FACILITY_HOURS) + "\n" + "Facility Criteria: " +
                this.facilityInfo.get(FACILITY_CRITERIA);
    }

    public String[] getConditionsArray(String conditions) {
        // helper function that takes a string like "program=(CS/MAT)" and returns the array {"CS", "MAT"}
        return conditions.substring(conditions.indexOf("(")+1, conditions.
                indexOf(")")).split("/");
    }

    @Override
    public boolean evaluate(User user) {
        // Example:
        // facility.getCriteria() = "program=(CS/MAT),level=(undergrad):department=(CS),position=(postdoc/professor)";

        String[] criteria = this.facilityInfo.get(FACILITY_CRITERIA).split(":");
        // criteria = {"program=(CS/MAT),level=(undergrad)", "department=(CS),position=(postdoc/professor)"}

        if (user.getProfile().get(user.STATUS).equals("student")) {
            criteria = criteria[0].split(",");
            // criteria = {"program=(CS/MAT)", "level=(undergrad)"}

            String[] programConditions = getConditionsArray(criteria[0]);
            // programConditions = {"CS", "MAT"}
            String[] levelConditions = getConditionsArray(criteria[1]);
            // levelConditions = {"undergrad"}

            boolean programConditionsSatisfied = Arrays.asList(programConditions).contains(user.
                    getProfile().get(((Student) user).STUDENT_PROGRAM));
            if (Arrays.asList(programConditions).contains("any")) {
                programConditionsSatisfied = true;
            }

            boolean levelConditionsSatisfied = Arrays.asList(levelConditions).contains(user.getProfile().
                    get(((Student) user).STUDENT_LEVEL));
            if (Arrays.asList(levelConditions).contains("any")) {
                levelConditionsSatisfied = true;
            }

            // Check if the student satisfies ANY of the required programs in the criteria AND ANY of the required
            // levels in the criteria
            return (programConditionsSatisfied & levelConditionsSatisfied);

        } else { // if the user is not a student, then the user is a faculty member
            criteria = criteria[1].split(",");
            // criteria = {"department=(CS)", "position=(postdoc/professor)"}

            String[] departmentConditions = getConditionsArray(criteria[0]);
            // departmentConditions = {"CS"}
            String[] positionConditions = getConditionsArray(criteria[1]);
            // positionConditions = {"postdoc", "professor"}

            boolean departmentConditionsSatisfied = Arrays.asList(departmentConditions).contains(user.
                    getProfile().get(((Faculty) user).FACULTY_DEPARTMENT));
            if (Arrays.asList(departmentConditions).contains("any")) {
                departmentConditionsSatisfied = true;
            }

            boolean positionConditionsSatisfied = Arrays.asList(positionConditions).contains(user.
                    getProfile().get(((Faculty) user).FACULTY_POSITION));
            if (Arrays.asList(positionConditions).contains("any")) {
                positionConditionsSatisfied = true;
            }

            // Check if the faculty satisfies ANY of the required programs in the criteria AND ANY of the required
            // levels in the criteria
            return (departmentConditionsSatisfied & positionConditionsSatisfied);
        }
    }

}
