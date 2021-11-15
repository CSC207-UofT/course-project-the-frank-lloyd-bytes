package usecases;

import entities.Facility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.ArrayList;

public class FacilityMapTest {
    private Facility sampleFacility1;
    private Facility sampleFacility2;
    private FacilityMap sampleFacilityMap;

    @Before
    public void setUp() {
        // create sample facilities
        ArrayList<String> sampleFacilityInfo1 = new ArrayList<>();
        sampleFacilityInfo1.add("Bahen Centre"); // name
        sampleFacilityInfo1.add("40 St George Street"); // address
        sampleFacilityInfo1.add("The Bahen Centre for Information Technology!"); // description
        sampleFacilityInfo1.add("Monday: 8:30AM-9:00PM"); // hours
        sampleFacilityInfo1.add("program=(CS/MAT),year=(1/2):department=(APM),year=(any)"); // criteria

        sampleFacility1 = new Facility(sampleFacilityInfo1);

        ArrayList<String> sampleFacilityInfo2 = new ArrayList<>();
        sampleFacilityInfo2.add("Robarts Library"); // name
        sampleFacilityInfo2.add("130 St George Street"); // address
        sampleFacilityInfo2.add("The John P. Robarts Research Library!"); // description
        sampleFacilityInfo2.add("Weekdays: 8:30AM-9:00PM"); // hours
        sampleFacilityInfo2.add("program=(PHY),year=(3):department=(MAT/PHY),year=(1/2/3)"); // criteria

        sampleFacility2 = new Facility(sampleFacilityInfo2);

        // create facility map
        ArrayList<ArrayList<String>> facilitiesInfo = new ArrayList<>();
        facilitiesInfo.add(sampleFacilityInfo1);
        facilitiesInfo.add(sampleFacilityInfo2);

        sampleFacilityMap = new FacilityMap(facilitiesInfo);
    }

    @Test
    public void testGetFacility() {
        Assert.assertEquals(sampleFacility1.displayFacilityInfo(), sampleFacilityMap.getFacility("Bahen Centre").displayFacilityInfo());
        Assert.assertEquals(sampleFacility2.displayFacilityInfo(), sampleFacilityMap.getFacility("Robarts Library").displayFacilityInfo());
    }

    @After
    public void tearDown() {
        sampleFacility1 = null;
        sampleFacility2 = null;
        sampleFacilityMap = null;
    }
}