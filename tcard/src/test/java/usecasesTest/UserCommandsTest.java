package usecasesTest;

import entities.Faculty;
import entities.Student;
import entities.User;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecases.UserCommands;

import java.util.ArrayList;

public class UserCommandsTest {
    private User sampleStudent;
    private User sampleFaculty;
    private UserCommands sampleUserCommands1;
    private UserCommands sampleUserCommands2;

    @Before
    public void setUp() {
        // create sample student
        ArrayList<String> sampleStudentInfo = new ArrayList<>();
        sampleStudentInfo.add("mackeyjonah"); // utorid
        sampleStudentInfo.add("password!"); // password
        sampleStudentInfo.add("Jonah"); // first name
        sampleStudentInfo.add("Mackey"); // last name
        sampleStudentInfo.add("student"); // status
        sampleStudentInfo.add("1234567890"); // ID number
        sampleStudentInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleStudentInfo.add("4"); // year
        sampleStudentInfo.add("Math"); // program

        sampleStudent = new Student(sampleStudentInfo);

        // create sample faculty
        ArrayList<String> sampleFacultyInfo = new ArrayList<>();
        sampleFacultyInfo.add("mackeyjonah"); // utorid
        sampleFacultyInfo.add("password!"); // password
        sampleFacultyInfo.add("Jonah"); // first name
        sampleFacultyInfo.add("Mackey"); // last name
        sampleFacultyInfo.add("faculty"); // status
        sampleFacultyInfo.add("1234567890"); // ID number
        sampleFacultyInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleFacultyInfo.add("2"); // year
        sampleFacultyInfo.add("Math"); // program

        sampleFaculty = new Faculty(sampleFacultyInfo);

        sampleUserCommands1 = new UserCommands(sampleStudentInfo);
        sampleUserCommands2 = new UserCommands(sampleFacultyInfo);
    }


    @Test
    public void testChangePassword() {
        sampleUserCommands1.changePassword("password!", "newpassword!", "newpassword!");
        sampleUserCommands2.changePassword("incorrectpassword!", "newpassword!", "newpassword!");

        Assert.assertTrue(sampleUserCommands1.getUser().checkPassword("newpassword!"));
        Assert.assertFalse(sampleUserCommands2.getUser().checkPassword("newpassword!"));
    }

    @Test
    public void testUserID() {
        Assert.assertEquals("mackeyjonah", sampleUserCommands2.getId());
        Assert.assertEquals("mackeyjonah", sampleUserCommands1.getId());
    }

    @Test
    public void testFullName() {
        Assert.assertEquals("Jonah Mackey", sampleUserCommands2.getFullName());
        Assert.assertEquals("Jonah Mackey", sampleUserCommands1.getFullName());
    }

    @After
    public void tearDown() {
        sampleStudent = null;
        sampleFaculty = null;
        sampleUserCommands1 = null;
        sampleUserCommands2 = null;
    }
}