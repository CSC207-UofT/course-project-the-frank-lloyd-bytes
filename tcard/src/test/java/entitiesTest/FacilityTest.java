package entitiesTest;

import entities.Facility;
import entities.Faculty;
import entities.Student;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FacilityTest {
    private Facility sampleFacility;
    private Student sampleStudent1;
    private Student sampleStudent2;
    private Student sampleStudent3;
    private Faculty sampleFaculty1;
    private Faculty sampleFaculty2;

//    {facility name, facility address, description of facility, facility hours, facility criteria}
    @Before
    public void setUp() {
        // Create sample facility
        ArrayList<String> sampleFacilityInfo = new ArrayList<>();
        sampleFacilityInfo.add("Bahen Centre"); // name
        sampleFacilityInfo.add("40 St George Street"); // address
        sampleFacilityInfo.add("The Bahen Centre for Information Technology!"); // description
        sampleFacilityInfo.add("Monday: 8:30AM-9:00PM"); // hours
        sampleFacilityInfo.add("program=(CS/MAT),year=(1/2):department=(APM),year=(any)"); // criteria

        sampleFacility = new Facility(sampleFacilityInfo);

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

        sampleStudent1 = new Student(sampleStudentInfo1); // student that is allowed access (correct program, correct year)

        ArrayList<String> sampleStudentInfo2 = new ArrayList<>();
        sampleStudentInfo2.add("mackeyjonah"); // utorid
        sampleStudentInfo2.add("password!"); // password
        sampleStudentInfo2.add("Jonah"); // first name
        sampleStudentInfo2.add("Mackey"); // last name
        sampleStudentInfo2.add("student"); // status
        sampleStudentInfo2.add("1234567890"); // ID number
        sampleStudentInfo2.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleStudentInfo2.add("1"); // year
        sampleStudentInfo2.add("APM"); // program

        sampleStudent2 = new Student(sampleStudentInfo2); // student that is not allowed access (incorrect program, correct year)

        ArrayList<String> sampleStudentInfo3 = new ArrayList<>();
        sampleStudentInfo3.add("mackeyjonah"); // utorid
        sampleStudentInfo3.add("password!"); // password
        sampleStudentInfo3.add("Jonah"); // first name
        sampleStudentInfo3.add("Mackey"); // last name
        sampleStudentInfo3.add("student"); // status
        sampleStudentInfo3.add("1234567890"); // ID number
        sampleStudentInfo3.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleStudentInfo3.add("3"); // year
        sampleStudentInfo3.add("CS"); // program

        sampleStudent3 = new Student(sampleStudentInfo3); // student that is not allowed access (incorrect year, correct program)

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

        sampleFaculty1 = new Faculty(sampleFacultyInfo1); // faculty that allowed access (correct department, correct year)

        ArrayList<String> sampleFacultyInfo2 = new ArrayList<>();
        sampleFacultyInfo2.add("mackeyjonah"); // utorid
        sampleFacultyInfo2.add("password!"); // password
        sampleFacultyInfo2.add("Jonah"); // first name
        sampleFacultyInfo2.add("Mackey"); // last name
        sampleFacultyInfo2.add("faculty"); // status
        sampleFacultyInfo2.add("1234567890"); // ID number
        sampleFacultyInfo2.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleFacultyInfo2.add("6"); // year
        sampleFacultyInfo2.add("CS"); // department

        sampleFaculty2 = new Faculty(sampleFacultyInfo2); // faculty that is not allowed access (incorrect program, correct year)


    }

    @Test
    public void testDisplayFacilityInfo() {
       String expectedFacilityString = "Facility Name: Bahen Centre\nFacility Address: 40 St George Street\nFacility " +
               "Description: The Bahen Centre for Information Technology!\nFacility Hours: Monday: 8:30AM-9:00PM\n" +
               "Facility Criteria: program=(CS/MAT),year=(1/2):department=(APM),year=(any)";

       Assert.assertEquals(expectedFacilityString, sampleFacility.displayFacilityInfo());
    }

    @Test
    /*public void testEvaluate() {
        Assert.assertTrue(sampleFacility.evaluate(sampleStudent1));
        Assert.assertFalse(sampleFacility.evaluate(sampleStudent2));
        Assert.assertFalse(sampleFacility.evaluate(sampleStudent3));
        Assert.assertTrue(sampleFacility.evaluate(sampleFaculty1));
        Assert.assertFalse(sampleFacility.evaluate(sampleFaculty2));
    }
    */
    @After
    public void tearDown() {
        sampleFacility = null;
        sampleStudent1 = null;
        sampleStudent2 = null;
        sampleStudent3 = null;
        sampleFaculty1 = null;
        sampleFaculty2 = null;
    }
}