package usecases;

import entities.Discount;
import entities.Merchant;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class MerchantMapTest extends TestCase {
    List<String> sampleMerchantInfo1 = new ArrayList<>();
    List<String> sampleMerchantInfo2 = new ArrayList<>();
    List<List<String>> sampleMerchantList = new ArrayList<>();
    MerchantMap sampleMerchantMap;


    public void setUp() throws Exception {
        super.setUp();
        // create sample merchant 1 info
        sampleMerchantInfo1.add("U of T Bookstore");
        sampleMerchantInfo1.add("214 College Street");
        sampleMerchantInfo1.add("11am to 6pm");
        sampleMerchantInfo1.add("70:(textbooks/stationary/chips):(any).(MAT/PHY):(1/2).(APM/CS)");

        // create sample merchant 2 info
        sampleMerchantInfo2.add("Cafe Reznikoff");
        sampleMerchantInfo2.add("75 St George St");
        sampleMerchantInfo2.add("7:30am to 11pm");
        sampleMerchantInfo2.add("20:(hats/sweaters):(any).(MAT/PHY):(1/2).(APM/CS)");

        // create sample merchant map
        sampleMerchantList.add(sampleMerchantInfo1);
        sampleMerchantList.add(sampleMerchantInfo2);

        sampleMerchantMap = new MerchantMap(sampleMerchantList);
    }

    public void testGetMerchant() {
        // To test that two merchants are equal, we check that their name, address, hours, and discounts are equal.
        Merchant actualMerchant = sampleMerchantMap.getMerchant("U of T Bookstore");

        assertEquals("U of T Bookstore", actualMerchant.getName());
        assertEquals("214 College Street", actualMerchant.getAddress());
        assertEquals("11am to 6pm", actualMerchant.getHours());

        List<String> actualMerchantDiscounts = new ArrayList<>();
        for (Discount discount : actualMerchant.getDiscounts()) {
            actualMerchantDiscounts.add(discount.toString());
            actualMerchantDiscounts.add(discount.getCriteria());
        }

        List<String> expectedMerchantDiscounts = new ArrayList<>();
        expectedMerchantDiscounts.add("70% off on textbooks, stationary, and chips!");
        expectedMerchantDiscounts.add("(any).(MAT/PHY):(1/2).(APM/CS)");

        assertEquals(expectedMerchantDiscounts, actualMerchantDiscounts);
    }
}