package controllers;

import entities.User;
import usecases.UserCommands;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class UserManager implements Serializable {
    private final UserCommands MY_USER_COMMANDS;
    final Map<UserCommands.PasswordUpdateResult, String> PASSWORD_UPDATE_MESSAGES = new EnumMap<>(UserCommands.PasswordUpdateResult.class);

    /**
     * create a new UserManager creates a new UserCommands
     * @param userInfo an arraylist of the user's information to make the UserCommands
     */
    public UserManager(List<String> userInfo){
        this.MY_USER_COMMANDS = new UserCommands(userInfo);
        PASSWORD_UPDATE_MESSAGES.put(UserCommands.PasswordUpdateResult.EMPTY_FIELD, "Please fill all the fields");
        PASSWORD_UPDATE_MESSAGES.put(UserCommands.PasswordUpdateResult.OLD_PASSWORD_WRONG, "Your old password is wrong");
        PASSWORD_UPDATE_MESSAGES.put(UserCommands.PasswordUpdateResult.NEW_SAME_AS_OLD, "Your new password is the same as the old one");
        PASSWORD_UPDATE_MESSAGES.put(UserCommands.PasswordUpdateResult.NEW_ATTEMPTS_DONT_MATCH, "Your new password attempts don't match");
        PASSWORD_UPDATE_MESSAGES.put(UserCommands.PasswordUpdateResult.SUCCESS, "Password successfully changed");

    }

    /**
     * get the info for the UserCommands for the user
     * @return an arraylist of the user's information
     */
    public List<String> getInfo(){
        return this.MY_USER_COMMANDS.getInfo();
    }

    /**
     * get the user for the UserCommands for this UserManager
     * @return a User object
     */
    public User getUser(){
        return MY_USER_COMMANDS.getUser();
    }

    /**
     * This method updates USER information (password) in UpdatePasswordActivity.
     * @param oldPass String old password of USER.
     * @param newPass String new password of USER.
     * @param newPassReEntry String of repeated new password of USER.
     * @return String of the new updated password result.
     */
    public String changePassword(String oldPass, String newPass, String newPassReEntry) {
        UserCommands.PasswordUpdateResult passwordUpdateResult = this.MY_USER_COMMANDS.changePassword(oldPass, newPass, newPassReEntry);
        return PASSWORD_UPDATE_MESSAGES.get(passwordUpdateResult);
    }

    /**
     * This method updates a new picture in ProfileActivity.
     * @param newPic String of new picture.
     */
    public void changePicture(String newPic) {
        this.MY_USER_COMMANDS.changePicture(newPic);
    }

    /** This method returns the String of USER ID (UTor ID).
     * @return String of USER ID.
     */
    public String getId() {
        return MY_USER_COMMANDS.getId();
    }

    /**
     * @return String USER full name a with space in middle.
     */
    public String getFullName() {
        return MY_USER_COMMANDS.getFullName();
    }
}
