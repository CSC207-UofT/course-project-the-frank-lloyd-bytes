package usecases;

import entities.User;
import entities.Student;
import entities.Faculty;

import java.io.Serializable;
import java.util.ArrayList;

public class UserCommands implements Serializable {
    private User user;

    public UserCommands(ArrayList<String> userInfo) {
        User user = this.createUser(userInfo);
        this.user = user;
    }

    public String showProfile(){
        if (this.user.getProfile().get(user.STATUS).equals("student")) {
            return ((Student) this.user).displayProfile();
        }
        return ((Faculty) this.user).displayProfile();

    }

    public User createUser(ArrayList<String> userInfo) {
        if (userInfo.get(4).equals("student")) {
            Student studentUser = new Student(userInfo);
            return studentUser;
        }
        Faculty facultyUser = new Faculty(userInfo);
        return facultyUser;
    }

    public void changePassword(String oldPassword, String newPassword){
        if (this.user.checkPassword(oldPassword)){
            this.user.changePassword(newPassword);
        }
    }
}
