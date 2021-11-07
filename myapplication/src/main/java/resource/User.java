package resource;

import java.util.ArrayList;

/**
 * This is an abstract class that is a base for all user classes
 *
 */


public abstract class User {

    protected ArrayList<String> profile = new ArrayList<>();
    protected ArrayList<String> accesses = new ArrayList<>();
    final int LEAGLNameF = 0;
    final int LEAGLNameL = 1;
    final int UTOR_ID = 2;
    final int PASSWORD = 3;
    final int STATUS = 4;
    final int IDNumber = 5;
    final int Email = 6;
    final int YearsInUOFT = 7;
    final int BelongTo = 8;

    public User(ArrayList<String> info) {
        this.profile.add(info.get(LEAGLNameF));
        this.profile.add(info.get(LEAGLNameL));
        this.profile.add(info.get(UTOR_ID));
        this.profile.add(info.get(PASSWORD));
        this.profile.add(info.get(STATUS));
        this.profile.add(info.get(IDNumber));
        this.profile.add(info.get(Email));
        this.profile.add(info.get(YearsInUOFT));
        this.profile.add(info.get(BelongTo));
        this.accesses.add(info.get(BelongTo));
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