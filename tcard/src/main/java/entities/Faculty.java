package entities;
import java.util.ArrayList;

/**
 * Implements Faculty class which is a child of User class
 *
 */
public class Faculty extends User{
    final int FACULTY_DEPARTMENT = 8;
    final int FACULTY_POSITION = 9;

    public Faculty(ArrayList<String> info) {
        super((ArrayList<String>)info.subList(0, 8));
        this.profile.add(info.get(FACULTY_DEPARTMENT));
        this.profile.add(info.get(FACULTY_POSITION));
    }
    /**
     *   The first item in accesses should be the department of the faculty.
     */
    @Override
    public String profileDisplay() {
        return "First Name: " + this.profile.get(LEGAL_FIRST_NAME)+ "\n" +  "Last Name: " + this.profile.get(LEGAL_LAST_NAME) +
                "\n"+ "UserId:" + this.profile.get(UTOR_ID) + "\n" + "Status: " + this.profile.get(STATUS) + "\n" +
                "Faculty ID: " + this.profile.get(ID_NUMBER) + "\n" + "Email: " + this.profile.get(EMAIL) + "\n" +
                "Faculty Department: " + this.profile.get(FACULTY_DEPARTMENT) + "\n" + "Faculty Position: " +
                this.profile.get(FACULTY_POSITION) + "\n" + "Criteria: " + this.profile.get(BELONGS_TO);
    }

    @Override
    public ArrayList<String> getProfile(){
        return this.profile;
    }

    @Override
    public String getId() {
        return this.profile.get(2);
    }
}
