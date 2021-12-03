package controllers;

import entities.Facility;
import entities.Faculty;
import entities.Student;
import entities.User;
import usecases.FacilityMap;
import usecases.FacilityHelper;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import dataBase.FileReader;

public class FacilityManager implements Serializable {
    private final FacilityMap myFacilityMap;
    private final FacilityHelper myFacilityHelper;

    FileReader myFileReader = new FileReader();
    ArrayList<ArrayList<String>> facilitiesInfo = myFileReader.reader();

    /**
     * get the facilities info in an array format rather than a FacilityMap
     * @return an array list of the facilities in the database
     */
    public ArrayList<ArrayList<String>> getFacilitiesInfoArray(){
        return facilitiesInfo;
    }

    /**
     * create a new facility manager that sets up a facility map with the read file from the database
     * @throws IOException if construction doesn't work
     */
    public FacilityManager() throws IOException {
        myFacilityMap = new FacilityMap(facilitiesInfo);
        myFacilityHelper = new FacilityHelper();
    }

    /**
     * get the facilities info in map format, or as a FacilityMap
     * @return a FacilityMap from the database read by the reader

    public FacilityMap getFacilitiesInfo() {
        return myFacilityMap;
    }
     */

    public boolean evaluateHelper(User user, Facility facility){
        if (Objects.equals(myFacilityHelper.StudentFacultyDifferHelper(user), "Student")){
            return evaluateStudent((Student) user, facility);
        }
        else{
            return evaluateFaculty((Faculty) user, facility);
        }
    }

    public boolean evaluateStudent(Student student, Facility facility){
        ArrayList<String[]> conditions = myFacilityHelper.
                getFacilityCriteriaStudent(myFacilityHelper.getCriteria(facility));
        String[] programConditions = conditions.get(0);
        String[] yearConditions = conditions.get(1);

        ArrayList<String> studentInfo = myFacilityHelper.getStudentInfo(student);
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

    public boolean evaluateFaculty(Faculty faculty, Facility facility){
        ArrayList<String[]> conditions = myFacilityHelper.
                getFacilityCriteriaFaculty(myFacilityHelper.getCriteria(facility));
        String[] departmentConditions = conditions.get(0);
        String[] yearConditions = conditions.get(1);

        ArrayList<String> facultyInfo = myFacilityHelper.getFacultyInfo(faculty);
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
