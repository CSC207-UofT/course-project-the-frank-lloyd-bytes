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

    //return a string rep of usercommand

    /**
     * Get the string representation of UserCommand
     * @return a string representation of UserCommand
     */
    @Override
    public String toString(){
        return this.user.displayProfile();
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
