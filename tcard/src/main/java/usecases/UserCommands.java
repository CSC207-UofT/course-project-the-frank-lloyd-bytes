package usecases;

import entities.Student;
import entities.User;
import entities.Faculty;

import java.io.Serializable;
import java.util.ArrayList;

public class UserCommands implements Serializable {
    private final User USER;

    /**
     * Create an UserCommands that contains a specific user.
     * @param userList is the list of information used to create the UserCommands.
     */
    public UserCommands(ArrayList<String> userList) {
        this.USER = this.createUser(userList);
    }

    @Override
    public String toString(){
        return this.USER.displayProfile();
    }

    public User createUser(ArrayList<String> userInfo) {
        if (userInfo.get(4).equals("student")) {
            return new Student(userInfo);
        }
        return new Faculty(userInfo);
    }

    public ArrayList<String> getinfo(){
        return this.USER.getUserInfo();
    }

    public void changePassword(String oldpassword, String newpassword){
        if (this.USER.checkPassword(oldpassword)){
            this.USER.changePassword(newpassword);
        }
    }
    public User getUser(){
        return this.USER;
    }


}
