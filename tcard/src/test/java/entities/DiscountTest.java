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
        assertEquals("(any).(MAT/PHY):(1/2).(APM/CS)", sampleDiscount1.getCriteria());
    }

    public void testTestToString() {
        assertEquals("-10% off on stickey notes!", sampleDiscount1.toString());
        assertEquals("-20% off on hats and sweaters!", sampleDiscount2.toString());
        assertEquals("-70% off on textbooks, stationary, and chips!", sampleDiscount3.toString());
    }
}