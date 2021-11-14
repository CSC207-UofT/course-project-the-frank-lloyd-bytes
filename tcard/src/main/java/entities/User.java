package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is an abstract class that is a base for all user classes. Stores basic user information.
 *
 */
public abstract class User implements Serializable {
    private ArrayList<String> profile = new ArrayList<>();
    private String password;
    private String utorid;
    //Indexes for profile
    public final int FIRST_NAME = 0;
    public final int LAST_NAME = 1;
    public final int STATUS = 2;
    public final int ID_NUMBER = 3;
    public final int EMAIL = 4;

    /**
     * This is a constructor for the User class. This method writes basic user information from a list of strings to a
     * User object.
     * @param userInfo a list of strings containing information for a user. This parameter is assumed
     *                 to have the following ordering:
     *                 {first name, last name, UTORid, password, status, ID number, email, program, level, year,
     *                 department, position}
     */
    public User(ArrayList<String> userInfo) {
        this.utorid = userInfo.get(0); // UTORid
        this.password = userInfo.get(1); // password
        this.profile.add(userInfo.get(2)); // first name
        this.profile.add(userInfo.get(3)); // last name
        this.profile.add(userInfo.get(4)); // status
        this.profile.add(userInfo.get(5)); // ID number
        this.profile.add(userInfo.get(6)); // email
    }

    /**
     * This method is for checking if an entered password is correct, i.e. if it matches the users password.
     * @param passwordAttempt a string containing a possible password to be compared against this users actual password.
     * @return a boolean indicating if the passwordAttempt was correct.
     */
    public boolean checkPassword(String passwordAttempt) {
        return passwordAttempt.equals(this.password);
    }

    /**
     * This method is for changing this user's password.
     * @param newPassword a string containing the desired new password.
     */
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }


    /**
     * This method is for displaying a users basic profile information.
     * @return a string that displays the profile in a preferred format.
     */
    public String displayProfile() {
        return "First Name: " + this.profile.get(FIRST_NAME)+ "\n" +  "Last Name: " +
                this.profile.get(LAST_NAME) + "\n"+ "UTORid: " + this.utorid +
                "\n" + "Status: " + this.profile.get(STATUS) + "\n" + "ID number: " +
                this.profile.get(ID_NUMBER) + "\n" + "Email: " + this.profile.get(EMAIL);
    }

    /**
     * A getter method to get user's profile as an arraylist.
     * @return the user's profile
     */
    public ArrayList<String> getProfile() {
        ArrayList<String> profilelist = new ArrayList<>();
        profilelist.add(this.utorid);
        profilelist.add(this.password);
        profilelist.addAll(this.profile);
        return profilelist;
    }

    /**
     * A getter method to get user's utroid
     * @return the user's utroid
     */
    public String getId(){
        return this.utorid;
    }


}
