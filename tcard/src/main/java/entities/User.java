package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is an abstract class that is a base for all user classes. Stores basic user information.
 *
 */
public abstract class User implements Serializable {
    protected HashMap<String, String> profiles = new HashMap<>();
    protected String password;
    protected String picture;
    private final String UTORID = "utorid";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String STATUS = "status";
    private final String ID_NUMBER = "idNumber";
    private final String EMAIL = "eMail";

    /**
     * This is a constructor for the User class. This method writes basic user information from a list of strings to a
     * User object.
     *
     * @param userInfo a list of strings containing information for a user. This parameter is assumed
     *                 to have the following ordering:
     *                 {UTORid, password, first name, last name, status, ID number, email, year, belongs to, (picture)}
     */
    public User(List<String> userInfo) {
        this.profiles.put(UTORID, userInfo.get(0));// UTORid
        this.password = userInfo.get(1); // password
        this.profiles.put(FIRST_NAME, userInfo.get(2)); // first name
        this.profiles.put(LAST_NAME, userInfo.get(3)); // last name
        this.profiles.put(STATUS, userInfo.get(4)); // status
        this.profiles.put(ID_NUMBER, userInfo.get(5)); // ID number
        this.profiles.put(EMAIL, userInfo.get(6)); // email
        if (userInfo.size() < 10) {
            this.picture = "";
        } else {
            this.picture = userInfo.get(9);
        }
    }

    /**
     * This method is for checking if an entered password is correct, i.e. if it matches the users password.
     *
     * @param passwordAttempt a string containing a possible password to be compared against this users actual password.
     * @return a boolean indicating if the passwordAttempt was correct.
     */
    public boolean checkPassword(String passwordAttempt) {
        return passwordAttempt.equals(this.password);
    }


    /**
     * Change the picture of this user using newPictue
     *
     * @param newPicture is the picture we want to use.
     */
    public void changePicture(String newPicture) {
        this.picture = newPicture;
    }


    /**
     * This method is for changing this user's password.
     *
     * @param newPassword a string containing the desired new password.
     */
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }


    /**
     * A getter method to get all the users profile information (including utorid and password) as an arraylist.
     *
     * @return all the users profile information (including utorid and password) in the following order:{UTORid,
     * password, first name, last name, status, ID number, email, year, belongs to, (picture)}
     */
    public List<String> getUserInfo() {
        ArrayList<String> profiles = new ArrayList<>();
        profiles.add(this.profiles.get(UTORID));
        profiles.add(this.password);
        profiles.add(this.profiles.get(FIRST_NAME));
        profiles.add(this.profiles.get(LAST_NAME));
        profiles.add(this.profiles.get(STATUS));
        profiles.add(this.profiles.get(ID_NUMBER));
        profiles.add(this.profiles.get(EMAIL));
        profiles.add(this.picture);
        return profiles;
    }

    /**
     * @return the user's utorid
     */
    public String getId() {
        return this.profiles.get(UTORID);
    }

    /**
     * @return the user's first name
     */
    public String getFN() {
        return this.profiles.get(FIRST_NAME);
    }

    /**
     * @return the user's last name
     */
    public String getLN() {
        return this.profiles.get(LAST_NAME);
    }

    /**
     * @return the user's status
     */
    public String getSTATUS() {
        return this.profiles.get(STATUS);
    }

    /**
     * @return the user's id number
     */
    public String getID_NUMBER() {
        return this.profiles.get(ID_NUMBER);
    }

    /**
     * @return the user's email
     */
    public String getEMAIL() {
        return this.profiles.get(EMAIL);
    }
}