package resource;

import java.util.ArrayList;

/**
 * This is an abstract class that is a base for all user classes
 *
 */


public abstract class User {
    private String legalNameF;
    private String legalNameL;
    private String utorID;
    private String password;
    private String status;
    private String idNumber;
    private String email;

    public User(ArrayList<String> basicUserInfo) {
        // assuming basicUserInfo has the following ordering of elements:
        // {legalNameF, legalNameL, utorID, password, status, idNumber, email}
        this.legalNameF = basicUserInfo.get(0);
        this.legalNameL = basicUserInfo.get(1);
        this.utorID = basicUserInfo.get(2);
        this.password = basicUserInfo.get(3);
        this.status = basicUserInfo.get(4);
        this.idNumber = basicUserInfo.get(5);
        this.email = basicUserInfo.get(6);
    }

    public String getFirstName() {
        return this.legalNameF;
    }

    public String getLastName() {
        return this.legalNameL;
    }

    public String getUtorID() {
        return this.utorID;
    }

    public String getPassword() {
        return this.password;
    }

    public String getStatus() {
        return this.status;
    }

    public String getIDNumber() { return this.idNumber; }

    public String getEmail() { return this.email; }

    /**
     * This method is for showing profile.
     * @return a string that display the profile in a preferred format.
     */
    public abstract String displayProfile();

}