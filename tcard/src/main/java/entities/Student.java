package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Student is a child class of User, it initializes an instance of a student user class. Stores student
 * user information.
 *
 */
public class Student extends User implements Serializable {
    //extra indexes for student's profile
    public final int STUDENT_PROGRAM = 5;
    public final int STUDENT_YEAR = 6;

    /**
     * This is a constructor for the Student class. This method writes student information from a list of strings
     * to a Student object.
     * @param userInfo a list of strings containing information for a student. This parameter is assumed
     *                      to have the following ordering:
     *                      {UTORid, password, first name, last name, status, ID number, email, program, year}
     */
    public Student(ArrayList<String> userInfo) {
        super(userInfo);
        this.profile.add(userInfo.get(7)); // year
        this.profile.add(userInfo.get(8)); // program
    }

    /**
     * This method is for displaying a students profile information.
     * @return a string that displays the student profile.
     */
    @Override
    public String displayProfile() {
        String baseUserProfile = super.displayProfile();
        return baseUserProfile + "Program of Study: " + this.getProfile().get(STUDENT_PROGRAM)
                + "\n" + "Year of Study: " + this.getProfile().get(STUDENT_YEAR);
    }
}
