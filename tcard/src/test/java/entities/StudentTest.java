package entities;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {
    private Student sampleStudent;

    @Before
    public void setUp() {
        ArrayList<String> sampleUserInfo = new ArrayList<>();
        sampleUserInfo.add("mackeyjonah"); // utorid
        sampleUserInfo.add("password!"); // password
        sampleUserInfo.add("Jonah"); // first name
        sampleUserInfo.add("Mackey"); // last name
        sampleUserInfo.add("student"); // status
        sampleUserInfo.add("1234567890"); // ID number
        sampleUserInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleUserInfo.add("4"); // year
        sampleUserInfo.add("Math"); // program

        sampleStudent = new Student(sampleUserInfo);
    }

    @Test
    public void testDisplayProfile() {
        String expectedProfileString = "First Name: Jonah\nLast Name: Mackey\nUTORid: mackeyjonah\nStatus: student\n" +
                "ID number: 1234567890\nEmail: jonah.mackey@mail.utoronto.ca\nProgram of Study: Math\nYear of Study: 4";
        Assert.assertEquals(expectedProfileString, sampleStudent.displayProfile());
    }

    @After
    public void tearDown() {
        sampleStudent = null;
    }
}