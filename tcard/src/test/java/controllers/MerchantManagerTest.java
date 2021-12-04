package controllers;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class MerchantManagerTest extends TestCase {
    MerchantManager sampleMerchantManager;

    public void setUp() throws Exception {
        super.setUp();

        List<String> sampleMerchantInfo1 = new ArrayList<>();
        sampleMerchantInfo1.add("U of T Bookstore");
        sampleMerchantInfo1.add("214 College Street");
        sampleMerchantInfo1.add("11am to 6pm");
        sampleMerchantInfo1.add("70:(textbooks/stationary/chips):(any).(any):().()|30:(fruit/snacks):().():(any).(any)");

        List<List<String>> sampleMerchantList = new ArrayList<>();
        sampleMerchantList.add(sampleMerchantInfo1);

        // create sample student
        List<String> sampleUserInfo = new ArrayList<>();
        sampleUserInfo.add("mackeyjonah"); // utorid
        sampleUserInfo.add("password!"); // password
        sampleUserInfo.add("Jonah"); // first name
        sampleUserInfo.add("Mackey"); // last name
        sampleUserInfo.add("student"); // status
        sampleUserInfo.add("1234567890"); // ID number
        sampleUserInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleUserInfo.add("1"); // year
        sampleUserInfo.add("MAT"); // program

        UserManager sampleUserManager = new UserManager(sampleUserInfo);

        sampleMerchantManager = new MerchantManager(sampleMerchantList, sampleUserManager);
    }

    public void testCheckApplicableDiscounts() {
        List<String> expectedDiscounts = new ArrayList<>();
        expectedDiscounts.add("70% off on textbooks, stationary, and chips!");

        assertEquals(expectedDiscounts, sampleMerchantManager.checkApplicableDiscounts("U of T Bookstore"));
    }
}