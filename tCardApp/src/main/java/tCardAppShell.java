package java;




public class tCardAppShell {
    public static void main(String[] args){
        boolean isRunning = true;
        Menu Login = new Menu();
        UserCommands userCommands = new UserCommands();
        Controller loginControl = new Controller(userCommands);
        Login.runLogin(loginControl);


        }
}
