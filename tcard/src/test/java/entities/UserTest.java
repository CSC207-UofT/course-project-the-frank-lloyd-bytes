package entities;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UserTest {
    private User sampleUser;
    private User sampleUser2;

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
        sampleUserInfo.add("Math"); // belongs to

        sampleUser = new Student(sampleUserInfo);
        sampleUserInfo.add("1");
        sampleUser2 = new Student(sampleUserInfo);
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
        expectedUserInfo.add("student"); // status
        expectedUserInfo.add("1234567890"); // ID number
        expectedUserInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        expectedUserInfo.add("4"); // year
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
    public void getSTATUS() { Assert.assertEquals("student", sampleUser.getSTATUS());
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

    @After
    public void tearDown() {
        sampleUser = null;
    }
}


