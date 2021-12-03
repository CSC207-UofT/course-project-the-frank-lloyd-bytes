package controllers;

import entities.User;
import usecases.UserCommands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Serializable {
    private UserCommands myUserCommands;

    /**
     * create a new UserManager creates a new UserCommands
     * @param userInfo an arraylist of the user's information to make the UserCommands
     */
    public UserManager(List<String> userInfo){
        this.myUserCommands = new UserCommands(userInfo);
    }

    /**
     * get the info for the UserCommands for the user
     * @return an arraylist of the user's information
     */
    public List<String> getInfo(){
        return this.myUserCommands.getInfo();
    }

    /**
     * get the user for the UserCommands for this UserManager
     * @return an User object
     */
    public User getUser(){
        return myUserCommands.getUser();
    }

    public void changePassword(String oldPass, String newPass) {
        this.myUserCommands.changePassword(oldPass, newPass);
    }
}
