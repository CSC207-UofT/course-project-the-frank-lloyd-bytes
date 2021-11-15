package usecases;

import entities.Student;
import entities.User;
import entities.Faculty;

import java.io.Serializable;
import java.util.ArrayList;

public class UserCommands implements Serializable {
    private final User USER;

    public UserCommands(ArrayList<String> userList) {
        this.USER = this.createUser(userList);
    }

    public String showProfile(){
        return this.USER.displayProfile();
    }

    public User createUser(ArrayList<String> userInfo) {
        if (userInfo.get(4).equals("student")) {
            Student studentUser = new Student(userInfo);
            return studentUser;
        }
        Faculty facultyUser = new Faculty(userInfo);
        return facultyUser;
    }

    public ArrayList<String> getinfo(){
        return this.USER.getProfile();
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
