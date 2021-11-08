package resource;

public class Facility {
    private String name;
    private String address;
    private String description;
    private String hours;
    private String criteria;

    public Facility(String[] facilityInfo) {
        // assuming facilityInfo has the following ordering of elements:
        // {name, address, description, hours, criteria}
        this.name = facilityInfo[0];
        this.address = facilityInfo[1];
        this.description = facilityInfo[2];
        this.hours = facilityInfo[3];
        this.criteria = facilityInfo[4];
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
