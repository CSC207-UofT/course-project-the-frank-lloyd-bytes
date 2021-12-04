package entities;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class MerchantTest extends TestCase {
    String sampleDiscountInfo1;
    String sampleDiscountInfo2;
    Discount sampleDiscount1;
    Discount sampleDiscount2;
    List<String> sampleMerchantInfo = new ArrayList<>();
    String sampleMerchantName;
    String sampleMerchantAddress;
    String sampleMerchantHours;
    String sampleMerchantDiscounts;
    Merchant sampleMerchant;

    public void setUp() throws Exception {
        super.setUp();

        sampleDiscountInfo1 = "70:(textbooks/stationary/chips):(any).(MAT/PHY):(1/2).(APM/CS)";
        sampleDiscountInfo2 = "20:(hats/sweaters):(any).(MAT/PHY):(1/2).(APM/CS)";

        sampleDiscount1 = new Discount(sampleDiscountInfo1);
        sampleDiscount2 = new Discount(sampleDiscountInfo2);

        sampleMerchantName = "U of T Bookstore";
        sampleMerchantAddress = "214 College Street";
        sampleMerchantHours = "11am to 6pm";
        sampleMerchantDiscounts = sampleDiscountInfo1 + "|" + sampleDiscountInfo2;

        sampleMerchantInfo.add(sampleMerchantName);
        sampleMerchantInfo.add(sampleMerchantAddress);
        sampleMerchantInfo.add(sampleMerchantHours);
        sampleMerchantInfo.add(sampleMerchantDiscounts);

        sampleMerchant = new Merchant(sampleMerchantInfo);
    }

    public void testTestGetName() {
        String expectedName = sampleMerchantName;

        assertEquals(expectedName, sampleMerchant.getName());
    }

    public void testGetAddress() {
        String expectedAddress = sampleMerchantAddress;

        assertEquals(expectedAddress, sampleMerchant.getAddress());
    }

    public void testGetHours() {
        String expectedHours = sampleMerchantHours;

        assertEquals(expectedHours, sampleMerchant.getHours());
    }

    public void testGetDiscounts() {
        // To test that two discounts are equal, we check that their string representations and criteria are equal.
        List<String> expectedDiscounts = new ArrayList<>();
        expectedDiscounts.add(sampleDiscount1.toString());
        expectedDiscounts.add(sampleDiscount1.getCriteria());
        expectedDiscounts.add(sampleDiscount2.toString());
        expectedDiscounts.add(sampleDiscount2.getCriteria());

        List<String> actualDiscounts = new ArrayList<>();
        for (Discount discount : sampleMerchant.getDiscounts()) {
            actualDiscounts.add(discount.toString());
            actualDiscounts.add(discount.getCriteria());
        }

        assertEquals(expectedDiscounts, actualDiscounts);
    }
}