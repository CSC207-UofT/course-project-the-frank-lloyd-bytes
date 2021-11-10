package usecases;

import entities.Faculty;
import entities.Student;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class create a list of User Class as a virtual database.
 */
public class UserList {
    protected HashMap<String, User> userList = new HashMap<>();




    public UserList(){
        ArrayList<String> user1 = new ArrayList<>();
        user1.add("Jerry");
        user1.add("Huang");
        user1.add("jerry9981");
        user1.add("password!");
        user1.add("student");
        user1.add("1020062006");
        user1.add("jerry.huang@mail.utoronto.ca");
        user1.add("3");
        user1.add("Math");
        Student sample1 = new Student(user1);

        ArrayList<String> user2 = new ArrayList<>();
        user2.add("Willy");
        user2.add("Wonka");
        user2.add("Char2005");
        user2.add("Chocolate!");
        user2.add("Faculty");
        user2.add("1020052005");
        user2.add("willy.wonka@mail.utoronto.ca");
        user2.add("4");
        user2.add("Department of Chocolate Industry");
        Faculty sample2 = new Faculty (user2);
        this.userList.put(sample1.getId(), sample1);
        this.userList.put(sample2.getId(), sample2);

        ArrayList<String> user3 = new ArrayList<>();
        user3.add("Sherlock");
        user3.add("Holmes");
        user3.add("private_investigator");
        user3.add("wheresthecrime");
        user3.add("student");
        user3.add("1003757936");
        user3.add("sherlock.holmes@mail.utoronto.ca");
        user3.add("3");
        user3.add("Criminology");
        Student sample3 = new Student(user3);
        this.userList.put(sample3.getId(), sample3);
    }

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
        return Objects.equals(selectedUser.getPassword(), password);
    }

    public User getUser(String iD){
        return userList.get(iD);
    }
}