package usecases;

import entities.Discount;
import entities.Faculty;
import entities.Student;
import entities.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Use case class that provides all necessary functionality relating to Discount objects.
 */
public class DiscountHelper {

    public List<String> getApplicableDiscounts(List<Discount> discounts, User user) {
        List<String> applicableDiscounts = new ArrayList<>();

        for (Discount discount : discounts) {
            if (discountApplicable(discount, user)) {
                applicableDiscounts.add(discount.toString());
            }
        }
        return applicableDiscounts;
    }

    /**
     * Helper method that asses if a given student satisfies a discounts student criteria.
     * @param studentDiscountCriteria a string containing a discounts student criteria.
     * @param student a Student object
     * @return true if the student satisfies the criteria, false if the student does not satisfy the criteria.
     */
    private boolean studentDiscountApplicable(String studentDiscountCriteria, Student student) {
        String[] studentCriteriaArray = studentDiscountCriteria.split("\\.");

        List<String> yearCriteria = getSubCriteriaList(studentCriteriaArray[0]);
        List<String> programCriteria = getSubCriteriaList(studentCriteriaArray[1]);

        boolean yearCriteriaSatisfied = yearCriteria.contains(student.getSTUDENT_YEAR()) ||
                yearCriteria.contains("any");

        boolean programCriteriaSatisfied = programCriteria.contains(student.getSTUDENT_PROGRAM())
                || programCriteria.contains("any");

        return (yearCriteriaSatisfied & programCriteriaSatisfied);
    }

    /**
     * Helper method that asses if a given faculty member satisfies a discounts faculty criteria.
     * @param facultyDiscountCriteria a string containing a discounts faculty criteria.
     * @param faculty a Faculty object
     * @return true if the faculty satisfies the criteria, false if the faculty does not satisfy the criteria.
     */
    private boolean facultyDiscountApplicable(String facultyDiscountCriteria, Faculty faculty) {
        String[] facultyCriteriaArray = facultyDiscountCriteria.split("\\.");

        List<String> yearCriteria = getSubCriteriaList(facultyCriteriaArray[0]);
        List<String> departmentCriteria = getSubCriteriaList(facultyCriteriaArray[1]);

        boolean yearCriteriaSatisfied = yearCriteria.contains(faculty.getFACULTY_YEAR()) ||
                yearCriteria.contains("any");

        boolean departmentCriteriaSatisfied = departmentCriteria.contains(faculty.getFACULTY_DEPARTMENT())
                || departmentCriteria.contains("any");

        return (yearCriteriaSatisfied & departmentCriteriaSatisfied);
    }

    /**
     * Helper method to reformat a string containing conditions for a certain field of criteria as a list.
     * @param subCriteria conditions for a certain field of criteria, represented as a string.
     * @return A list of string, each string represents a condition for the field of criteria.
     */
    private List<String> getSubCriteriaList(String subCriteria) {
        String[] subCriteriaArray = subCriteria.substring(subCriteria.indexOf("(") + 1, subCriteria.indexOf(")")).
                split("/");
        return Arrays.asList(subCriteriaArray);
    }

    /**
     * Given a discount and user, this method determins if the user satisfies the discounts criteria.
     * @param discount a Discount object
     * @param user a User object
     * @return true if the user satisfies the criteria, false if the user does not satisfy the criteria.
     */
    private boolean discountApplicable(Discount discount, User user) {
        String[] discountCriteriaArray = discount.getCriteria().split(":");

        if (user.getSTATUS().equals("Student")) {
            return studentDiscountApplicable(discountCriteriaArray[0], (Student) user);
        }  else {
            return facultyDiscountApplicable(discountCriteriaArray[1], (Faculty) user);
        }
    }
}
