package resource;

//import java.util.ArrayList;
import java.util.Arrays;

public class CheckFacilityAccess implements CheckCriteria<Facility> {

//    public static void main(String[] args) {
//        // EXAMPLE OF USAGE:
//        // Load info for a facility
//        ArrayList<String> facilityInfo = new ArrayList<>();
//        facilityInfo.add("Bahen Centre"); // name
//        facilityInfo.add("40 St George Street"); // address
//        facilityInfo.add("The Bahen Centre for Information Technology."); // description
//        facilityInfo.add("Monday: 8:30AM-9PM"); // password
//        facilityInfo.add("program=(CS/ENG),level=(any):department=(CS),position=(professor)"); // criteria
//        // In words, the criteria above is: allows entry to all students (undergrad and grad) in the CS or ENG program
//        // and professors from the CS department
//        Facility bahenCentre = new Facility(facilityInfo); // Create Facility object
//
//        // Load user info for a student
//        ArrayList<String> userInfo1 = new ArrayList<>();
//        userInfo1.add("Jonah"); // First name
//        userInfo1.add("Mackey"); // Last name
//        userInfo1.add("blahblahblah"); // UTORid
//        userInfo1.add("password"); // password
//        userInfo1.add("student"); // status
//        userInfo1.add("1234567890"); // student number
//        userInfo1.add("jonahsstudentmail@mail.utoronto.ca"); // email
//        userInfo1.add("APM"); // program
//        userInfo1.add("undergrad"); // level
//        userInfo1.add("4"); // year
//        Student jonahStudent = new Student(userInfo1); // Create Student object
//        // Based on the criteria for bahenCentre, this user does not have TCard access
//
//        // Load user info for a faculty member
//        ArrayList<String> userInfo2 = new ArrayList<>();
//        userInfo2.add("Jonah"); // First name
//        userInfo2.add("Mackey"); // Last name
//        userInfo2.add("blahblahblah"); // UTORid
//        userInfo2.add("password"); // password
//        userInfo2.add("faculty"); // status
//        userInfo2.add("1234567890"); // student number
//        userInfo2.add("jonahsfacultymail@mail.utoronto.ca"); // email
//        userInfo2.add("CS"); // department
//        userInfo2.add("professor"); // position
//        Faculty jonahFaculty = new Faculty(userInfo2); // Create Faculty object
//        // Based on the criteria for bahenCentre, this user has TCard access
//
//        // Usage of class
//        CheckFacilityAccess checkBahenCentreAccess = new CheckFacilityAccess();
//        System.out.println(checkBahenCentreAccess.evaluate(jonahStudent, bahenCentre)); // false
//        System.out.println(checkBahenCentreAccess.evaluate(jonahFaculty, bahenCentre)); // true
//    }

    public String[] getConditionsArray(String conditions) {
        // helper function that takes a string like "program=(CS/MAT)" and returns the array {"CS", "MAT"}
        return conditions.substring(conditions.indexOf("(")+1, conditions.
                indexOf(")")).split("/");
    }

    @Override
    public boolean evaluate(User user, Facility facility) {
        // Example:
        // facility.getCriteria() = "program=(CS/MAT),level=(undergrad):department=(CS),position=(postdoc/professor)";

        String[] criteria = facility.getCriteria().split(":");
        // criteria = {"program=(CS/MAT),level=(undergrad)", "department=(CS),position=(postdoc/professor)"}

        if (user.getStatus().equals("student")) {
            criteria = criteria[0].split(",");
            // criteria = {"program=(CS/MAT)", "level=(undergrad)"}

            String[] programConditions = getConditionsArray(criteria[0]);
            // programConditions = {"CS", "MAT"}
            String[] levelConditions = getConditionsArray(criteria[1]);
            // levelConditions = {"undergrad"}

            boolean programConditionsSatisfied = Arrays.asList(programConditions).contains(((Student) user).
                    getProgram());
            if (Arrays.asList(programConditions).contains("any")) {
                programConditionsSatisfied = true;
            }

            boolean levelConditionsSatisfied = Arrays.asList(levelConditions).contains(((Student) user).getLevel());
            if (Arrays.asList(levelConditions).contains("any")) {
                levelConditionsSatisfied = true;
            }

            // Check if the student satisfies ANY of the required programs in the criteria AND ANY of the required
            // levels in the criteria
            return (programConditionsSatisfied & levelConditionsSatisfied);

        } else { // if the user is not a student, then the user is a faculty member
            criteria = criteria[1].split(",");
            // criteria = {"department=(CS)", "position=(postdoc/professor)"}

            String[] departmentConditions = getConditionsArray(criteria[0]);
            // departmentConditions = {"CS"}
            String[] positionConditions = getConditionsArray(criteria[1]);
            // positionConditions = {"postdoc", "professor"}

            boolean departmentConditionsSatisfied = Arrays.asList(departmentConditions).contains(((Faculty) user).
                    getDepartment());
            if (Arrays.asList(departmentConditions).contains("any")) {
                departmentConditionsSatisfied = true;
            }

            boolean positionConditionsSatisfied = Arrays.asList(positionConditions).contains(((Faculty) user).
                    getPosition());
            if (Arrays.asList(positionConditions).contains("any")) {
                positionConditionsSatisfied = true;
            }

            // Check if the faculty satisfies ANY of the required programs in the criteria AND ANY of the required
            // levels in the criteria
            return (departmentConditionsSatisfied & positionConditionsSatisfied);
        }
    }
}
