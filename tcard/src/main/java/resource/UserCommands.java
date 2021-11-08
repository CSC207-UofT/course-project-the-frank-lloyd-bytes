package resource;

public class UserCommands implements InputBoundary {
    private final UserList users;

    public UserCommands(UserList users) {
        this.users = users;
    }

    public enum LoginResult {
        SUCCESS,
        FAILURE,
        NOTEXIST
    }

    public String getProfile(String userId){
        User user = users.getUser(userId);
        return user.displayProfile();
    }

    /**
     * Login using the provided id and password
     * @param userId is the ID we want to check
     * @param password is the password entered
     * @return the result of this login.
     */
    public LoginResult logIn(String userId, String password){
        if (this.users.userList.containsKey(userId)){
            User user = users.getUser(userId);
            if (users.checkPassword(password, user)){
                return LoginResult.SUCCESS;
            }
            else {
                return LoginResult.FAILURE;
            }
        }
        else{
            return LoginResult.NOTEXIST;
        }
    }
}
