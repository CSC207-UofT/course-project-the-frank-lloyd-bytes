package java.resource;

public class Controller {

    /**
     * The input boundary for the Usercommands.
     */
    private final  InputBoundary inputBoundary;

    /**
     * Create a controller with inputBoundary.
     *
     * @param inputBoundary the input boundary for Usercommands
     */
    public Controller(InputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Run the Usercommands to log in the account with a userId and a password.
     *
     * @param userId to find a match account
     * @param password to try to log in to that account
     */
    public void runLogin(String userId, String password) {
        UserCommands.LoginResult result = inputBoundary.logIn(userId, password);
        switch (result) {
            case NOTEXIST:
                System.out.println("The user does not exist!");
                break;
            case SUCCESS:
                System.out.println("Success!");
                System.out.println(inputBoundary.getProfile(userId));
                break;
            case FAILURE:
                System.out.println("Incorrect Password! Failed to login!");
                break;

        }
    }
}