package entities;

import java.util.ArrayList;

/**
 * This is an abstract class that is a base for all user classes
 *
 */


public abstract class User {

    protected ArrayList<String> profile = new ArrayList<>();
    final int LEGAL_FIRST_NAME = 0;
    final int LEGAL_LAST_NAME = 1;
    final int UTOR_ID = 2;
    final int PASSWORD = 3;
    final int STATUS = 4;
    final int ID_NUMBER = 5;
    final int EMAIL = 6;
    final int BELONGS_TO = 7;

    public User(ArrayList<String> info) {
        this.profile.add(info.get(LEGAL_FIRST_NAME));
        this.profile.add(info.get(LEGAL_LAST_NAME));
        this.profile.add(info.get(UTOR_ID));
        this.profile.add(info.get(STATUS));
        this.profile.add(info.get(ID_NUMBER));
        this.profile.add(info.get(EMAIL));
        this.profile.add(info.get(BELONGS_TO));
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

    public void changePassword(String password){
        this.profile.add(3, password);
    }



}
