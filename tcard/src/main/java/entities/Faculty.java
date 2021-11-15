package entities;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Faculty is a child class of User, it initializes an instance of a faculty user class. Stores student
 * user information.
 *
 */
public class Faculty extends User implements Serializable {
    //extra indexes for faculty's profile
    public final int FACULTY_YEAR = 5;
    public final int FACULTY_DEPARTMENT = 6;

    /**
     * This is a constructor for the Faculty class. This method writes student information from a list of strings
     * to a Faculty object.
     * @param userInfo a list of strings containing information for a faculty member. This parameter is assumed
     *                 to have the following ordering:
     *                 {UTORid, password, first name, last name, status, ID number, email, year, department}
     */
    public Faculty(ArrayList<String> userInfo) {
        super(userInfo);
        this.getProfile().add(userInfo.get(7)); // year
        this.getProfile().add(userInfo.get(8)); // department
    }

    /**
     * This method is for displaying a faculty members profile information.
     * @return a string that displays the faculty members profile.
     */
    @Override
    public String displayProfile() {
        return "First Name: " + this.getProfile().get(FIRST_NAME)+ "\n" +  "Last Name: " +
                this.getProfile().get(LAST_NAME) + "\n"+ "UTORid: " + this.getId() +
                "\n" + "Status: " + this.getProfile().get(STATUS) + "\n" + "Personnel Number: " +
                this.getProfile().get(ID_NUMBER) + "\n" + "Email: " + this.getProfile().get(EMAIL) + "\n" +
                "Department: " + this.getProfile().get(FACULTY_DEPARTMENT) + "\n" + "Years at U of T: " +
                this.getProfile().get(FACULTY_YEAR);
    }

}
