package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract class that is a base for all user classes. Stores basic user information.
 *
 */
public abstract class User implements Serializable {
    protected ArrayList<String> profile = new ArrayList<>();
    private String password;
    private String picture;
    private String utorID;
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
     *                 {UTORid, password, first name, last name, status, ID number, email, year, belongs to}
     */
    public User(List<String> userInfo) {
        this.utorID = userInfo.get(0); // UTORid
        this.password = userInfo.get(1); // password
        this.profile.add(userInfo.get(2)); // first name
        this.profile.add(userInfo.get(3)); // last name
        this.profile.add(userInfo.get(4)); // status
        this.profile.add(userInfo.get(5)); // ID number
        this.profile.add(userInfo.get(6)); // email
        this.picture = userInfo.get(9); //picture Uri in String form
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
     * This method is for changing this user's password.
     *
     * @param newPicture a string containing the Uri of the new profile picture.
     */
    public void changePicture(String newPicture) {
        this.picture = newPicture;
    }


    /**
     * This method is for displaying a users basic profile information.
     * @return a string that displays the profile in a preferred format.
     */
    public abstract String displayProfile();

    /**
     * A getter method to get all the users profile information (including utorid and password) as an arraylist.
     * @return all the users profile information (including utorid and password)
     */
    public List<String> getUserInfo() {
        ArrayList<String> profilelist = new ArrayList<>();
        profilelist.add(this.utorID);
        profilelist.add(this.password);
        profilelist.addAll(this.profile);
        profilelist.add(this.picture);
        return profilelist;
    }

    /**
     * A getter method to get user's profile as an arraylist.
     * @return the user's profile
     */
    public List<String> getProfile() { return this.profile; }

    /**
     * A getter method to get user's utroid
     * @return the user's utroid
     */
    public String getId(){
        return this.utorID;
    }


}
