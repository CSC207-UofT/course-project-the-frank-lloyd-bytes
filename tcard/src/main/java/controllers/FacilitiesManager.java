package controllers;

import entities.Facility;
import entities.Faculty;
import entities.Student;
import entities.User;
import usecases.FacilitiesCommands;
import usecases.FacilityHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * class that connects the use cases and the GUI
 */
public class FacilitiesManager implements Serializable {
    private final FacilityHelper MY_FACILITY_HELPER;
    private final FacilitiesCommands FACILITIES_COMMANDS;

    /**
     * create a new facility manager that sets up a facility map with the read file from the database
     */
    public FacilitiesManager(ArrayList<ArrayList<String>> facilitiesInfo) {
        this.FACILITIES_COMMANDS = new FacilitiesCommands(facilitiesInfo);
        this.MY_FACILITY_HELPER = new FacilityHelper();
    }

    /**
     * method for getting the facility instance with the name
     * @param name of the facility that we are trying to find
     * @return a facility type variable where the name matches the parameter.
     */
    public Facility getFacility(String name){
        return this.FACILITIES_COMMANDS.getFacility(name);
    }

    /**
     * an evaluate helper function that checks whether the user passed in is a student or a faculty member
     * it then calls the evaluate function with the corresponding user. THis is to reduce the size of one large
     * method with both evaluates which is a code smell.
     * @param user the user to check if it has access
     * @param facility the facility to check if the user has access to
     * @return boolean whether the user can enter the facility
     */
    public boolean evaluateHelper(User user, Facility facility){
        if (Objects.equals(MY_FACILITY_HELPER.StudentFacultyDifferHelper(user), "Student")){
            return evaluateStudent((Student) user, facility);
        }
        else{
            return evaluateFaculty((Faculty) user, facility);
        }
    }

    /**
     * called with the evaluate helper if the user is a student and checks if the student matches the criteria of the
     * facility
     * @param student to check if they have the right credentials
     * @param facility to check if the user can enter this facility with its criteria
     * @return boolean whether the student can answer
     */
    public boolean evaluateStudent(Student student, Facility facility){
        ArrayList<String[]> conditions = MY_FACILITY_HELPER.
                getFacilityCriteriaStudent(MY_FACILITY_HELPER.getCriteria(facility));
        String[] programConditions = conditions.get(0);
        String[] yearConditions = conditions.get(1);

        ArrayList<String> studentInfo = MY_FACILITY_HELPER.getStudentInfo(student);
        String studentProgram = studentInfo.get(0);
        String studentYear = studentInfo.get(1);

        boolean programConditionSatisfied = Arrays.asList(programConditions).contains(studentProgram);
        if(Arrays.asList(programConditions).contains("any")){
            programConditionSatisfied = true;
        }

        boolean yearConditionSatisfied = Arrays.asList(yearConditions).contains(studentYear);
        if(Arrays.asList(programConditions).contains("any")){
            yearConditionSatisfied = true;
        }

        return (programConditionSatisfied & yearConditionSatisfied);
    }

    /**
     * called with the evaluate helper if the user is a faculty and checks if the faculty matches the criteria of the
     * facility
     * @param faculty to check if they have the right credentials
     * @param facility to check if the user can enter this facility with its criteria
     * @return boolean whether the faculty can enter
     */
    public boolean evaluateFaculty(Faculty faculty, Facility facility){
        ArrayList<String[]> conditions = MY_FACILITY_HELPER.
                getFacilityCriteriaFaculty(MY_FACILITY_HELPER.getCriteria(facility));
        String[] departmentConditions = conditions.get(0);
        String[] yearConditions = conditions.get(1);

        ArrayList<String> facultyInfo = MY_FACILITY_HELPER.getFacultyInfo(faculty);
        String facultyDepartment = facultyInfo.get(0);
        String facultyYear = facultyInfo.get(1);

        boolean departmentConditionSatisfied = Arrays.asList(departmentConditions).contains(facultyDepartment);
        if(Arrays.asList(departmentConditions).contains("any")){
            departmentConditionSatisfied = true;
        }

        boolean yearConditionSatisfied = Arrays.asList(yearConditions).contains(facultyYear);
        if(Arrays.asList(yearConditions).contains("any")){
            yearConditionSatisfied = true;
        }
        return (departmentConditionSatisfied & yearConditionSatisfied);
    }
}
