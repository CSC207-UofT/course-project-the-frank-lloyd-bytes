package java.resource;

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
        user1.add("Jerry"); // First name
        user1.add("Huang"); // Last name
        user1.add("jerry9981"); // UTORid
        user1.add("password!"); // password
        user1.add("student"); // status
        user1.add("1020062006"); // student number
        user1.add("jerry.huang@mail.utoronto.ca"); // email
        user1.add("CS"); // program
        user1.add("undergrad"); // level
        user1.add("2"); // year
        Student sample1 = new Student(user1);

        ArrayList<String> user2 = new ArrayList<>();
        user2.add("Willy"); // First name
        user2.add("Wonka"); // Last name
        user2.add("Char2005"); // UTORid
        user2.add("Chocolate!"); // password
        user2.add("faculty"); // status
        user2.add("1020052005"); // personnel number
        user2.add("willy.wonka@mail.utoronto.ca"); // email
        user2.add("MAT"); // department
        user2.add("professor"); // position
        Faculty sample2 = new Faculty (user2);
        this.userList.put(sample1.getIDNumber(), sample1);
        this.userList.put(sample2.getIDNumber(), sample2);

        ArrayList<String> user3 = new ArrayList<>();
        user3.add("Sherlock"); // First name
        user3.add("Holmes"); // Last name
        user3.add("private_investigator"); // UTORid
        user3.add("wheresthecrime"); // password
        user3.add("student"); // status
        user3.add("1003757936"); // student number
        user3.add("sherlock.holmes@mail.utoronto.ca"); // email
        user3.add("PHY"); // program
        user3.add("grad"); // level
        user3.add("1"); // year
        Student sample3 = new Student(user3);
        this.userList.put(sample3.getIDNumber(), sample3);
    }

    /**
     * (Menu) can use this class to generate a list of User class.
     * When calling this use case, (menu) class must pass down a list of string list as the argument.
     * @param profilesInfo is a list of String lists
     */
    public UserList(ArrayList<ArrayList<String>> profilesInfo){
        for (ArrayList<String> i : profilesInfo){
            if (Objects.equals(i.get(4), "student")){
                Student user = new Student(i);
                this.userList.put(user.getIDNumber(), user);
            }
            else if (Objects.equals(i.get(4), "faculty")){
                Faculty faculty = new Faculty(i);
                this.userList.put(faculty.getIDNumber(), faculty);
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