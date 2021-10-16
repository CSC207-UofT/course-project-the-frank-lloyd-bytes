package login;

import java.util.ArrayList;

/**
 * Implements Faculty class which is a child of User class
 *
 */
public class Faculty extends User{
    public Faculty(ArrayList<String> info) {
        super(info);
    }
    /**
     *   The first item in accesses should be the department of the faculty.
     */
    @Override
    public String profileDisplay() {
        return "First Name: " + this.profile.get(LEAGLNameF)+ "\n" +  "Last Name: " + this.profile.get(LEAGLNameL) +
                "\n"+ "UserId:" + this.profile.get(UTOR_ID) + "\n" + "Status: " + this.profile.get(STATUS) + "\n" +
                "Faculty ID: " + this.profile.get(IDNumber) + "\n" + "Email: " + this.profile.get(Email) + "\n" +
                "Years In UOFT: " + this.profile.get(YearsInUOFT) + "\n"+ "Department: " + this.profile.get(BelongTo) +
                "\n" + "Criteria: " + this.accesses;
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
