package usecases;

import entities.Discount;
import entities.Faculty;
import entities.Student;
import entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountHelper {

    private boolean studentDiscountApplicable(String studentDiscountCriteria, Student student) {
        String[] studentCriteriaArray = studentDiscountCriteria.split("\\.");

        List<String> yearCriteria = getSubCriteriaList(studentCriteriaArray[0]);
        List<String> programCriteria = getSubCriteriaList(studentCriteriaArray[1]);

        boolean yearCriteriaSatisfied = yearCriteria.contains(student.getProfile().get(student.STUDENT_YEAR));
        boolean programCriteriaSatisfied = programCriteria.contains(student.getProfile().get(student.STUDENT_PROGRAM));

        return (yearCriteriaSatisfied & programCriteriaSatisfied);
    }

    private boolean facultyDiscountApplicable(String facultyDiscountCriteria, Faculty faculty) {
        String[] facultyCriteriaArray = facultyDiscountCriteria.split("\\.");

        List<String> yearCriteria = getSubCriteriaList(facultyCriteriaArray[0]);
        List<String> departmentCriteria = getSubCriteriaList(facultyCriteriaArray[1]);

        boolean yearCriteriaSatisfied = yearCriteria.contains(faculty.getProfile().get(faculty.FACULTY_YEAR));
        boolean programCriteriaSatisfied = departmentCriteria.contains(faculty.getProfile().get(faculty.FACULTY_DEPARTMENT));

        return (yearCriteriaSatisfied & programCriteriaSatisfied);
    }

    private List<String> getSubCriteriaList(String subCriteria) {
        String[] subCriteriaArray = subCriteria.substring(subCriteria.indexOf("(") + 1, subCriteria.indexOf(")")).
                split("/");
        return Arrays.asList(subCriteriaArray);
    }

    private boolean discountApplicable(Discount discount, User user) {
        String[] discountCriteriaArray = discount.getCriteria().split(":");

        if (user.getProfile().get(user.STATUS).equals("student")) {
            return studentDiscountApplicable(discountCriteriaArray[0], (Student) user);
        }  else {
            return facultyDiscountApplicable(discountCriteriaArray[1], (Faculty) user);
        }
    }

    public List<String> getApplicableDiscounts(List<Discount> discounts, User user) {
        List<String> applicableDiscounts = new ArrayList<>();

        for (Discount discount : discounts) {
            if (discountApplicable(discount, user)) {
                applicableDiscounts.add(discount.discountString());
            }
        }
        return applicableDiscounts;
    }
}
