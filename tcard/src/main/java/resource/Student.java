package resource;

import java.util.ArrayList;

/**
 * Class student is a child class of User, it initializes an instance of
 * student user class, stores student data and profile, T card, unique ID
 *
 *
 *
 */
public class Student extends User{
    private String program;
    private String level;
    private String year;

    public Student(ArrayList<String> studentInfo) {
        // assuming studentInfo has the following ordering of elements:
        // {legalNameF, legalNameL, utorID, password, status, idNumber, email, program, level, year}
        super((ArrayList<String>)studentInfo.subList(0, 7));

        this.program = studentInfo.get(7);
        this.level = studentInfo.get(8);
        this.year = studentInfo.get(9);
    }

    public String getProgram() {
        return this.program;
    }

    public String getLevel() {
        return this.level;
    }

    public String getYear() {
        return this.year;
    }

    @Override
    public String displayProfile() {
        return "First Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() +
                "\nUTORid:" + this.getUtorID() + "\nStatus: " + this.getStatus() + "\nStudent number: " +
                this.getIDNumber() + "\nEmail: " + this.getEmail() + "\nProgram of Study: " + this.getProgram() +
                "\nLevel: " + this.getLevel() + "\nYear of Study: " + this.getYear();
    }
}