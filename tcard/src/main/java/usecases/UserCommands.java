package usecases;

import entities.User;

import java.io.Serializable;
import java.util.ArrayList;

public class UserCommands implements Serializable {
    private User user;

    public UserCommands(ArrayList<String> userList) {
        User user = this.createUser(userList);
        this.user = user;
    }

    public String showProfile(){
        return this.user.displayProfile();
    }

    public User createUser(ArrayList<String> userList){

    }

    public void changePassword(String oldpassword, String newpassword){
        if (this.user.checkPassword(oldpassword)){
            this.user.changePassword(newpassword);
        }
    }
}
