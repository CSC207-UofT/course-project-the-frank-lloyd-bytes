package entities;

import java.io.Serializable;
import java.util.List;

/**
 * Class Student is a child class of User, it initializes an instance of a student user class. Stores student
 * user information.
 *
 */
public class Student extends User implements Serializable {
    //extra indexes for student's profile
    public final int STUDENT_YEAR = 5;
    public final int STUDENT_PROGRAM = 6;

    /**
     * This is a constructor for the Student class. This method writes student information from a list of strings
     * to a Student object.
     * @param userInfo a list of strings containing information for a student. This parameter is assumed
     *                      to have the following ordering:
     *                      {UTORid, password, first name, last name, status, ID number, email, year, program}
     */
    public Student(List<String> userInfo) {
        super(userInfo);
        this.getProfile().add(userInfo.get(7)); // year
        this.getProfile().add(userInfo.get(8)); // program
    }

    /**
     * This method is for displaying a students profile information.
     * @return a string that displays the student profile.
     */
    @Override
    public String displayProfile() {
        return "First Name: " + this.getProfile().get(FIRST_NAME)+ "\n" +  "Last Name: " +
                this.getProfile().get(LAST_NAME) + "\n"+ "UTORid: " + this.getId() +
                "\n" + "Status: " + this.getProfile().get(STATUS) + "\n" + "ID number: " +
                this.getProfile().get(ID_NUMBER) + "\n" + "Email: " + this.getProfile().get(EMAIL) + "\n" +
                "Program of Study: " + this.getProfile().get(STUDENT_PROGRAM) + "\n" + "Year of Study: " +
                this.getProfile().get(STUDENT_YEAR);
    }
}
