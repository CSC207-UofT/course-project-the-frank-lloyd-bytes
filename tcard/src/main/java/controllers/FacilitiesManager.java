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
import java.util.HashMap;
import java.util.Objects;

import dataBase.FileReader;

public class FacilitiesManager implements Serializable {
    private final FacilityHelper myFacilityHelper;
    private FacilitiesCommands facilitiesCommands;

    /**
     * create a new facility manager that sets up a facility map with the read file from the database
     */
    public FacilitiesManager(ArrayList<ArrayList<String>> facilitiesInfo) {
        this.facilitiesCommands = new FacilitiesCommands(facilitiesInfo);
        this.myFacilityHelper = new FacilityHelper();
    }

    public ArrayList<ArrayList<String>> getFacilitiesInfo(){
        return this.facilitiesCommands.getInfo();
    }

    public Facility getFacility(String name){
        return this.facilitiesCommands.getFacility(name);
    }

    //FileReader myFileReader = new FileReader();
    //ArrayList<ArrayList<String>> facilitiesInfo = myFileReader.reader();

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
