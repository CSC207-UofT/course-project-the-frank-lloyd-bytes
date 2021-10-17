package login;

public class Controller {

    /**
     * The input boundary for the login use case.
     */
    private final  InputBoundary inputBoundary;

    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     *
     * @param inputBoundary the input boundary for the login use case
     */
    public Controller(InputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Run the login use case where username is attempting to log into their
     * account with a password attempt.
     *
     * @param userId the username
     * @param password the password attempt
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
