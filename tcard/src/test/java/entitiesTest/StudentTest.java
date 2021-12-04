package entitiesTest;

import entities.Student;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {
    private Student sampleStudent;

    @Before
    public void setUp() {
        ArrayList<String> sampleStudentInfo = new ArrayList<>();
        sampleStudentInfo.add("mackeyjonah"); // utorid
        sampleStudentInfo.add("password!"); // password
        sampleStudentInfo.add("Jonah"); // first name
        sampleStudentInfo.add("Mackey"); // last name
        sampleStudentInfo.add("student"); // status
        sampleStudentInfo.add("1234567890"); // ID number
        sampleStudentInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleStudentInfo.add("4"); // year
        sampleStudentInfo.add("Math"); // program

        sampleStudent = new Student(sampleStudentInfo);
    }


    @After
    public void tearDown() {
        sampleStudent = null;
    }
}