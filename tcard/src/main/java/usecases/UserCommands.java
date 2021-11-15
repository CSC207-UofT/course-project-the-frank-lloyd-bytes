package usecases;

import androidx.annotation.NonNull;
import entities.User;
import entities.Student;
import entities.Faculty;

import java.io.Serializable;
import java.util.ArrayList;

public class UserCommands implements Serializable {
    private final User user;

    public UserCommands(ArrayList<String> userInfo) {
        this.user = this.createUser(userInfo);
    }

    /**
     * Get the string representation of UserCommand
     * @return a string representation of UserCommand
     */
    @NonNull
    @Override
    public String toString(){
        return this.user.displayProfile();
    }

    private User createUser(ArrayList<String> userInfo) {
        if (userInfo.get(4).equals("student")) {
            return new Student(userInfo);
        } // else, userInfo.get(4) = "faculty"
        return new Faculty(userInfo);
    }

    /**
     * A getter method to get user's profile as an arraylist.
     * @return the UserCommands user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Change the current password of the user to newPassword if oldPassword matches the current password.
     * @param oldPassword  a string containing the potential current password of the user
     * @param newPassword  a string containing the desired new password
     */
    public void changePassword(String oldPassword, String newPassword){
        if (this.user.checkPassword(oldPassword)){
            this.user.changePassword(newPassword);
        }
    }
}
