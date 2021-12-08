package usecases;

import entities.Facility;
import entities.Faculty;
import entities.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FacilityHelperTest {
    FacilityHelper facilityHelper = new FacilityHelper();
    Facility facility;
    Student user1;
    Faculty user2;
    ArrayList<String> userInfo = new ArrayList<>();
    ArrayList<String> facilityInfo = new ArrayList<>();
    @Before
    public void setUp() throws Exception {

        userInfo.add("mackeyjonah"); // utorid
        userInfo.add("password!"); // password
        userInfo.add("Jonah"); // first name
        userInfo.add("Mackey"); // last name
        userInfo.add("student"); // status
        userInfo.add("1234567890"); // ID number
        userInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        userInfo.add("4"); // year
        userInfo.add("Math"); // program
        userInfo.add(""); // picture

        //Create sample users
        user1 = new Student(userInfo);
        userInfo.set(4, "faculty");
        user2 = new Faculty(userInfo);

        // Create sample facility
        facilityInfo.add("Bahen Centre"); // name
        facilityInfo.add("40 St George Street"); // address
        facilityInfo.add("The Bahen Centre for Information Technology!"); // description
        facilityInfo.add("Monday: 8:30AM-9:00PM"); // hours
        facilityInfo.add("program=(CS/MAT),year=(1/2):department=(APM),year=(any)"); // criteria

        facility = new Facility(facilityInfo);

    }

    @Test
    public void studentFacultyDifferHelper() {
        assertEquals("student", facilityHelper.StudentFacultyDifferHelper(user1));
        assertEquals("faculty", facilityHelper.StudentFacultyDifferHelper(user2));
    }

    @Test
    public void getCriteria() {
        assertEquals("[program=(CS/MAT), year=(1/2)]", Arrays.toString(facilityHelper.getCriteria(facility)));
    }


    @Test
    public void getStudentInfo() {
        assertEquals("[Math, 4]", facilityHelper.getStudentInfo(user1).toString());
    }



    @Test
    public void getFacultyInfo() {
        assertEquals("[Math, 4]", facilityHelper.getFacultyInfo(user2).toString());
    }
}