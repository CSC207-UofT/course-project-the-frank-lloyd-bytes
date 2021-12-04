package usecases;

import entities.Discount;
import entities.Faculty;
import entities.Student;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class DiscountHelperTest extends TestCase {
    Discount sampleDiscount1;
    Discount sampleDiscount2;
    Discount sampleDiscount3;
    Discount sampleDiscount4;
    Discount sampleDiscount5;
    List<Discount> sampleDiscountList = new ArrayList<>();
    Student sampleStudent;
    Faculty sampleFaculty;
    DiscountHelper sampleDiscountHelper;

    public void setUp() throws Exception {
        super.setUp();

        // create sample discounts
        sampleDiscount1 = new Discount("1:(item1):(1/2).(MAT/PHY):(5/6).(APM/CS)");
        sampleDiscount2 = new Discount("2:(item2):(3/4).(MAT/PHY):(4/5).(APM/CS)");
        sampleDiscount3 = new Discount("3:(item3):(1/2).(APM/CS):(4/5).(MAT/PHY)");
        sampleDiscount4 = new Discount("4:(item4):(any).(any):().()");
        sampleDiscount5 = new Discount("5:(item5):().():(any).(any)");

        sampleDiscountList.add(sampleDiscount1);
        sampleDiscountList.add(sampleDiscount2);
        sampleDiscountList.add(sampleDiscount3);
        sampleDiscountList.add(sampleDiscount4);
        sampleDiscountList.add(sampleDiscount5);

        // create sample student
        ArrayList<String> sampleStudentInfo = new ArrayList<>();
        sampleStudentInfo.add("mackeyjonah"); // utorid
        sampleStudentInfo.add("password!"); // password
        sampleStudentInfo.add("Jonah"); // first name
        sampleStudentInfo.add("Mackey"); // last name
        sampleStudentInfo.add("student"); // status
        sampleStudentInfo.add("1234567890"); // ID number
        sampleStudentInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleStudentInfo.add("1"); // year
        sampleStudentInfo.add("MAT"); // program

        sampleStudent = new Student(sampleStudentInfo);

        // create sample faculty
        ArrayList<String> sampleFacultyInfo = new ArrayList<>();
        sampleFacultyInfo.add("mackeyjonah"); // utorid
        sampleFacultyInfo.add("password!"); // password
        sampleFacultyInfo.add("Jonah"); // first name
        sampleFacultyInfo.add("Mackey"); // last name
        sampleFacultyInfo.add("faculty"); // status
        sampleFacultyInfo.add("1234567890"); // ID number
        sampleFacultyInfo.add("jonah.mackey@mail.utoronto.ca"); // email
        sampleFacultyInfo.add("4"); // year
        sampleFacultyInfo.add("APM"); // department

        sampleFaculty = new Faculty(sampleFacultyInfo);

        // create sample discount helper
        sampleDiscountHelper = new DiscountHelper();
    }

    public void testGetApplicableDiscounts() {
        List<String> expectedDiscountsStudent = new ArrayList<>();
        expectedDiscountsStudent.add("1% off on item1!");
        expectedDiscountsStudent.add("4% off on item4!");

        assertEquals(expectedDiscountsStudent, sampleDiscountHelper.getApplicableDiscounts(sampleDiscountList,
                sampleStudent));

        List<String> expectedDiscountsFaculty = new ArrayList<>();
        expectedDiscountsFaculty.add("2% off on item2!");
        expectedDiscountsFaculty.add("5% off on item5!");

        assertEquals(expectedDiscountsFaculty, sampleDiscountHelper.getApplicableDiscounts(sampleDiscountList,
                sampleFaculty));
    }
}