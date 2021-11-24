package controllers;

import entities.User;
import usecases.UserCommands;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable {
    private UserCommands myUserCommands;

    /**
     * create a new UserManager creates a new UserCommands
     * @param userinfo an arraylist of the user's information to make the UserCommands
     */
    public UserManager(ArrayList<String> userinfo){
        this.myUserCommands = new UserCommands(userinfo);
    }

    /**
     * get the info for the UserCommands for the user
     * @return an arraylist of the user's information
     */
    public ArrayList<String> getinfo(){
        return this.myUserCommands.getinfo();
    }

    /**
     * get the user for the UserCommands for this UserManager
     * @return an User object
     */
    public User getUser(){
        return myUserCommands.getUser();
    }
//discuss
    public void changePassword(String oldpass, String newpass) {
        this.myUserCommands.changePassword(oldpass, newpass);
    }
}
