package usecases;

import entities.Facility;
import entities.Faculty;
import entities.Student;
import entities.User;
import java.util.ArrayList;

public class FacilityHelper{
    /**
     * This is a helper method used to convert a string of conditions for a criteria field to a list of strings
     * containing the same conditions.
     * @param conditions a string of conditions for a criteria field (e.g. "program=(CS/MAT)").
     * @return a list of strings containing conditions for criteria (e.g. {"CS", "MAT"}).
     */
    private String[] getConditionsArray(String conditions) {
        // helper function that takes a string like "program=(CS/MAT)" and returns the array {"CS", "MAT"}
        return conditions.substring(conditions.indexOf("(")+1, conditions.
                indexOf(")")).split("/");
    }

    /**
     *to decrease the size of method, i created a helper method to check if the user is a student or a faculty
     */
    public String StudentFacultyDifferHelper(User user){
        if (user.getSTATUS().equals("Student")) {
            return "Student";

        } else { // if the user is not a student, then the user is a faculty member
            return "Faculty";
        }
    }

    /**
     * get the criteria of the facility
     * @param facility the facility where we want to get the criteria from
     * @return a list of strings that has the criteria of the facility.
     */
    public String[] getCriteria(Facility facility){
        String[] criteria = facility.getFacilityInfo().get(4).split(":");
        criteria = criteria[0].split(",");
        return criteria;
    }

    /**
     * get the facility criteria for students
     * @param criteria the criteria for the students needed by the student
     * @return an array list of each criteria in the order of program, and then year condition
     */
    public ArrayList<String[]> getFacilityCriteriaStudent(String[] criteria){
        //in the order of programcondition, yearcondition
        ArrayList<String[]> facInfoStu = new ArrayList<>();
        facInfoStu.add(getConditionsArray(criteria[0]));
        facInfoStu.add(getConditionsArray(criteria[1]));
        return facInfoStu;
    }

    /**
     * get the info for the student, this includes the student's program and year
     * @param student the student object that we are trying to get the information from
     * @return an array list of the students info in the order of program and year
     */
    public ArrayList<String> getStudentInfo(Student student){
        //in the order of studentprogram, studentyear
        ArrayList<String> stuInfo = new ArrayList<>();
        stuInfo.add(student.getSTUDENT_PROGRAM());
        stuInfo.add(student.getSTUDENT_YEAR());
        return stuInfo;
    }

    /**
     * get the facility criteria for faculty
     * @param criteria the criteria for the facility needed by the faculty
     * @return an array list of each criteria in the order of department and year condition needed to enter
     */
    public ArrayList<String[]> getFacilityCriteriaFaculty(String[] criteria){
        //in the order of departmentcondition, yearcondition
        ArrayList<String[]> facInfoFac = new ArrayList<>();
        facInfoFac.add(getConditionsArray(criteria[0]));
        facInfoFac.add(getConditionsArray(criteria[1]));
        return facInfoFac;
    }

    /**
     * get the info for the faculty, this includes their department and year
     * @param faculty the faculty object that we are trying to get the information from
     * @return an array list of the faculty's info in the order of their department and year
     */
    public ArrayList<String> getFacultyInfo(Faculty faculty){
        //in the order of facultydepartment, facultyyear
        ArrayList<String> facinfo = new ArrayList<>();
        facinfo.add(faculty.getFACULTY_DEPARTMENT());
        facinfo.add(faculty.getFACULTY_YEAR());
        return facinfo;
    }
}
