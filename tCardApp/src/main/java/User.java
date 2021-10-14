package java;

import java.util.ArrayList;

/**
 * This is an abstract class that is a base for all user classes
 *
 */


public abstract class User {

    protected ArrayList<String> profile = new ArrayList<>();
    protected ArrayList<String> accesses = new ArrayList<>();
    final int UTOR_ID = 0;
    final int PASSWORD = 1;
    final int STATUS = 2;
    final int Identity = 3;

    public User(String utorID, String password, String status, String identity) {
        this.profile.set(UTOR_ID, utorID);
        this.profile.set(PASSWORD, password);
        this.profile.set(STATUS, status);
        this.profile.set(Identity, identity);
        this.accesses.set(0, identity);
    }

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

//    TODO create an accessible invariant with profile data that can be accessed polymorphically
//    so that it can be saved and loaded regardless of child class.

}
