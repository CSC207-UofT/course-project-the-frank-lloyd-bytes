package entities;

import java.io.Serializable;
import java.util.List;

/**
 * Class Student is a child class of User, it initializes an instance of a student user class. Stores student
 * user information.
 *
 */
public class Student extends User implements Serializable {
    public final String STUDENT_YEAR = "year";
    public final String STUDENT_PROGRAM = "program";

    /**
     * This is a constructor for the Student class. This method writes student information from a list of strings
     * to a Student object.
     * @param userInfo a list of strings containing information for a student. This parameter is assumed
     *                      to have the following ordering:
     *                      {UTORid, password, first name, last name, status, ID number, email, year, program}
     */
    public Student(List<String> userInfo) {
        super(userInfo);
        this.profiles.put(STUDENT_YEAR, userInfo.get(7)); //year
        this.profiles.put(STUDENT_PROGRAM, userInfo.get(8)); //department
    }
    public List<String> getUserInfo(){
        List<String> info = super.getUserInfo();
        String pic = info.get(7);
        info.set(7, this.getSTUDENT_YEAR());
        info.add(this.getSTUDENT_PROGRAM());
        info.add(pic);
        return info;
    }
    public String getSTUDENT_YEAR(){
        return this.profiles.get(STUDENT_YEAR);
    }
    public String getSTUDENT_PROGRAM(){
        return this.profiles.get(STUDENT_PROGRAM);
    }
}
