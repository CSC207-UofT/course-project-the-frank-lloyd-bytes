package entities;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class MerchantTest extends TestCase {
    List<String> sampleMerchantInfo = new ArrayList<>();
    Merchant sampleMerchant;

    public void setUp() throws Exception {
        super.setUp();

        sampleMerchantInfo.add("U of T Bookstore");
        sampleMerchantInfo.add("214 College Street");
        sampleMerchantInfo.add("11am to 6pm");
        sampleMerchantInfo.add("70:(textbooks/stationary/chips):(any).(MAT/PHY):(1/2).(APM/CS)" + "|" + "20:(hats/sweaters):(any).(MAT/PHY):(1/2).(APM/CS)");

        sampleMerchant = new Merchant(sampleMerchantInfo);
    }

    public void testTestGetName() {
        assertEquals("U of T Bookstore", sampleMerchant.getName());
    }

    public void testGetAddress() {
        assertEquals("214 College Street", sampleMerchant.getAddress());
    }

    public void testGetHours() {
        assertEquals("11am to 6pm", sampleMerchant.getHours());
    }

    public void testGetDiscounts() {
        // To test that two discounts are equal, we check that their string representations and criteria are equal.
        List<String> expectedDiscounts = new ArrayList<>();
        expectedDiscounts.add("-70% off on textbooks, stationary, and chips!");
        expectedDiscounts.add("(any).(MAT/PHY):(1/2).(APM/CS)");
        expectedDiscounts.add("-20% off on hats and sweaters!");
        expectedDiscounts.add("(any).(MAT/PHY):(1/2).(APM/CS)");

        List<String> actualDiscounts = new ArrayList<>();
        for (Discount discount : sampleMerchant.getDiscounts()) {
            actualDiscounts.add(discount.toString());
            actualDiscounts.add(discount.getCriteria());
        }

        assertEquals(expectedDiscounts, actualDiscounts);
    }
}