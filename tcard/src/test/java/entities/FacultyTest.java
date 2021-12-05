package entities;

import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

public class FacultyTest {
    private Faculty sampleFaculty;

    @Before
    public void setUp() {
        ArrayList<String> sampleFacultyInfo = new ArrayList<>();
        sampleFacultyInfo.add("mackeyjonah"); // utorid
        sampleFacultyInfo.add("password!"); // password
        sampleFacultyInfo.add("Jonah"); // first name
        sampleFacultyInfo.add("Mackey"); // last name
        sampleFacultyInfo.add("faculty"); // status
        sampleFacultyInfo.add("1234567890"); // ID number
        sampleFacultyInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleFacultyInfo.add("2"); // year
        sampleFacultyInfo.add("Math"); // department

        sampleFaculty = new Faculty(sampleFacultyInfo);
    }

    @After
    public void tearDown() {
        sampleFaculty = null;
    }
}