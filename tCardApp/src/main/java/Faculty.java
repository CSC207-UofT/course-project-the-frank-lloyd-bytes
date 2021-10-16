package java;

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
        return "User ID: " + this.profile.get(1) + "\n" + "Status: " + this.profile.get(2) + "\n"
                + "Department: " + this.accesses.get(0) + "\n" + "Qualification: " + this.accesses;
    }

    @Override
    public ArrayList<String> getProfile(){
        return this.profile;
    }

    @Override
    public String getId() {
        return this.profile.get(1);
    }
}
