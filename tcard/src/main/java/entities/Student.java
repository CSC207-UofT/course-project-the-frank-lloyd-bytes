package entities;

import java.util.ArrayList;

/**
 * Class student is a child class of User, it initializes an instance of
 * student user class, stores student data and profile, T card, unique ID
 *
 *
 *
 */

public class Student extends User{
    public final int STUDENT_PROGRAM = 8;
    public final int STUDENT_LEVEL = 9;
    public final int STUDENT_YEAR = 10;

    public Student(ArrayList<String> info) {
        // assuming studentInfo has the following ordering of elements:
        // {legalNameF, legalNameL, utorID, password, status, idNumber, email, program, level, year}
        super((ArrayList<String>)info.subList(0, 8));
        this.profile.add(info.get(STUDENT_PROGRAM));
        this.profile.add(info.get(STUDENT_LEVEL));
        this.profile.add(info.get(STUDENT_YEAR));
    }

    /**
     *   The first item in accesses should be the program of the student.
     */
    @Override
    public String profileDisplay() {
        return "First Name: " + this.profile.get(LEGAL_FIRST_NAME)+ "\n" +  "Last Name: " +
                this.profile.get(LEGAL_LAST_NAME) + "\n"+ "UserId:" + this.profile.get(UTOR_ID) +
                "\n" + "Status: " + this.profile.get(STATUS) + "\n" + "Student ID: " +
                this.profile.get(ID_NUMBER) + "\n" + "Email: " + this.profile.get(EMAIL) + "\n" +
                "Program of Study: " + this.profile.get(STUDENT_PROGRAM) + "\n" + "Student Level: " +
                this.profile.get(STUDENT_LEVEL) + "\n" + "Year of Study: " + this.profile.get(STUDENT_YEAR) +
                "\n"+ "Criteria: " + this.profile.get(BELONGS_TO);
    }
    @Override
    public ArrayList<String> getProfile(){
        return this.profile;
    }

    @Override
    public String getId(){
        return this.profile.get(ID_NUMBER);
    }

    @Override
    public String getPassword() {
        return this.profile.get(PASSWORD);
    }
}
