import java.util.ArrayList;

/**
 * Class student is a child class of User, it initializes an instance of
 * student user class, stores student data and profile, T card, unique ID
 *
 * TODO Attributes and Representational Invariants
 *
 *
 */

public class Student extends User{
    public Student(String utorID, String password, String status, ArrayList<String> accesses) {
        super(utorID, password, status, accesses);
    }

    @Override
    public String profileDisplay() {
        // TODO: finish writing method
    }
}
