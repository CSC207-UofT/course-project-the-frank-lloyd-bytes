package java;

import java.util.Objects;

/**
 * This is a user case layer class which allows the menu to access User datatype.
 * This class is a collection of commands which give the functionality  to the menu class
 * but also organizes user entities and allows overall user engagement via polymorphic methods.
 * Key services are checking access to groups, discounts, departments and future extendable permissions.
 *
 * For the first iteration we will simply have commands to check if user already exists, and check password and show
 * profile.
 */
public class UserCommands {
    public boolean checkPassword (String password, User selectedUser){
        return Objects.equals(selectedUser.profile.get(selectedUser.PASSWORD), password);
    }

    //TODO finish this method.

    /**
     * Check if the user exists in our database using the provided userId.
     * @param userId is the ID we want to check
     * @param userData stores our user's information
     * @return true if the user exists, false if not.
     */
    public boolean checkExistence(String userId, UserList userData){
    }

}
