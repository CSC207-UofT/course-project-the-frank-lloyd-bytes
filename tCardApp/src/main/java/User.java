package java;

import java.util.ArrayList;

/**
 * This is an abstract class that is a base for all user classes
 *
 */


public abstract class User {

    protected ArrayList<String> profile = new ArrayList<>();
    protected ArrayList<String> accesses = new ArrayList<>();
    final int LEAGLName = 0;
    final int UTOR_ID = 1;
    final int PASSWORD = 2;
    final int STATUS = 3;
    final int IDNumber = 4;
    final int Email = 5;
    final int BelongTo = 6;

    public User(ArrayList<String> info) {
        this.profile.set(LEAGLName, info.get(LEAGLName));
        this.profile.set(UTOR_ID, info.get(UTOR_ID));
        this.profile.set(PASSWORD,info.get(PASSWORD));
        this.profile.set(STATUS, info.get(STATUS));
        this.profile.set(IDNumber, info.get(IDNumber));
        this.profile.set(Email, info.get(Email));
        this.profile.set(BelongTo, info.get(BelongTo));
        this.accesses.set(0,info.get(BelongTo));
    }

    /**
     * Get the id of this user.
     * @return a the user's id.
     */
    public  abstract String getId();


    /**
     * This method is for showing profile.
     * @return a string that display the profile in a preferred format.
     */
    public abstract String profileDisplay();


    /**
     * This method is for getting profile information. (we may use this to change our data file)
     * @return a list of string that display profile information in a line
     */
    public abstract ArrayList<String> getProfile();



}
