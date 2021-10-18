package login;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class StudentTest {

    /**
     * This is the one we made in Phase 0.
     */
    @Test
    public void getProfile() {
        ArrayList<String> new_student = new ArrayList<>();
        new_student.add("Sherlock");
        new_student.add("Holmes");
        new_student.add("private_investigator");
        new_student.add("wheresthecrime");
        new_student.add("student");
        new_student.add("1003757936");
        new_student.add("sherlock.holmes@mail.utoronto.ca");
        new_student.add("3");
        new_student.add("Criminology");
        Student s_1 = new Student(new_student);
        ArrayList<String> compare = new ArrayList<>();

        compare.add("Sherlock");
        compare.add("Holmes");
        compare.add("private_investigator");
        compare.add("wheresthecrime");
        compare.add("student");
        compare.add("1003757936");
        compare.add("sherlock.holmes@mail.utoronto.ca");
        compare.add("3");
        compare.add("Criminology");

        assertEquals(s_1.getProfile(), compare);
    }

    @Test
    public void ProfileDisplay() {

        ArrayList<String> new_student = new ArrayList<>();
        new_student.add("Sherlock");
        new_student.add("Holmes");
        new_student.add("private_investigator");
        new_student.add("wheresthecrime");
        new_student.add("student");
        new_student.add("1003757936");
        new_student.add("sherlock.holmes@mail.utoronto.ca");
        new_student.add("3");
        new_student.add("Criminology");
        Student s_1 = new Student(new_student);

        assertEquals(s_1.profileDisplay(), "First Name: Sherlock" + "\n" +
                "Last Name: Holmes\n" +
                "UserId:private_investigator\n" +
                "Status: student\n" +
                "Student ID: 1003757936\n" +
                "Email: sherlock.holmes@mail.utoronto.ca\n" +
                "Year of Study: 3\n" +
                "Program: Criminology\n" +
                "Criteria: [Criminology]");

    }

    @Test
    public void getId() {

        ArrayList<String> new_student = new ArrayList<>();
        new_student.add("Sherlock");
        new_student.add("Holmes");
        new_student.add("private_investigator");
        new_student.add("wheresthecrime");
        new_student.add("student");
        new_student.add("1003757936");
        new_student.add("sherlock.holmes@mail.utoronto.ca");
        new_student.add("3");
        new_student.add("Criminology");
        Student s_1 = new Student(new_student);

        String user_id = s_1.getId();
        assertEquals(user_id, "private_investigator");
    }
}