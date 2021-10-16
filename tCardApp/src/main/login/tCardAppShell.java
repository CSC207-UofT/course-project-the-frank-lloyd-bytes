package login;

import java.util.ArrayList;

public class tCardAppShell {
    public static void main(String[] args){
        Menu Login = new Menu();
        UserList user = new UserList();
        UserCommands userCommands = new UserCommands(user);
        Controller loginControl = new Controller(userCommands);
        Login.runLogin(loginControl);

        }
}
