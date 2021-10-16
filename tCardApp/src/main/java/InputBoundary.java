package java;

public interface InputBoundary {
        UserCommands.LoginResult logIn(String username, String password);
        String getProfile(String userId);
}
