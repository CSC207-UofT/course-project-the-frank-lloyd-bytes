package entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FacultyTest {
    private Faculty sampleUser;
    private Faculty sampleUser2;

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
        sampleFacultyInfo.add(""); // picture

        sampleUser = new Faculty(sampleFacultyInfo);
        sampleFacultyInfo.add("1");
        sampleUser2 = new Faculty(sampleFacultyInfo);
    }
    @Test
    public void testCheckPassword() {
        Assert.assertTrue(sampleUser.checkPassword("password!"));
        Assert.assertFalse(sampleUser.checkPassword("incorrectpassword"));
    }

    @Test
    public void testChangePassword() {
        String newPassword = "newpassword!";
        sampleUser.changePassword(newPassword);

        Assert.assertTrue(sampleUser.checkPassword(newPassword));
    }

    @Test
    public void testGetUserInfo() {
        ArrayList<String> expectedUserInfo = new ArrayList<>();
        expectedUserInfo.add("mackeyjonah"); // utorid
        expectedUserInfo.add("password!"); // password
        expectedUserInfo.add("Jonah"); // first name
        expectedUserInfo.add("Mackey"); // last name
        expectedUserInfo.add("faculty"); // status
        expectedUserInfo.add("1234567890"); // ID number
        expectedUserInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        expectedUserInfo.add("2"); // year
        expectedUserInfo.add("Math"); // program
        expectedUserInfo.add(""); // picture

        Assert.assertEquals(expectedUserInfo, sampleUser.getUserInfo());
    }


    @Test
    public void changePicture() {
        sampleUser.changePicture("1");
        Assert.assertEquals("1", sampleUser.picture);
    }

    @Test
    public void changePicture2() {
        sampleUser2.changePicture("2");
        Assert.assertEquals("2", sampleUser2.picture);
    }

    @Test
    public void getFN() { Assert.assertEquals("Jonah", sampleUser.getFN());
    }

    @Test
    public void getLN() { Assert.assertEquals("Mackey", sampleUser.getLN());
    }

    @Test
    public void getSTATUS() { Assert.assertEquals("faculty", sampleUser.getSTATUS());
    }

    @Test
    public void testGetId() {
        Assert.assertEquals("mackeyjonah", sampleUser.getId());
    }

    @Test
    public void testGetIdNumber() {
        Assert.assertEquals("1234567890", sampleUser.getID_NUMBER());
    }

    @Test
    public void testGetEmail() {
        Assert.assertEquals("jonah.mackey@mail.utoronto.ca", sampleUser.getEMAIL());
    }
}