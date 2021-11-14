package entities;

import java.util.ArrayList;

/**
 * Class Student is a child class of User, it initializes an instance of a student user class. Stores student
 * user information.
 *
 */
public class Student extends User {
    public final int STUDENT_PROGRAM = 6;
    public final int STUDENT_LEVEL = 7;
    public final int STUDENT_YEAR = 8;

    /**
     * This is a constructor for the Student class. This method writes student information from a list of strings
     * to a Student object.
     * @param userInfo a list of strings containing information for a student. This parameter is assumed
     *                      to have the following ordering:
     *                      {first name, last name, UTORid, password, status, ID number, email, program, level, year,
     *                      department, position}
     */
    public Student(ArrayList<String> userInfo) {
        super(userInfo);
        this.getProfile().add(userInfo.get(7)); // program
        this.getProfile().add(userInfo.get(8)); // level
        this.getProfile().add(userInfo.get(9)); // year
    }

    /**
     * This method is for displaying a students profile information.
     * @return a string that displays the student profile.
     */
    @Override
    public String displayProfile() {
        String baseUserProfile = super.displayProfile();

        return baseUserProfile + "Program of Study: " + this.getProfile().get(STUDENT_PROGRAM) + "\n" + "Student Level: " +
                this.getProfile().get(STUDENT_LEVEL) + "\n" + "Year of Study: " + this.getProfile().get(STUDENT_YEAR);
    }
}
