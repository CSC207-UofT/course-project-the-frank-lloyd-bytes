package controllers;

import entities.User;
import usecases.UserCommands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Serializable {
    private final UserCommands MY_USER_COMMANDS;

    /**
     * create a new UserManager creates a new UserCommands
     * @param userinfo an arraylist of the user's information to make the UserCommands
     */
    public UserManager(ArrayList<String> userinfo){
        this.MY_USER_COMMANDS = new UserCommands(userinfo);
    }

    /**
     * get the info for the UserCommands for the user
     * @return an arraylist of the user's information
     */
    public List<String> getinfo(){
        return this.MY_USER_COMMANDS.getinfo();
    }

    /**
     * get the user for the UserCommands for this UserManager
     * @return an User object
     */
    public User getUser(){
        return MY_USER_COMMANDS.getUser();
    }

    public void changePassword(String oldpass, String newpass) {
        this.MY_USER_COMMANDS.changePassword(oldpass, newpass);
    }
}
