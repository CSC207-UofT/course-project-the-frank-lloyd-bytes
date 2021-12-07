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

    //to decrease size of method
    public String StudentFacultyDifferHelper(User user){
        if (user.getSTATUS().equals("Student")) {
            return "Student";

        } else { // if the user is not a student, then the user is a faculty member
            return "Faculty";
        }
    }

    public String[] getCriteria(Facility facility){
        String[] criteria = facility.getFacilityInfo().get(4).split(":");
        criteria = criteria[0].split(",");
        return criteria;
    }

    public ArrayList<String[]> getFacilityCriteriaStudent(String[] criteria){
        //in the order of programcondition, yearcondition
        ArrayList<String[]> facInfoStu = new ArrayList<>();
        facInfoStu.add(getConditionsArray(criteria[0]));
        facInfoStu.add(getConditionsArray(criteria[1]));
        return facInfoStu;
    }

    public ArrayList<String> getStudentInfo(Student student){
        //in the order of studentprogram, studentyear
        ArrayList<String> stuInfo = new ArrayList<>();
        stuInfo.add(student.getSTUDENT_PROGRAM());
        stuInfo.add(student.getSTUDENT_YEAR());
        return stuInfo;
    }

    public ArrayList<String[]> getFacilityCriteriaFaculty(String[] criteria){
        //in the order of departmentcondition, yearcondition
        ArrayList<String[]> facInfoFac = new ArrayList<>();
        facInfoFac.add(getConditionsArray(criteria[0]));
        facInfoFac.add(getConditionsArray(criteria[1]));
        return facInfoFac;
    }

    public ArrayList<String> getFacultyInfo(Faculty faculty){
        //in the order of facultydepartment, facultyyear
        ArrayList<String> facinfo = new ArrayList<>();
        facinfo.add(faculty.getFACULTY_DEPARTMENT());
        facinfo.add(faculty.getFACULTY_YEAR());
        return facinfo;
    }
}
