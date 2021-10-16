package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class create a list of User Class as a virtual database.
 */
public class UserList {
    protected HashMap<String, User> userList = new HashMap<>();

    /**
     * (Menu) can use this class to generate a list of User class.
     * When calling this use case, (menu) class must pass down a list of string list as the argument.
     * @param profilesInfo is a list of String lists
     */
    public UserList(ArrayList<ArrayList<String>> profilesInfo){
        for (ArrayList<String> i : profilesInfo){
            if (Objects.equals(i.get(3), "student")){
                Student user = new Student(i);
                this.userList.put(user.getId(), user);
            }
            else if (Objects.equals(i.get(3), "faculty")){
                Faculty faculty = new Faculty(i);
                this.userList.put(faculty.getId(), faculty);
            }
        }

    }

    public boolean checkPassword (String password, User selectedUser){
        return Objects.equals(selectedUser.profile.get(selectedUser.PASSWORD), password);
    }

    public User getUser(String iD){
        return userList.get(iD);
    }
}
