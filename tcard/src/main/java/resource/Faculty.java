package resource;

import java.util.ArrayList;

/**
 * Implements Faculty class which is a child of User class
 *
 */
public class Faculty extends User{
    private String department;
    private String position;

    public Faculty(ArrayList<String> facultyInfo) {
        // assuming studentInfo has the following ordering of elements:
        // {legalNameF, legalNameL, utorID, password, status, idNumber, email, department, position}
        super((ArrayList<String>)facultyInfo.subList(0, 7));

        this.department = facultyInfo.get(7);
        this.position = facultyInfo.get(8);
    }

    public String getDepartment() {
        return this.department;
    }

    public String getPosition() {
        return this.position;
    }

    @Override
    public String displayProfile() {
        return "First Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() +
                "\nUTORid:" + this.getUtorID() + "\nStatus: " + this.getStatus() + "\nPersonnel number: " +
                this.getIDNumber() + "\nEmail: " + this.getEmail() + "\nDepartment: " + this.getDepartment() +
                "\nPosition: " + this.getPosition();
    }
}