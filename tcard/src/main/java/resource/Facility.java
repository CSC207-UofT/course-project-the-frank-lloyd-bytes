package resource;

import java.util.ArrayList;

public class Facility {
    private String name;
    private String address;
    private String description;
    private String hours;
    private String criteria;

    public Facility(ArrayList<String> facilityInfo) {
        // assuming facilityInfo has the following ordering of elements:
        // {name, address, description, hours, criteria}
        this.name = facilityInfo.get(0);
        this.address = facilityInfo.get(1);
        this.description = facilityInfo.get(2);
        this.hours = facilityInfo.get(3);
        this.criteria = facilityInfo.get(4);
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDescription() { return this.description; }

    public String getHours() {
        return this.hours;
    }

    public String getCriteria() { return this.criteria; }

    // TODO: implement this, should look similar to the displayProfile method in the Student and Faculty classes
    public String displayFacilityInfo() {
        return "";
    }
}
