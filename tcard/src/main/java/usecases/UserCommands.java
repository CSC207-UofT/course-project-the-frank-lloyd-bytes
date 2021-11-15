package usecases;

import entities.Student;
import entities.User;
import entities.Faculty;

import java.io.Serializable;
import java.util.ArrayList;

public class UserCommands implements Serializable {
    private final User USER;

    /**
     * instantiate usercommands from the userList given, create a new user in UserCommands with the given user info
     * @param userList is a list of information for a certain user
     */
    public UserCommands(ArrayList<String> userList) {
        this.USER = this.createUser(userList);
    }

    /**
     * shows the profile of the user in this UserCommands
     * @return a string of the user's information
     */
    public String showProfile(){
        return this.USER.displayProfile();
    }

    /**
     * create a new user given the information passed in. if user is student, create new student, else create new
     * faculty member
     * @param userInfo an array list of the information of the user
     * @return a User object
     */
    public User createUser(ArrayList<String> userInfo) {
        if (userInfo.get(4).equals("student")) {
            return new Student(userInfo);
        }
        return new Faculty(userInfo);
    }

    /**
     * get the information of the user in an arraylist format
     * @return an array list of the user in this UserCommands
     */
    public ArrayList<String> getinfo(){
        return this.USER.getProfile();
    }

    /**
     * changes the password for this user in this UserCommands
     * @param oldpassword the old password of the user
     * @param newpassword the new password of the user that they want to change to
     */
    public void changePassword(String oldpassword, String newpassword){
        if (this.USER.checkPassword(oldpassword)){
            this.USER.changePassword(newpassword);
        }
    }

    /**
     * get the user of this UserCommands
     * @return an User object
     */
    public User getUser(){
        return this.USER;
    }
}
