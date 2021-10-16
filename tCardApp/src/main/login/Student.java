package login;

import java.util.ArrayList;

/**
 * Class student is a child class of User, it initializes an instance of
 * student user class, stores student data and profile, T card, unique ID
 *
 *
 *
 */

public class Student extends User{
    public Student(ArrayList<String> info) {
        super(info);
    }

    /**
     *   The first item in accesses should be the program of the student.
     */
    @Override
    public String profileDisplay() {
        return "First Name: " + this.profile.get(LEAGLNameF)+ "\n" +  "Last Name: " + this.profile.get(LEAGLNameL) +
                "\n"+ "UserId:" + this.profile.get(UTOR_ID) + "\n" + "Status: " + this.profile.get(STATUS) + "\n" +
                "Student ID: " + this.profile.get(IDNumber) + "\n" + "Email: " + this.profile.get(Email) + "\n" +
                "Year of Study: " + this.profile.get(YearsInUOFT) + "\n"+ "Program: " + this.profile.get(BelongTo) +
                "\n" + "Criteria: " + this.accesses;
    }
    @Override
    public ArrayList<String> getProfile(){
        return this.profile;
    }

    @Override
    public String getId(){
        return this.profile.get(2);
    }
}
