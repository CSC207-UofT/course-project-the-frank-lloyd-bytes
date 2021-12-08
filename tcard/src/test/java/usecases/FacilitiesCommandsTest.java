package usecases;

import entities.Facility;
import junit.framework.TestCase;

import java.util.ArrayList;

public class FacilitiesCommandsTest extends TestCase {
    ArrayList<String> sampleFacilityInfo = new ArrayList<>();
    ArrayList<ArrayList<String>> sampleFcilityList = new ArrayList<>();
    FacilitiesCommands facilitiesCommands;
    Facility facility;

    public void setUp() throws Exception {
        super.setUp();
        sampleFacilityInfo.add("Bahen Centre"); // name
        sampleFacilityInfo.add("40 St George Street"); // address
        sampleFacilityInfo.add("The Bahen Centre for Information Technology!"); // description
        sampleFacilityInfo.add("Monday: 8:30AM-9:00PM"); // hours
        sampleFacilityInfo.add("program=(CS/MAT),year=(1/2):department=(APM),year=(any)"); // criteria
        sampleFcilityList.add(sampleFacilityInfo);
        facilitiesCommands = new FacilitiesCommands(sampleFcilityList);
        facility = new Facility(sampleFacilityInfo);
    }

    public void testGetFacility() {
        assertEquals(facility.getFacilityInfo(), facilitiesCommands.getFacility("Bahen Centre").getFacilityInfo());
    }

    public void testGetInfo() {
        ArrayList<ArrayList<String>> facilityArrayList = new ArrayList<>();
        facilityArrayList.add(facility.getFacilityInfo());
        assertEquals(facilityArrayList, facilitiesCommands.getInfo());
    }
}