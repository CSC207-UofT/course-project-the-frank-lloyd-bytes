package usecases;


import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UserCommandsTest {
    ArrayList<String> sampleStudentInfo = new ArrayList<>();
    ArrayList<String> sampleFacultyInfo = new ArrayList<>();
    private UserCommands sampleUserCommands1;
    private UserCommands sampleUserCommands2;

    @Before
    public void setUp() {
        // create sample student

        sampleStudentInfo.add("mackeyjonah"); // utorid
        sampleStudentInfo.add("password!"); // password
        sampleStudentInfo.add("Jonah"); // first name
        sampleStudentInfo.add("Mackey"); // last name
        sampleStudentInfo.add("student"); // status
        sampleStudentInfo.add("1234567890"); // ID number
        sampleStudentInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleStudentInfo.add("4"); // year
        sampleStudentInfo.add("Math"); // program
        sampleStudentInfo.add("1"); //picture


        // create sample faculty

        sampleFacultyInfo.add("mackeyjonah"); // utorid
        sampleFacultyInfo.add("password!"); // password
        sampleFacultyInfo.add("Jonah"); // first name
        sampleFacultyInfo.add("Mackey"); // last name
        sampleFacultyInfo.add("faculty"); // status
        sampleFacultyInfo.add("1234567890"); // ID number
        sampleFacultyInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleFacultyInfo.add("2"); // year
        sampleFacultyInfo.add("Math"); // program


        sampleUserCommands1 = new UserCommands(sampleStudentInfo);
        sampleUserCommands2 = new UserCommands(sampleFacultyInfo);
    }


    @Test
    public void testChangePassword1() {
        sampleUserCommands1.changePassword("password!", "newpassword!", "newpassword!");
        sampleUserCommands2.changePassword("incorrectpassword!", "newpassword!", "newpassword!");

        Assert.assertTrue(sampleUserCommands1.getUser().checkPassword("newpassword!"));
        Assert.assertFalse(sampleUserCommands2.getUser().checkPassword("newpassword!"));
    }


    @Test
    public void testChangePassword2() {
        UserCommands.PasswordUpdateResult result1 = sampleUserCommands1.changePassword("", "newpassword!", "newpassword!");
        UserCommands.PasswordUpdateResult result2 = sampleUserCommands2.changePassword("incorrectpassword!", "newpassword!", "newpassword!");
        UserCommands.PasswordUpdateResult result3 = sampleUserCommands1.changePassword("password!", "newpassword", "newpassword!");
        UserCommands.PasswordUpdateResult result4 = sampleUserCommands1.changePassword("password!", "newpassword!", "newpassword!");
        UserCommands.PasswordUpdateResult result5 = sampleUserCommands1.changePassword("newpassword!", "newpassword!", "newpassword!");

        Assert.assertEquals(UserCommands.PasswordUpdateResult.EMPTY_FIELD, result1);
        Assert.assertEquals(UserCommands.PasswordUpdateResult.OLD_PASSWORD_WRONG, result2);
        Assert.assertEquals(UserCommands.PasswordUpdateResult.NEW_ATTEMPTS_DONT_MATCH, result3);
        Assert.assertEquals(UserCommands.PasswordUpdateResult.SUCCESS, result4);
        Assert.assertEquals(UserCommands.PasswordUpdateResult.NEW_SAME_AS_OLD, result5);

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

    @Test
    public void testChangePicture(){
        sampleUserCommands1.changePicture("2");
        sampleUserCommands2.changePicture("2");
        Assert.assertEquals("2", sampleUserCommands2.getInfo().get(9));
    }

    @Test
    public void testGetInfo(){
        Assert.assertEquals(sampleStudentInfo, sampleUserCommands1.getInfo());
    }

    @After
    public void tearDown() {
        sampleUserCommands1 = null;
        sampleUserCommands2 = null;
    }
}