package entities;
import java.util.ArrayList;

/**
 * Class Faculty is a child class of User, it initializes an instance of a faculty user class. Stores student
 * user information.
 *
 */
public class Faculty extends User{
    public final int FACULTY_DEPARTMENT = 6;
    public final int FACULTY_POSITION = 7;

    /**
     * This is a constructor for the Faculty class. This method writes student information from a list of strings
     * to a Faculty object.
     * @param userInfo a list of strings containing information for a faculty member. This parameter is assumed
     *                 to have the following ordering:
     *                 {first name, last name, UTORid, password, status, ID number, email, program, level, year,
     *                 department, position}
     */
    public Faculty(ArrayList<String> userInfo) {
        super(userInfo);
        this.getProfile().add(userInfo.get(10));
        this.getProfile().add(userInfo.get(11));
    }

    /**
     * This method is for displaying a faculty members profile information.
     * @return a string that displays the faculty members profile.
     */
    @Override
    public String displayProfile() {
        String baseUserProfile = super.displayProfile();

        return baseUserProfile + "Department: " + this.getProfile().get(FACULTY_DEPARTMENT) + "\n" + "Position: " +
                this.getProfile().get(FACULTY_POSITION);
    }

}
