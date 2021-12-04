package usecases;

import entities.Discount;
import entities.Merchant;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class MerchantMapTest extends TestCase {
    String sampleDiscountInfo1;
    Discount sampleDiscount1;
    List<String> sampleMerchantInfo1 = new ArrayList<>();
    String sampleMerchantName1;
    String sampleMerchantAddress1;
    String sampleMerchantHours1;
    String sampleMerchantDiscounts1;
    Merchant sampleMerchant1;

    String sampleDiscountInfo2;
    Discount sampleDiscount2;
    List<String> sampleMerchantInfo2 = new ArrayList<>();
    String sampleMerchantName2;
    String sampleMerchantAddress2;
    String sampleMerchantHours2;
    String sampleMerchantDiscounts2;
    Merchant sampleMerchant2;

    List<List<String>> sampleMerchantList = new ArrayList<>();
    MerchantMap sampleMerchantMap;


    public void setUp() throws Exception {
        super.setUp();
        // create sample merchant 1
        sampleDiscountInfo1 = "70:(textbooks/stationary/chips):(any).(MAT/PHY):(1/2).(APM/CS)";
        sampleDiscount1 = new Discount(sampleDiscountInfo1);

        sampleMerchantName1 = "U of T Bookstore";
        sampleMerchantAddress1 = "214 College Street";
        sampleMerchantHours1 = "11am to 6pm";
        sampleMerchantDiscounts1 = sampleDiscountInfo1;

        sampleMerchantInfo1.add(sampleMerchantName1);
        sampleMerchantInfo1.add(sampleMerchantAddress1);
        sampleMerchantInfo1.add(sampleMerchantHours1);
        sampleMerchantInfo1.add(sampleMerchantDiscounts1);

        sampleMerchant1 = new Merchant(sampleMerchantInfo1);

        // create sample merchant 2
        sampleDiscountInfo2 = "20:(hats/sweaters):(any).(MAT/PHY):(1/2).(APM/CS)";
        sampleDiscount2 = new Discount(sampleDiscountInfo2);

        sampleMerchantName2 = "Cafe Reznikoff";
        sampleMerchantAddress2 = "75 St George St";
        sampleMerchantHours2 = "7:30am to 11pm";
        sampleMerchantDiscounts2 = sampleDiscountInfo2;

        sampleMerchantInfo2.add(sampleMerchantName2);
        sampleMerchantInfo2.add(sampleMerchantAddress2);
        sampleMerchantInfo2.add(sampleMerchantHours2);
        sampleMerchantInfo2.add(sampleMerchantDiscounts2);

        sampleMerchant2 = new Merchant(sampleMerchantInfo2);

        // create sample merchant map
        sampleMerchantList.add(sampleMerchantInfo1);
        sampleMerchantList.add(sampleMerchantInfo2);

        sampleMerchantMap = new MerchantMap(sampleMerchantList);
    }

    public void testGetMerchant() {
        // To test that two merchants are equal, we check that their name, address, hours, and discounts are equal.
        Merchant actualMerchant1 = sampleMerchantMap.getMerchant(sampleMerchantName1);

        assertTrue(actualMerchant1.getName().equals(sampleMerchant1.getName()) && actualMerchant1.getAddress().
                equals(sampleMerchant1.getAddress()) && actualMerchant1.getHours().equals(sampleMerchant1.getHours()));

        List<String> actualMerchant1Discounts = new ArrayList<>();
        for (Discount discount : actualMerchant1.getDiscounts()) {
            actualMerchant1Discounts.add(discount.toString());
            actualMerchant1Discounts.add(discount.getCriteria());
        }

        List<String> expectedMerchant1Discounts = new ArrayList<>();
        for (Discount discount : sampleMerchant1.getDiscounts()) {
            expectedMerchant1Discounts.add(discount.toString());
            expectedMerchant1Discounts.add(discount.getCriteria());
        }

        assertEquals(expectedMerchant1Discounts, actualMerchant1Discounts);
    }
}