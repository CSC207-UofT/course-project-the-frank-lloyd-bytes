package controllers;

import usecases.UserCommands;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable {
    private UserCommands myUserCommands;
    public UserManager(ArrayList<String> userinfo){
        this.myUserCommands = new UserCommands(userinfo);
    }

    public ArrayList<String> getinfo(){
        return this.myUserCommands.getinfo();
    }
}
