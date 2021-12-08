package controllers;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class UserManagerTest extends TestCase {
    List<String> sampleStudentInfo = new ArrayList<>();
    UserManager userManager;

    public void setUp() throws Exception {
        super.setUp();
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

        userManager = new UserManager(sampleStudentInfo);
    }

    public void testGetInfo() {
        assertEquals(sampleStudentInfo, userManager.getInfo());
    }

    public void testChangePassword() {
        userManager.changePassword("password!", "ppp", "ppp");

        assertEquals("ppp", userManager.getInfo().get(1));
    }

    public void testChangePicture() {
        userManager.changePicture("1");
        assertEquals("1", userManager.getInfo().get(9));
    }

    public void testGetId() {
        assertEquals("mackeyjonah", userManager.getId());
    }

    public void testGetFullName() {
        assertEquals("Jonah Mackey", userManager.getFullName());
    }
}