package entities;

import junit.framework.TestCase;

public class DiscountTest extends TestCase {
    Discount sampleDiscount1;
    Discount sampleDiscount2;
    Discount sampleDiscount3;

    public void setUp() throws Exception {
        super.setUp();

        sampleDiscount1 = new Discount("10:(stickey notes):(any).(MAT/PHY):(1/2).(APM/CS)");
        sampleDiscount2 = new Discount("20:(hats/sweaters):(any).(MAT/PHY):(1/2).(APM/CS)");
        sampleDiscount3 = new Discount("70:(textbooks/stationary/chips):(any).(MAT/PHY):(1/2).(APM/CS)");
    }

    public void testGetCriteria() {
        String expectedCriteria = "(any).(MAT/PHY):(1/2).(APM/CS)";

        assertEquals(expectedCriteria, sampleDiscount1.getCriteria());
    }

    public void testTestToString() {
        String expectedString1 = "-10% off on stickey notes!";
        String expectedString2 = "-20% off on hats and sweaters!";
        String expectedString3 = "-70% off on textbooks, stationary, and chips!";

        assertEquals(expectedString1, sampleDiscount1.toString());
        assertEquals(expectedString2, sampleDiscount2.toString());
        assertEquals(expectedString3, sampleDiscount3.toString());
    }
}