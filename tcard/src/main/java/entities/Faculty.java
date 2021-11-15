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
    public final int FACULTY_DEPARTMENT = 6;
    public final int FACULTY_YEAR = 7;

    /**
     * This is a constructor for the Faculty class. This method writes student information from a list of strings
     * to a Faculty object.
     * @param userInfo a list of strings containing information for a faculty member. This parameter is assumed
     *                 to have the following ordering:
     *                 {UTORid, password, first name, last name, status, ID number, email, Department, year in UofT}
     */
    public Faculty(ArrayList<String> userInfo) {
        super(userInfo);
        this.profile.add(userInfo.get(7));
        this.profile.add(userInfo.get(8));
    }

    /**
     * This method is for displaying a faculty members profile information.
     * @return a string that displays the faculty members profile.
     */
    @Override
    public String displayProfile() {
        String baseUserProfile = super.displayProfile();
        return baseUserProfile + "Department: " + this.getProfile().get(FACULTY_DEPARTMENT) + "\n" + "Years in UofT: " +
                this.getProfile().get(FACULTY_YEAR);
    }

}
