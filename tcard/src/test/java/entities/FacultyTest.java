package entities;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FacultyTest {
    private Faculty sampleFaculty;

    @Before
    public void setUp() {
        ArrayList<String> sampleUserInfo = new ArrayList<>();
        sampleUserInfo.add("mackeyjonah"); // utorid
        sampleUserInfo.add("password!"); // password
        sampleUserInfo.add("Jonah"); // first name
        sampleUserInfo.add("Mackey"); // last name
        sampleUserInfo.add("faculty"); // status
        sampleUserInfo.add("1234567890"); // ID number
        sampleUserInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleUserInfo.add("2"); // year
        sampleUserInfo.add("Math"); // program

        sampleFaculty = new Faculty(sampleUserInfo);
    }

    @Test
    public void testDisplayProfile() {
        String expectedProfileString = "First Name: Jonah\nLast Name: Mackey\nUTORid: mackeyjonah\nStatus: faculty\n" +
                "ID number: 1234567890\nEmail: jonah.mackey@mail.utoronto.ca\nDepartment: Math\nYears at U of T: 2";
        Assert.assertEquals(expectedProfileString, sampleFaculty.displayProfile());
    }

    @After
    public void tearDown() {
        sampleFaculty = null;
    }
}