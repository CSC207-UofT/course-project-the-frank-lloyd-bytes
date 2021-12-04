package usecases;

import java.util.List;

/*
  A user database interface to that allows us to read from and write to the user database.
 */
public interface UserReadWriter {

    /**
     * Check out the whether the user exists in the database
     * @param utorID is the id you want to check
     * @return true if the user exists and false if not
     */
    Boolean checkUtorID(String utorID);

    /**
     * check out whether the user enter the correct username and password
     * @param utorID is the user's utroid
     * @param password is the utroid's corresponding
     * @return true if the user's login successfully, false if not
     */
    Boolean checkUtorIDPassword(String utorID, String password);

    /**
     * Get a copy of the information of the user with utroid.
     * @param utorID the id of the user
     * @return an ArrayList of user's information
     */
    List<String> getInfo(String utorID);

    /**
     * Insert the data to the database
     * @param username is the user's id
     * @param password is the user's password
     * @param firstName is the user's first name
     * @param lastName is the user's last name
     * @param email is the user's email
     * @param department is the user's department
     * @param status is the user's status
     * @param tCardNumber is the user's Tcard number
     * @param year is the years that user in UofT
     * @param pic is the profile picture Uri in string form
     * @return true if the insert success, false if not
     */
    Boolean insertData(String username, String password, String firstName, String lastName, String email,
                       String department, String status, String tCardNumber, String year, String pic);

    /**
     * update the password for the user in the database
     * @param data is the user's info
     * @return true if the update work, false if not
     */
    Boolean updatePassword(List<String> data);
    Boolean updatePicture(List<String> data);
}
