package java;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class create a list of User Class as a virtual database.
 */
public class UserList {
    protected ArrayList<User> userList;

    /**
     * (Menu) can use this class to generate a list of User class.
     * When calling this use case, (menu) class must pass down a list of string list as the argument.
     * @param profilesInfo is a list of String lists
     */
    //TODO finish this method. I still considering which layer it should belong to.
    public UserList(ArrayList<ArrayList<String>> profilesInfo){
        for (ArrayList<String> i : profilesInfo){
        }

    }

    /**
     * Find whether there is a user in the UserList with provided userID
     * @param userID is the given userId.
     * @return a User class if the userID exists or false if not.
     */
    public Object find(String userID){
        for (User i : this.userList){
            if (Objects.equals(i.profile.get(0), userID)) {
                return i;
            }
        }
        return false;
    }
}
