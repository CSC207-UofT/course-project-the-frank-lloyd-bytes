package controllers;

import entities.Facility;
import entities.Faculty;
import entities.Student;
import junit.framework.TestCase;
import java.util.ArrayList;

public class FacilitiesManagerTest extends TestCase {
    ArrayList<ArrayList<String>> faciInfo = new ArrayList<>();
    ArrayList<String> sampleFacilityInfo = new ArrayList<>();
    ArrayList<String> sampleFacilityInfo2 = new ArrayList<>();
    FacilitiesManager facilitiesManager;
    Facility facility;
    Facility facility2;
    private Student sampleStudent;
    private Faculty sampleFaculty;


    public void setUp() throws Exception {
        super.setUp();
        // set up the facility info
        sampleFacilityInfo.add("Bahen Centre"); // name
        sampleFacilityInfo.add("40 St George Street"); // address
        sampleFacilityInfo.add("The Bahen Centre for Information Technology!"); // description
        sampleFacilityInfo.add("Monday: 8:30AM-9:00PM"); // hours
        sampleFacilityInfo.add("program=(CS/MAT),year=(1/2):department=(APM),year=(any)"); // criteria

        sampleFacilityInfo2.add("Robarts Library"); // name
        sampleFacilityInfo2.add("130 St George Street"); // address
        sampleFacilityInfo2.add("The Favorite Library of Yanbin's"); // description
        sampleFacilityInfo2.add("Monday: 8:30AM-9:00PM"); // hours
        sampleFacilityInfo2.add("program=(any),year=(any):department=(any),year=(any)"); // criteria

        faciInfo.add(sampleFacilityInfo);
        faciInfo.add(sampleFacilityInfo2);
        facility = new Facility(sampleFacilityInfo);
        facility2 = new Facility(sampleFacilityInfo2);

        // create sample students
        ArrayList<String> sampleStudentInfo1 = new ArrayList<>();
        sampleStudentInfo1.add("mackeyjonah"); // utorid
        sampleStudentInfo1.add("password!"); // password
        sampleStudentInfo1.add("Jonah"); // first name
        sampleStudentInfo1.add("Mackey"); // last name
        sampleStudentInfo1.add("student"); // status
        sampleStudentInfo1.add("1234567890"); // ID number
        sampleStudentInfo1.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleStudentInfo1.add("2"); // year
        sampleStudentInfo1.add("MAT"); // program

        sampleStudent = new Student(sampleStudentInfo1); // student that is allowed access (correct program, correct year)

        // create sample faculty
        ArrayList<String> sampleFacultyInfo1 = new ArrayList<>();
        sampleFacultyInfo1.add("mackeyjonah"); // utorid
        sampleFacultyInfo1.add("password!"); // password
        sampleFacultyInfo1.add("Jonah"); // first name
        sampleFacultyInfo1.add("Mackey"); // last name
        sampleFacultyInfo1.add("faculty"); // status
        sampleFacultyInfo1.add("1234567890"); // ID number
        sampleFacultyInfo1.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleFacultyInfo1.add("5"); // year
        sampleFacultyInfo1.add("APM"); // department

        sampleFaculty = new Faculty(sampleFacultyInfo1); // faculty that allowed access (correct department, correct year)

    }

    public void testGetFacility() {
        facilitiesManager = new FacilitiesManager(faciInfo);
        assertEquals(facility.getFacilityInfo(), facilitiesManager.getFacility("Bahen Centre").getFacilityInfo());
    }

    public void testEvaluateHelper() {
        facilitiesManager = new FacilitiesManager(faciInfo);
        assertTrue(facilitiesManager.evaluateHelper(sampleStudent, facility2));
    }

    public void testEvaluateFaculty() {
        facilitiesManager = new FacilitiesManager(faciInfo);
        assertTrue(facilitiesManager.evaluateHelper(sampleFaculty, facility2));
    }
}
