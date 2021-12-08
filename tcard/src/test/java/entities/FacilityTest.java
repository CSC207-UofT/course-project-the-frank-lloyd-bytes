package entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FacilityTest {
    private Facility sampleFacility;
    ArrayList<String> sampleFacilityInfo = new ArrayList<>();


//    {facility name, facility address, description of facility, facility hours, facility criteria}
    @Before
    public void setUp() {
        // Create sample facility
        sampleFacilityInfo.add("Bahen Centre"); // name
        sampleFacilityInfo.add("40 St George Street"); // address
        sampleFacilityInfo.add("The Bahen Centre for Information Technology!"); // description
        sampleFacilityInfo.add("Monday: 8:30AM-9:00PM"); // hours
        sampleFacilityInfo.add("program=(CS/MAT),year=(1/2):department=(APM),year=(any)"); // criteria

        sampleFacility = new Facility(sampleFacilityInfo);




    }
    @Test
    public  void testGetFacilityInfo(){
        Assert.assertEquals(sampleFacilityInfo, sampleFacility.getFacilityInfo());
    }

    @Test
    public void testDisplayFacilityInfo() {
       String expectedFacilityString = "Facility Name: Bahen Centre\nFacility Address: 40 St George Street\nFacility " +
               "Description: The Bahen Centre for Information Technology!\nFacility Hours: Monday: 8:30AM-9:00PM\n" +
               "Facility Criteria: program=(CS/MAT),year=(1/2):department=(APM),year=(any)";

       Assert.assertEquals(expectedFacilityString, sampleFacility.displayFacilityInfo());
    }


}