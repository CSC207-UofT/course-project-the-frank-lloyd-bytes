package usecases;


import entities.User;


public class UserManager{

    public void updatePassword(User user, String password){
        user.changePassword(password);
    }
}