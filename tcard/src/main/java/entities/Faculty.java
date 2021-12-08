package entities;
import java.io.Serializable;
import java.util.List;

/**
 * Class Faculty is a child class of User, it initializes an instance of a faculty user class. Stores student
 * user information.
 *
 */
public class Faculty extends User implements Serializable {
    public final String FACULTY_YEAR = "year";
    public final String FACULTY_DEPARTMENT = "department";


    /**
     * This is a constructor for the Faculty class. This method writes student information from a list of strings
     * to a Faculty object.
     * @param userInfo a list of strings containing information for a faculty member. This parameter is assumed
     *                 to have the following ordering:
     *                 {UTORid, password, first name, last name, status, ID number, email, year in UofT,Department,
     *                 picture}
     */
    public Faculty(List<String> userInfo) {
        super(userInfo);
        this.profiles.put(FACULTY_YEAR, userInfo.get(7)); //year
        this.profiles.put(FACULTY_DEPARTMENT, userInfo.get(8)); //department
    }

    @Override
    public List<String> getUserInfo(){
        List<String> info = super.getUserInfo();
        String pic = info.get(7);
        info.set(7, this.getFACULTY_YEAR());
        info.add(this.getFACULTY_DEPARTMENT());
        info.add(pic);
        return info;
    }

    /**
     * get the year of the faculty
     * @return a string of the faculty year
     */
    public String getFACULTY_YEAR(){
        return this.profiles.get(FACULTY_YEAR);
    }

    /**
     * get the department of the faculty
     * @return a string of the faculty department
     */
    public String getFACULTY_DEPARTMENT(){
        return this.profiles.get(FACULTY_DEPARTMENT);
    }
}
